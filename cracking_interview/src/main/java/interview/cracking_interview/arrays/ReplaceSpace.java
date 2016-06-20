package interview.cracking_interview.arrays;

/**
 * Write a method to replace all spaces in a string with ‘%20’.
 * 
 * @author jojo
 *
 */
public class ReplaceSpace {
	public String replaceSpace(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				sb.append("\0");
			} else {
				sb.append(str.charAt(i));
			}
		}

		return sb.toString();
	}
}
