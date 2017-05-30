package interview.cracking_interview.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permute {
    public List<List<Integer>> findPermutations(List<Integer> list) {
        Collections.sort(list);

        List<List<Integer>> result = new ArrayList<>();
        permute(result, list, new ArrayList<Integer>(), new HashSet<Integer>());
        return result;
    }

    private void permute(List<List<Integer>> result, List<Integer> input, List<Integer> entry, Set<Integer> visited) {
        if (entry.size() == input.size()) {
            result.add(new ArrayList<Integer>(entry));
            return;
        }

        for (int i = 0; i < input.size(); i++) {
            if (visited.contains(i) || (i > 0 && input.get(i - 1) == input.get(i) && !visited.contains(i - 1))) {
                continue;
            }
            
            visited.add(i);
            entry.add(input.get(i));
            permute(result, input, entry, visited);
            entry.remove(entry.size() - 1);
            visited.remove(i);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new Permute().findPermutations(Arrays.asList(1,1,1,2));
        for (List<Integer> entry : result) {
            for (int i : entry) {
                System.out.print(i + ", ");
            }

            System.out.println();
        }
    }
}
