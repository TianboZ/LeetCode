package debugLaicode;

import java.util.ArrayList;
import java.util.List;

public class Subset {

    public static void main(String[] args) {
        Subset subset = new Subset();
        System.out.println(subset.subSets("abcd"));

    }
    public List<String> subSets(String set) {
        // Write your solution here.
        List<String> result = new ArrayList<String>();

        if (set == null) {
            return result;
        }

        char[] array = set.toCharArray();
        StringBuilder sb = new StringBuilder();
        helper(result, array, 0, sb);
        return result;
    }

    public void helper(List<String> result,
                       char[] array,
                       int index,
                       StringBuilder sb) {

        //System.out.println(sb.toString());
        // base-case
        if (index == array.length) {
            result.add(sb.toString());
            return;
        }

        // recursion rule
        // case 1, add
        sb.append(array[index]);
        helper(result, array, index + 1, sb);
        // remember to remove the add element when back tracking to
        // the parent node
        // back-tracking
        sb.deleteCharAt(sb.length() - 1);

        // case 2, not add
        helper(result, array, index + 1, sb);
    }
}