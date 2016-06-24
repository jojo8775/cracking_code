package interview.cracking_interview.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Write an algorithm to print all ways of arranging eight queens on a chess
 * board so that none of them share the same row, column or diagonal.
 * 
 * @author jojo
 *
 */
public class NQueen {
	public List<List<Integer>> sol(int queens){
		if(queens < 4){
			return new ArrayList<List<Integer>>();
		}
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		sol(result, 0, queens, new Integer[queens]);
		
		return result;
	}
	
	private void sol(List<List<Integer>> result, int col, int queens, Integer[] arr){
		if(col == queens){
			result.add(new ArrayList<Integer>(Arrays.asList(arr)));
			return;
		}
		
		for(int i=0;  i< queens; i++){
			arr[col] = i;
			if(safe(arr, col)){
				sol(result, col+1, queens, arr);
			}
//			arr[i] = 0;
		}
	}
	
	private boolean safe(Integer[] arr, int idx){
		for(int i=0; i<idx; i++){
			int diff = Math.abs(arr[i] - arr[idx]);
			if(diff == 0 || diff == idx - i){
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args){
		List<List<Integer>> result = new NQueen().sol(8);
		
		for(List<Integer> l : result){
			for(int i=0; i<l.size(); i++){
				StringBuilder sb = new StringBuilder();
				for(int j=0; j<l.size(); j++){
					if(l.get(j) == i){
						sb.append(1);
					}
					else{
						sb.append(0);
					}
					
					sb.append(", ");
				}
				
				System.out.println(sb.toString());
			}
			
			System.out.println("================");
		}
	}
}
