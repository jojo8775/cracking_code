package interview.cracking_interview.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hard_Prob13 {
	public List<String> findWords(Dictionary dict, char[][] grid) {
		List<String> result = new ArrayList<String>();

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				findWord(result, dict, new StringBuilder(), i, j, grid);
			}
		}

		return result;
	}

	private void findWord(List<String> result, Dictionary dict, StringBuilder sb, int idx1, int idx2, char[][] grid) {
		sb.append(grid[idx1][idx2]);

		if (!dict.isPrefix(sb.toString())) {
			return;
		}

		if (dict.isWord(sb.toString())) {
			result.add(sb.toString());
		}

		if (idx1 + 1 < grid.length) {
			findWord(result, dict, sb, idx1 + 1, idx2, grid);
			sb.deleteCharAt(sb.length() -1 );
		}

		if (idx2 + 1 < grid[idx1].length) {
			findWord(result, dict, sb, idx1, idx2 + 1, grid);
			sb.deleteCharAt(sb.length() -1 );
		}
	}

	private static class Dictionary {
		private TrieNode head;

		public Dictionary(List<String> list) {
			head = new TrieNode();
			for (String s : list) {
				TrieNode node = head;
				for (char ch : s.toCharArray()) {
					TrieNode temp = node.map.get(ch);
					if (temp == null) {
						temp = new TrieNode();
						node.map.put(ch, temp);
					}

					node = temp;
				}
				node.isEnd = true;
			}
		}

		public boolean isPrefix(String str) {
			TrieNode node = head;
			int count = 0;
			while (node != null && count < str.length()) {
				TrieNode temp = node.map.get(str.charAt(count++));
				node = temp;
			}

			return node != null;
		}

		public boolean isWord(String str) {
			TrieNode node = head;
			int count = 0;
			while (node != null && count < str.length()) {
				TrieNode temp = node.map.get(str.charAt(count++));
				node = temp;
			}

			return node == null ? false : node.isEnd;
		}
	}

	private static class TrieNode {
		Map<Character, TrieNode> map = new HashMap<Character, TrieNode>();
		boolean isEnd;
	}

	public static void main(String[] args) {
		Dictionary dict = new Dictionary(Arrays.asList("has", "as", "her", "tool"));
		char[][] grid = new char[4][];
		grid[0] = new char[] { 't', 'h', 'a', 's' };
		grid[1] = new char[] { 'o', 'h', 'e', 's' };
		grid[2] = new char[] { 'o', 'h', 'r', 'e' };
		grid[3] = new char[] { 'l', 'x', 'y', 'z' };

		List<String> result = new Hard_Prob13().findWords(dict, grid);
		print(result);
	}

	private static void print(List<String> list) {
		for (String s : list) {
			System.out.println(s);
		}
	}
}
