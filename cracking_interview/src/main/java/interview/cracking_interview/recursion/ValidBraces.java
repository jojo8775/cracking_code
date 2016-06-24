package interview.cracking_interview.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement an algorithm to print all valid (e.g., properly opened and closed) combi-
nations of n-pairs of parentheses.
EXAMPLE:
input: 3 (e.g., 3 pairs of parentheses)
output: ()()(), ()(()), (())(), ((()))
 * @author jojo
 *
 */
public class ValidBraces {
	public List<String> find(int num){
		List<String> result = new ArrayList<String>();
		find(new char[num*2], 0, result, num, num);
		
		return result;
	}
	
	private void find(char[] cArr, int idx, List<String> result, int left, int right){
		//this is the base case
		if(left == 0 && right == 0){
			result.add(String.valueOf(cArr));
			return ;
		}
		
		//this is the invalid case so terminate the execution
		if(left > right){
			return;
		}
		
		//try the left brace
		if(left > 0){
			cArr[idx] = '(';
			find(cArr, idx + 1, result, left - 1, right);
		}
		
		//then try right brace
		if(right > 0){
			cArr[idx] = ')';
			find(cArr, idx + 1, result, left, right - 1);
		}
	}
	
	public static void main(String[] args){
		List<String> result = new ValidBraces().find(4);
		
		for(String s : result){
			System.out.println(s);
		}
	}
}
