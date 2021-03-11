package debugLaicode;

import java.util.*;

/**
 *
 * sol1:
 * can't remember
 *
 * sol2:
 * use HashSet to deduplicate
 *
 *
 * */
public class Subset2 {
    //2020
    public List<String> subSets(String set) {
        // Write your solution here.
        Set<String> res = new HashSet<>();

        if (set == null) {
            return new ArrayList();
        }

        char[] array = set.toCharArray();
        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();
        dfs(res, array, 0, sb);

        return new ArrayList<>(res);
    }

    private void dfs(Set<String> res,
                     char[] arr,
                     int i,
                     StringBuilder sb) {

        //System.out.println(sb.toString());
        // base-case
        if (i == arr.length) {
            res.add(sb.toString());
            return;
        }

        // recursion rule
        // case 1, add array[index]
        sb.append(arr[i]);
        dfs(res, arr, i + 1, sb);
        // remember to remove the add element when back tracking to the parent state
        // back-tracking
        sb.deleteCharAt(sb.length() - 1);

        // case 2, not add array[index]
        dfs(res, arr, i + 1, sb);
    }


//    public List<String> subSets(String set) {
//        // Write your solution here.
//        List<String> result = new ArrayList<>();
//
//        if (set == null) {
//            return result;
//        }
//
//        char[] array = set.toCharArray();
//        Arrays.sort(array);
//        StringBuilder sb = new StringBuilder();
//        dfs(result, array, 0, sb);
//        return result;
//    }
//
//    private void dfs(List<String> result,
//                     char[] array,
//                     int index,
//                     StringBuilder sb) {
//
//        //System.out.println(sb.toString());
//        // base-case
//        if (index == array.length) {
//            result.add(sb.toString());
//            return;
//        }
//
//        // recursion rule
//        // case 1, add array[index]
//        sb.append(array[index]);
//        dfs(result, array, index + 1, sb);
//        // remember to remove the add element when back tracking to
//        // the parent node
//        // back-tracking
//        sb.deleteCharAt(sb.length() - 1);
//
//        // case 2, not add array[index]
//        // skip all the same and consecutive characters
//        while (index + 1 < array.length && array[index] == array[index + 1]) {
//            index++;
//        }
//        dfs(result, array, index + 1, sb);
//    }

    public static void main(String[] args) {
        Subset2 sol = new Subset2();
        System.out.println(sol.subSets("cccabcd"));
    }
}
