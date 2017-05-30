package interview.cracking_interview.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationIV {

public List<List<Integer>> findCombination(List<Integer> list, int target){
    List<List<Integer>> result = new ArrayList<>();
    
    Collections.sort(list);
    dfs(result, list, new ArrayList<Integer>(), target, 0);
    
    return result;
}

private void dfs(List<List<Integer>> result, List<Integer> input, List<Integer> entry, int target, int idx){
    if(target == 0){
        result.add(new ArrayList<Integer>(entry));
        return;
    }
    
    if(idx == input.size() || target < 0){
        return;
    }
    
    for(int i=idx; i<input.size(); i++){
        if(i > idx && input.get(i) == input.get(i-1)){
            continue;
        }
        
        entry.add(input.get(i));
        dfs(result, input, entry, target - input.get(i), i + 1);
        entry.remove(entry.size() - 1);
    }
}

}
