package interview.cracking_interview.hard;

/**
 * Add without using add operator
 * 
 * @author jojo
 *
 */
public class Hard_Prob1 {
	public int add(int num1, int num2) {
		int carry = 0;
		while (num1 != 0) {
			carry = num1 & num2;
			num2 = num1 ^ num2;
			num1 = carry << 1;
		}

		return num2;
	}
	
	public static void main(String[] args){
		System.out.println(new Hard_Prob1().add(-3, -5));
	}
}
