package interview.cracking_interview.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromCombination {
    public List<List<String>> findPalindromPartisions(String str) {
        List<List<String>> result = new ArrayList<>();
        find(result, new ArrayList<String>(), str, 0, new HashMap<String, Boolean>());

        return result;
    }

    private void find(List<List<String>> result, List<String> entry, String input, int idx,
            Map<String, Boolean> cache) {
        if (idx == input.length()) {
            result.add(new ArrayList<String>(entry));
            return;
        }

        for (int i = idx; i < input.length(); i++) {
            String substr = input.substring(idx, i + 1);
            boolean status = cache.containsKey(substr) ? cache.get(substr) : isPalindrom(input, idx, i);
            cache.put(substr, status);

            if (!status) {
                continue;
            }

            entry.add(substr);
            find(result, entry, input, i + 1, cache);
            entry.remove(entry.size() - 1);
        }
    }

    private boolean isPalindrom(String str, int beg, int end) {
        while (beg < end) {
            if (str.charAt(beg++) != str.charAt(end--)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        List<List<String>> result = new PalindromCombination().findPalindromPartisions("aaaaaaaaaabbbbbbbbbbba");

        for (List<String> entry : result) {
            for (String s : entry) {
                System.out.print(s + ", ");
            }

            System.out.println();
        }
        
        System.out.println("result count : " + result.size());
    }
}
