package interview.cracking_interview.amazon;

import java.util.ArrayList;
import java.util.List;

public class FindCombination {
    public List<List<Integer>> findCombinations(int n1, int n2){
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<Integer>(), n1, n2, 1);
        
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> entry, int n, int k, int idx){
        if(entry.size() == n){
            List<Integer> temp = new ArrayList<>(entry);
            result.add(temp);
            return;
        }
        
        for(int i = idx; i<k; i++){
            entry.add(i);
            dfs(result, entry, n, k, i + 1);
            entry.remove(entry.size() - 1);
        }
    }
    
    public static void main(String[] args){
        List<List<Integer>> result = new FindCombination().findCombinations(2, 5);
        for(List<Integer> list : result){
            for(int i : list){
                System.out.print(i + ", ");
            }
            System.out.println();
        }
    }
}
