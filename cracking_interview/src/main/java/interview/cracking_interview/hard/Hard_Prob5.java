package interview.cracking_interview.hard;

public class Hard_Prob5 {
	public int findWordDistance(String[] words, String word1, String word2) {
		int idx1 = -1, idx2 = -1, diff = Integer.MAX_VALUE;

		for (int i = 0; i < words.length; i++) {
			if (word1.equals(word2)) {
				if (idx1 != -1 && idx1 > idx2) {
					idx2 = i;
				} else {
					idx1 = i;
				}
			} else {
				if (word1.equals(words[i])) {
					idx1 = i;
				} else if (word2.equals(words[i])) {
					idx2 = i;
				}
			}

			if (idx1 != -1 && idx2 != -1) {
				diff = Math.min(diff, Math.abs(idx1 - idx2));
			}
		}

		return diff == Integer.MAX_VALUE ? -1 : diff;
	}
}
