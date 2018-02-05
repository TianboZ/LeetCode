package debugLaicode;


import java.util.*;

public class KeepDistanceForIndenticalElement {
    public static void main(String[] args) {
        KeepDistanceForIndenticalElement keepDistanceForIndenticalElement = new KeepDistanceForIndenticalElement();
        keepDistanceForIndenticalElement.keepDistance(7);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        System.out.printf("last index of 1: " + list.lastIndexOf(1));
    }


    boolean found;
    public int[] keepDistance(int k) {
        // Write your solution here.

        int[] arr = new int[k];
        int[] remain = new int[k];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
            remain[i] = 2;
        }

        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(arr, 0, list, res, k, remain);
        if (res.size() == 0) {
            return null;
        }
        int[] result = new int[2 * k];
        for (int j = 0; j < result.length; j++) {
            result[j] = res.get(0).get(j);
        }

        return result;
    }

    public void dfs(int[] arr, int index, List<Integer> list, List<List<Integer>> res, int k, int[] remain) {
        // base-case
        if (found) {
            return;
        }
        int sum = 0;
        for (int j : remain) {
            if (j < 0) {
                return;
            } else {
                sum = sum + j;
            }
        }
        if (sum == 0 && list.size() == arr.length * 2) {
            res.add(new ArrayList<>(list));
            found = true;
            System.out.println(list);
            return;
        }
        // recursive rule
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int lastIndex = list.lastIndexOf(num);
            if (lastIndex == -1) {
                // not exist
                list.add(num);
                remain[i]--;
                dfs(arr, index + 1, list, res, k, remain);
                remain[i]++;
                list.remove(list.size() - 1);
            } else if (index - lastIndex - 1 > 0 && index - lastIndex - 1 == num){
                list.add(num);
                remain[i]--;
                dfs(arr, index + 1, list, res, k, remain);
                remain[i]++;
                list.remove(list.size() - 1);
            }
        }
    }

}
