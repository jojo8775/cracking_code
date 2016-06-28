package interview.cracking_interview.hard;

public class StringFinder {
	public boolean exist(String str1, String str2) {
		SuffixTree suffixTree = new SuffixTree(str1);

		if (suffixTree.getIndex(str2) != null) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		System.out.println(new StringFinder().exist("abcdefg", "fg"));
	}
}
