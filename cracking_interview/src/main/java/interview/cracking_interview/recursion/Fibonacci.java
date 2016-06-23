package interview.cracking_interview.recursion;

/**
 * Find  fibonacci
 * @author jojo
 *
 */
public class Fibonacci
{
	public int findFibo(int num){
		int prev = -1, cur = 1;
		
		for(int i=0; i<num; i++){
			int temp = cur;
			cur = cur + prev;
			prev = temp;
			
			System.out.print(cur + ", ");
		}
		
		return cur;
	}
	
	public static void main(String[] args){
		new Fibonacci().findFibo(15);
	}
}
