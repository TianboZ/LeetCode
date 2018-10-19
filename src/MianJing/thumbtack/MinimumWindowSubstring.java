package MianJing.thumbtack;

import java.util.*;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        //init a collection or int value to save the result according the question.
        if(t.length()> s.length()) {
            String str = "";
            return str;
        }

        //create a hashmap to save the Characters of the target substring.
        //(K, V) = (Character, Frequence of the Characters)
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //maintain a counter to check whether match the target string.
        int counter = map.size();//must be the map size, NOT the string size because the char may be duplicate.

        int begin = 0, end = 0;
        int len = Integer.MAX_VALUE;

        int start = 0;

        //loop at the begining of the source string
        while(end < s.length()){
            // handle leftmost pointer
            char c = s.charAt(end);
            if( map.containsKey(c) ){
                map.put(c, map.get(c)-1);// plus or minus one
                if(map.get(c) == 0) counter--;//modify the counter according the requirement(different condition).
            }
            end++;

            // handle rightmost pointer
            while(counter == 0){
                c = s.charAt(begin);
                if(map.containsKey(c)){
                    map.put(c, map.get(c) + 1);//plus or minus one
                    if(map.get(c) > 0) counter++;//modify the counter according the requirement(different condition).
                }

                // update
                if (end - begin < len) {
                    start = begin;
                    len = end - begin;
                }

                begin++;
            }


        }
        if (len == Integer.MAX_VALUE) {
            String res = "";
            return res;
        } else {
            return s.substring(start, start + len);
        }

    }
}


/*
solution:
create a sliding window
use two pointers, left and right, they are the boundaries of the window

1. initial, left and right pointers are at 0-th element
2. move right pointer to right one by one, until [left, right] contains all the characters  in T
3. when [left, right] contains all the characters  in T, we start to move left pointer to right one by one, while update the shortest substring, until [left, right] does not contains all the characters  in T
4. repeat step 2


time O(m + n)   m = s.length   n = t.length
*/
class Solution {
    public String minWindow(String s, String t) {
        // sanity check
        if (t.length() > s.length()) return "";
        if (s == null || s.length() == 0 || t == null || t.length() == 0) return "";

        Map<Character, Integer> dict = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        countMap(dict, t);

        int left = 0;
        int right = 0;
        int match = 0;

        int l = 0; // final left index
        int r = 0; // final right index
        int min = Integer.MAX_VALUE;

        while (right < s.length()) {
            // handle right pointer
            char c  = s.charAt(right);
            // add char to window
            Integer num = window.get(c);
            if (num == null) {
                window.put(c, 1);
            } else {
                window.put(c, 1 + num);
            }
            if (dict.containsKey(c) && dict.get(c) == window.get(c)) match++;

            // handle left pointer
            while (left  <= right && match == dict.size()) {
                c = s.charAt(left);
                // update
                if (right - left + 1 < min) {
                    r = right;
                    l = left;
                    min = right - left + 1;
                    System.out.println(l + ", " + r);
                }

                // remove c from the window
                window.put(c, window.get(c) - 1);
                if (dict.containsKey(c) && window.get(c).intValue() < dict.get(c).intValue()) match--;
                // move left pointer
                left++;
            }

            // keep move right pointer
            right++;
        }

        return min == Integer.MAX_VALUE ? "" : s.substring(l, r + 1);
    }
    private void countMap(Map<Character, Integer> count, String t) {
        for (int i = 0; i < t.length(); i++) {
            Integer num = count.get(t.charAt(i));
            if (num == null) {
                count.put(t.charAt(i), 1);
            } else {
                count.put(t.charAt(i), 1 + num);
            }
        }
    }
}