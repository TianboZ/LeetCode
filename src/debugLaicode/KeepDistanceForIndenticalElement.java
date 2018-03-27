package debugLaicode;


import java.util.*;

public class KeepDistanceForIndenticalElement {
    public static void main(String[] args) {
        KeepDistanceForIndenticalElement keepDistanceForIndenticalElement = new KeepDistanceForIndenticalElement();
        keepDistanceForIndenticalElement.keepDistance(8);

    }


//    boolean found;
//    public int[] keepDistance(int k) {
//        // Write your solution here.
//
//        int[] arr = new int[k];
//        int[] remain = new int[k];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = i + 1;
//            remain[i] = 2;
//        }
//
//        List<Integer> list = new ArrayList<>();
//        List<List<Integer>> res = new ArrayList<List<Integer>>();
//        dfs(arr, 0, list, res, k, remain);
//        if (res.size() == 0) {
//            return null;
//        }
//        int[] result = new int[2 * k];
//        for (int j = 0; j < result.length; j++) {
//            result[j] = res.get(0).get(j);
//        }
//
//        return result;
//    }
//
//    public void dfs(int[] arr, int index, List<Integer> list, List<List<Integer>> res, int k, int[] remain) {
//        // base-case
////        if (found) {
////            return;
////        }
//        int sum = 0;
//        for (int j : remain) {
//            if (j < 0) {
//                return;
//            } else {
//                sum = sum + j;
//            }
//        }
//        if (sum == 0 && list.size() == arr.length * 2) {
//            res.add(new ArrayList<>(list));
//            //found = true;
//            System.out.println(list);
//            return;
//        }
//        // recursive rule
//        for (int i = 0; i < arr.length; i++) {
//            int num = arr[i];
//            int lastIndex = list.lastIndexOf(num);
//            if (lastIndex == -1) {
//                // not exist
//                list.add(num);
//                remain[i]--;
//                dfs(arr, index + 1, list, res, k, remain);
//                remain[i]++;
//                list.remove(list.size() - 1);
//            } else if (index - lastIndex - 1 > 0 && index - lastIndex - 1 == num){
//                list.add(num);
//                remain[i]--;
//                dfs(arr, index + 1, list, res, k, remain);
//                remain[i]++;
//                list.remove(list.size() - 1);
//            }
//        }
//    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




    public int[] keepDistance(int k) {
        // Write your solution here.
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0) {
            return null;
        }

        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = i+1;
            System.out.println(arr[i]);
        }

        int[] remain = new int[k];
        for (int i = 0; i < k; i++) {
            remain[i] = 2;
            System.out.println(arr[i]);
        }
        dfs(arr, k, list, res, remain);
        if (res.size() == 0) {
            return null;
        } else {
            System.out.println("final sol: ");
            System.out.println(res.get(0));
            int[] result = new int[2 * k];
            int i = 0;
            for (Integer element : res.get(0)) {
                result[i] = element;
                i++;
            }
            return result;
        }

    }
    public void dfs(int[] arr, int k, List<Integer> list, List<List<Integer>> res, int[] remain) {
        // base-case
        if (list.size() == 2 * k) {
            boolean left = false;
            for (int i : remain) {
                if (i != 0) {
                    left = true;
                }
            }
            if (!left) {
                res.add(new ArrayList<>(list));
                System.out.println(list);
            }
            return;
        }
        // recursive rule
        for (int i = 0; i < arr.length; i++) {
            if (remain[i] > 0) {
                int index = list.lastIndexOf(arr[i]);
                if (index != -1 && list.size() - index - 1 == arr[i]) {
                    remain[i]--;
                    list.add(arr[i]);
                    dfs(arr, k, list, res, remain);
                    remain[i]++;
                    list.remove(list.size() - 1);
                } else if (index == -1) {
                    remain[i]--;
                    list.add(arr[i]);
                    dfs(arr, k, list, res, remain);
                    remain[i]++;
                    list.remove(list.size() - 1);
                }
            }
        }
    }

}
