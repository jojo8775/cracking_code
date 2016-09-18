package interview.cracking_interview.hard;

/**
 * Shuffle deck of card
 * 
 * @author jojo
 *
 */
public class Hard_Prob2 {
	public int shuffle(){
		return 1 + (int) (Math.random() * (52 - 1 + 1)); 
	}
	
	public static void main(String[] args){
		for(int i=0; i<10; i++){
			System.out.println(new Hard_Prob2().shuffle());
		}
	}
}
