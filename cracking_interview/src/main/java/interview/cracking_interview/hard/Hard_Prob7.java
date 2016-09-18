package interview.cracking_interview.hard;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hard_Prob7 {
	public String findTheLongest(List<String> words) {
		Collections.sort(words, (String s1, String s2) -> s2.length() - s1.length());

		int maxLength = -1, strIdx = -1;
		Set<String> dict = new HashSet<String>(words);
		for (int i = 0; i < words.size(); i++) {
			String s = words.get(i);
			if (maxLength != -1 && maxLength >= s.length()) {
				break;
			}

			Set<String> visited = new HashSet<String>();
			visited.add(s);

			if (isValid(s, visited, dict, 0)) {
				maxLength = Math.max(maxLength, s.length());
				strIdx = i;
			}
		}

		return strIdx == -1 ? null : words.get(strIdx);
	}

	private boolean isValid(String str, Set<String> visited, Set<String> dict, int idx) {
		if (idx == str.length()) {
			return true;
		}

		for (int i = idx; i < str.length(); i++) {
			String subStr = str.substring(idx, i + 1);
			if (dict.contains(subStr) && visited.add(subStr)) {
				if (isValid(str, visited, dict, i + 1)) {
					return true;
				} else {
					visited.remove(subStr);
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {
		System.out.println(new Hard_Prob7()
				.findTheLongest(Arrays.asList("test", "tester", "testertest", "testing", "testingtester", "testingtestertest")));
	}
}
