package interview.cracking_interview.recursion;

import java.util.ArrayList;
import java.util.List;

public class ValidBraces {
	public List<String> find(int num){
		List<String> result = new ArrayList<String>();
		find(new char[num*2], 0, result, num, num);
		
		return result;
	}
	
	private void find(char[] cArr, int idx, List<String> result, int left, int right){
		if(left == 0 && right == 0){
			result.add(String.valueOf(cArr));
			return ;
		}
		
		if(left > right){
			return;
		}
		
		if(left > 0){
			cArr[idx] = '(';
			find(cArr, idx + 1, result, left - 1, right);
		}
		
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
