package interview.cracking_interview.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find sub set
 * @author jojo
 *
 */
public class SubSet
{
	public List<List<Integer>> find(List<Integer> list){
		return find(list, 0);
	}
	
	private List<List<Integer>> find(List<Integer> list, int idx){
		if(idx == list.size()){
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			result.add(new ArrayList<Integer>());
			return result;
		}
		
		else{
			List<List<Integer>> result = find(list, idx + 1);
			int item = list.get(idx);
			
			int len = result.size();
			for(int i=0; i<len; i++){
				List<Integer> temp = new ArrayList<Integer>(result.get(i));
				temp.add(item);
				result.add(temp);
			}
			
			return result;
		}
	}
	
	public List<List<Integer>> findSorted(List<Integer> list){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result.add(new ArrayList<Integer>());
		
		findSorted(result, list, 0);
		return result;
	}
	
	private void findSorted(List<List<Integer>> result, List<Integer> list, int idx){
		if(list.size() == idx){
			return;
		}
		else{
			int item = list.get(idx), len = result.size();
			for(int i=0; i<len; i++){
				List<Integer> temp = new ArrayList<Integer>(result.get(i));
				temp.add(item);
				result.add(temp);
			}
			
			findSorted(result, list, idx + 1);
		}
	}
	
	public static void main(String[] args){
//		List<List<Integer>> result = new SubSet().find(Arrays.asList(1,2,3));
		List<List<Integer>> result = new SubSet().findSorted(Arrays.asList(1,2,3));
		
		for(List<Integer> l : result){
			for(int i : l){
				System.out.print(i + ", ");
			}
			
			System.out.println();
		}
	}
}
