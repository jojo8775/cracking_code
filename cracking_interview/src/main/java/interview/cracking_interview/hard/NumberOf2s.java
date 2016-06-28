package interview.cracking_interview.hard;

public class NumberOf2s {
	public int findNum(int num){
		if(num == 0){
			return 0;
		}
		
		int power=1; 
		
		while(10 * power < num){
			power *= 10;
		}
		
		int first = num / power;
		int remainder = num % power;
		
		int first2s = 0;
		
		//taking care of the first number > 2
		if(first > 2){
			first2s = power;
		}
		
		//taking care of the first number > 2
		if(first == 2){
			first2s = remainder == 0 ? 1 : remainder;
		}
		
		int other2s = first * (findNum(power - 1)) + findNum(remainder);
		
		return first2s + other2s;
	}
	
	public static void main(String[] args){
		int result = new NumberOf2s().findNum(30);
		System.out.println(result);
	}
}
