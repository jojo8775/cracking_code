package interview.cracking_interview.hard;

public class AddWithoutOperator {
	public int add(int a, int b){
		int carry = 0;
		while(true){
			carry = a&b;
			a = a ^ b;
			if(carry == 0){
				break;
			}
			
			b = carry << 1;
		}
		
		return a;
	}
	
	public static void main(String[] args){
		int result = new AddWithoutOperator().add(15, 7);
		System.out.println(result);
	}
}
