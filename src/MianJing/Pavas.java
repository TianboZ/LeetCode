package MianJing;

import debugLaicode.TreeNode;

import java.util.*;

public class Pavas {
    public int[] solution(int D, int[] A) {
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            res[i] = findDistance(i, A, D);
            //System.out.println(res[i]);
        }
        return res;
    }

    private int findDistance(int i, int[] A, int D) {
        while (D > 0) {
            i = A[i];
            if (i == -1) break;
            D--;
        }
        if (D == 0) return i;
        return -1;
    }

    public static void main(String[] args) {
        //int[] A = {-1, 0, 4, 2, 1};
        //solution(3, A);

        int[] arr = {1, 2, 3, 4, 5, 5, 4, 5, 2, 2};
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }
        dimention(arr);
        int res = degreeOfArray(list);
        System.out.println(res);
    }

    ///////////
    public static void dimention(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int k = 0; // initial
        //get dimention of arr
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            k = Math.max(k, map.get(i));
        }

        Map<Integer, Integer> count = new HashMap<>();
        int left = 0;
        int right = 0;
        int min = 1000000;

        while (right < arr.length) {
            // handle right pointer
            int num = arr[right];
            count.put(num, count.getOrDefault(num, 0) + 1);
            int curr = getDimention(count);

            // handle left pointer
            while (curr == k) {
                // update min length
                if (right - left + 1 < min) {
                    System.out.println("solution: ");
                    for (int j = left; j <= right; j++) {
                        System.out.println(arr[j]);
                    }
                    min = right - left + 1;
                }

                num = arr[left];
                if (count.containsKey(num)) {
                    if (count.get(num) == 1) {
                        count.remove(num);
                    } else {
                        count.put(num, count.get(num) - 1);
                    }
                }

                curr = getDimention(count);

                left++;
            }
            right++;
        }
    }

    private static int getDimention(Map<Integer, Integer> count) {
        int k = 0;
        for (Integer i : count.values()) {
            k = Math.max(k, i);
        }
        return k;
    }

    public static int degreeOfArray(List<Integer> arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int degree = getDegree(map);


        Map<Integer, Integer> count = new HashMap<>();
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;

// sliding window
        while (right < arr.size()) {
            // handle right most pointer
            int num = arr.get(right);
            count.put(num, count.getOrDefault(num, 0) + 1);
            int currDegree = getDegree(count);

            // handle left most pointer
            while (currDegree == degree) {
                min = Math.min(min, right - left + 1);
                num = arr.get(left);
                if (count.containsKey(num)) {
                    if (count.get(num) == 1) {
                        count.remove(num);
                    } else {
                        count.put(num, count.get(num) - 1);
                    }
                }

                currDegree = getDegree(count);
                left++;
            }
            right++;
        }
        return Math.min(min, arr.size());
    }

    private static int getDegree(Map<Integer, Integer> map) {
        int k = 0;
        for (Integer i : map.values()) {
            k = Math.max(k, i);
        }
        return k;
    }

    //////////////////////////////////////////////////////////////////////////////
    public static List<String> missingWords(String s, String t) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;

        // string t
        String[] arr = t.split(" ");
        Map<String, Integer> map = new HashMap<>(); // count the word frequency
        for (String ss : arr) {
            map.put(ss, map.getOrDefault(ss, 0) + 1);
        }

        // string s
        String[] input = s.split(" ");


        int i = 0;
        int j = 0;
        while (i < arr.length && j < input.length) {
            if (arr[i].equals(input[j])) {
                i++;
                j++;
            } else {
                res.add(input[j]);
                j++;
            }
        }
        if (j < input.length) {
            res.add(input[j]);
            j++;
        }
        return res;
    }




}
