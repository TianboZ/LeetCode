package debugLaicode;


import java.util.*;

public class GrayCode {

    public static void main(String[] args) {
        GrayCode grayCode = new GrayCode();
        grayCode.graycode(2);
    }
    public List<Integer> graycode(int n) {
        //Input your code here

        System.out.println((int)Math.pow(2, n));

        List<Integer> res = new ArrayList<>();
        char[] arr = new char[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = '0';
        }
        Set<String> set = new LinkedHashSet<>();
        set.add(String.valueOf(arr));
        dfs(res, arr, set, (int)Math.pow(2, n));
        System.out.println(res);
        return res;
    }
    private boolean dfs(List<Integer> res, char[] arr, Set<String> set, int n) {
        // base-case
        if (set.size() == n) {

            for (String binaryString : set) {
                res.add(Integer.parseInt(binaryString,2));
            }
            return true;
        }
        // recursive rule
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]=='1') {
                arr[i] = '0';
            } else {
                arr[i] = '1';
            }
            String s = String.valueOf(arr);
            if (!set.contains(s)) {
                set.add(s);
                System.out.println(s);

                if (dfs(res, arr, set, n)) {
                    return true;
                }
                set.remove(s);
            }
            if (arr[i]=='1') {
                arr[i] = '0';
            } else {
                arr[i] = '1';
            }
        }
        return false;
    }
}
