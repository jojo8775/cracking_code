package interview.cracking_interview.arrays;

/**
 * Write a method to decide if two strings are anagrams or not.
 * 
 * @author jojo
 *
 */
public class Anagram {
	public boolean isAnagram(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}

		int[] arr = new int[256];

		for (int i = 0; i < str1.length(); i++) {
			arr[str1.charAt(i)]++;
		}

		for (int i = 0; i < str2.length(); i++) {
			if (arr[str2.charAt(i)] < 1) {
				return false;
			}
			arr[str2.charAt(i)]--;
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(new Anagram().isAnagram("god", "dog"));
	}
}
