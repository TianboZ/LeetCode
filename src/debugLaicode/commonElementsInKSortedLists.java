package debugLaicode;

import java.util.ArrayList;
import java.util.List;

public class commonElementsInKSortedLists {
    public List<Integer> commonElementsInKSortedArrays(List<List<Integer>> input) {
        // Write your solution here
        List<Integer> tmpt = input.get(0);
        for (int i = 1; i < input.size(); i++) {
            tmpt = helper(tmpt, input.get(i));
        }
        return tmpt;
    }

    // get common elemenents in 2 sorted lists
    private List<Integer> helper(List<Integer> a, List<Integer> b) {
        int i = 0;
        int j = 0;
        List<Integer> res = new ArrayList<>();
        while (i < a.size() && j < b.size()) {
            if (a.get(i) == b.get(j) ) {
                res.add(a.get(i));
                i++;
                j++;
            } else if (a.get(i) < b.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Integer a = new Integer(1);
        Integer b = 1;

        if (a == b) {
            System.out.println("a == b");
        }
    }
}
