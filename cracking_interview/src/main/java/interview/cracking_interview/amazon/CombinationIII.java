package interview.cracking_interview.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationIII {
    public List<List<Integer>> findCombination(List<Integer> list, int target) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(result, list, new ArrayList<Integer>(), 0, target);

        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> input, List<Integer> entry, int idx, int target) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(entry));
            return;
        }

        if (idx == input.size() || target < 0) {
            return;
        }

        if(idx > 0 && input.get(idx) == input.get(idx - 1)){
            dfs(result, input, entry, idx + 1, target);
        }
        else{
            entry.add(input.get(idx));
            dfs(result, input, entry, idx, target - input.get(idx));
            entry.remove(entry.size() - 1);
            dfs(result, input, entry, idx + 1, target);
        }
    }
    
    public static void main(String[] args){
        List<List<Integer>> result = new CombinationIII().findCombination(Arrays.asList(2,2,3,5,7), 7);
        
        for(List<Integer> entry : result){
            for(int i : entry){
                System.out.print(i + ", ");
            }
            
            System.out.println();
        }
    }
}
