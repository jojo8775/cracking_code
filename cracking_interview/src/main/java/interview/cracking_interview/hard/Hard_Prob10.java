package interview.cracking_interview.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hard_Prob10 {
	public List<String> findShortestPath(String beg, String end, Set<String> dict) {
		List<String> result = new ArrayList<String>();
		result.add(beg);
		dict.add(beg);
		dfs(result, beg, end, dict);
		return result;
	}

	private boolean dfs(List<String> path, String str, String end, Set<String> dict) {
		if (str.equals(end)) {
			return true;
		}

		char[] cArr = str.toCharArray();

		for (int i = 0; i < cArr.length; i++) {
			char ch = cArr[i];
			for (int j = 'a'; j <= 'z'; j++) {
				if (ch != (char) j) {
					cArr[i] = (char) j;
					String temp = String.valueOf(cArr);
					if (dict.contains(temp)) {
						dict.remove(temp);
						path.add(temp);
						if (dfs(path, temp, end, dict)) {
							return true;
						}
						dict.add(temp);
						path.remove(path.size() - 1);
					}
				}
			}
			cArr[i] = ch;
		}

		return false;
	}

	public static void main(String[] args) {
		List<String> result = new Hard_Prob10().findShortestPath("damp", "like",
				new HashSet<String>(Arrays.asList("lamp", "limp", "lime", "like")));
		
		print(result);
	}
	
	private static void print(List<String> path){
		for(String s : path){
			System.out.println(s);
		}
	}
}
