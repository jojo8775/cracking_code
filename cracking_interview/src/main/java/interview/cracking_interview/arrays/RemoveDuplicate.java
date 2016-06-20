package interview.cracking_interview.arrays;

/**
 * Design an algorithm and write code to remove the duplicate characters in a
 * string without using any additional buffer. NOTE: One or two additional
 * variables are fine. An extra copy of the array is not. FOLLOW UP Write the
 * test cases for this method.
 * 
 * @author jojo
 *
 */
public class RemoveDuplicate {
	public String removeDuplicate(String str) {
		char[] ch = str.toCharArray();

		int temp = 1;
		for (int i = 1; i < ch.length; i++) {
			int j = 0;
			for (; j < temp; j++) {
				if (ch[j] == ch[i]) {
					break;
				}
			}

			if (j == temp) {
				ch[temp] = ch[i];
				temp++;
			}
		}

		if (temp < ch.length) {
			ch[temp] = '\0';
		}

		return String.valueOf(ch);
	}

	private String remove_usingExtraSpace(String str){
		int[] arr = new int[256];
		char[] ch = str.toCharArray();
		
		int temp = 0;
		for(int i=0; i<ch.length; i++){
			if(arr[ch[i]] == 0){
				ch[temp++] = ch[i];
				arr[ch[i]]++;
			}
		}
		
		if(temp < ch.length){
			ch[temp] = '\0';
		}
		
		return String.valueOf(ch);
	}
	
	public static void main(String[] args) {
		System.out.println(new RemoveDuplicate().removeDuplicate("aaabbac"));
		System.out.println(new RemoveDuplicate().removeDuplicate("abcd"));
		System.out.println(new RemoveDuplicate().removeDuplicate(""));
		
		System.out.println("---------------");
		
		System.out.println(new RemoveDuplicate().remove_usingExtraSpace("aaabbac"));
		System.out.println(new RemoveDuplicate().remove_usingExtraSpace("abcd"));
		System.out.println(new RemoveDuplicate().remove_usingExtraSpace(""));
	}
}
