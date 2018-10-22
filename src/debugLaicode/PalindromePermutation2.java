package debugLaicode;

import java.util.*;

/*

solution:
steps:
1. count each character's frequency       map<key: char, value: frenquency>
2. if there is more than one char that its frequency is odd, then there is no palindrome for input string
3. we create a half length of input string
    e.g. if input is "aabbcccc" , then we can get "abcc"
    then we get all the permutation of "abcc"
    for each permutation, reverse it, and connect original and reversed string. e.g. "abcc" + "ccba" = "abccccba"

time O((n/2)!)
sapce O(n)

n is s.length()
*/

public class PalindromePermutation2 {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        // sanity check
        if (s == null || s.length() == 0) return res;

        // key: char  value: frequency
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer count = map.get(c);
            if (count == null) {
                map.put(c, 1);
            } else {
                map.put(c, 1 + count);
            }
        }

        int num = 0;
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            if (entry.getValue() % 2 != 0) num++;
        }
        if (num > 1) return res; // input s cannot be palindrome

        StringBuilder sb = new StringBuilder();
        char c = '!';

        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            int count = entry.getValue();
            if (count % 2 != 0) {
                c = entry.getKey();
            }
            count = count / 2;
            for (int i = 0; i < count; i++) {
                sb.append(entry.getKey());
            }
        }

        char[] arr = sb.toString().toCharArray();
        dfs(arr, 0, res, c);
        return res;
    }
    private void dfs(char[] arr, int index, List<String> res, char c) {
        // base-case
        if (index == arr.length) {
            String left = new String(arr);
            StringBuilder tmpt = new StringBuilder(left);
            String right = tmpt.reverse().toString();

            if (c == '!') {
                res.add(left + right);
            } else {
                res.add(left + Character.toString(c) + right);
            }
            return;
        }
        // recursive rule
        Set<Character> set = new HashSet<>();
        for (int i = index; i < arr.length; i++) {
            if (set.add(arr[i])) {
                swap(arr, i, index);
                dfs(arr, index + 1, res, c);
                swap(arr, i, index);
            }
        }
    }
    private void swap(char[] arr, int i, int j) {
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }
}
