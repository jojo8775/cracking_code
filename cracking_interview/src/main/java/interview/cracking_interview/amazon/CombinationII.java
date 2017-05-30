package interview.cracking_interview.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationII {
    public List<List<Integer>> findResult(List<Integer> list, int target) {
        List<Node> nodeList = new ArrayList<>();
        nodeList.add(new Node(0));

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            int len = nodeList.size();
            for (int j = 0; j < len; j++) {
                Node node1 = nodeList.get(j);
                Node node2 = new Node(node1.sum + list.get(i));
                node2.list = new ArrayList<Integer>(node1.list);
                node2.list.add(list.get(i));

                if (node2.sum == target) {
                    result.add(new ArrayList<Integer>(node2.list));
                }

                nodeList.add(node2);
            }
        }

        return result;
    }

    private static class Node {
        int sum;
        List<Integer> list = new ArrayList<>();

        public Node(int sum) {
            this.sum = sum;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new CombinationII().findResult(Arrays.asList(2, 2, 3, 6, 7), 7);

        for (List<Integer> entry : result) {
            for (int i : entry) {
                System.out.print(i + ", ");
            }

            System.out.println();
        }
    }
}
