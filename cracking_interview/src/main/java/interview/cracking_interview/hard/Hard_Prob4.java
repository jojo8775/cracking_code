package interview.cracking_interview.hard;

/**
 * Find number of 2's in the given range
 * 
 * @author jojo
 *
 */
public class Hard_Prob4 {
	public int findNumberOfTwos(int num) {
		if(num == 0){
			return 0;
		}
		
		int possition = 1, constant = 0, val = num;

		while (val > 10) {
			possition = possition * 10;
			val = val / 10;
		}

		if (val == 2) {
			constant = num % possition + 1;
			
		} 
		else if (val > 2) {
			constant = possition;
		}

		return constant + (val * findNumberOfTwos(possition - 1)) + findNumberOfTwos(num % possition);
	}
	
	public static void main(String[] args){
		System.out.println(new Hard_Prob4().findNumberOfTwos(20));
	}
}
