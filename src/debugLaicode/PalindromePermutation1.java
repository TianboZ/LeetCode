package debugLaicode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*

sol0:
get all permutation of string, check if there exist a palindrome  time o(n!) space o(n)

sol1:
case1 s.length == odd
only one character, its frequency % 2 == 1  e.g. 111
else it is not

case2 s.length == even
for all character, its frequency % 2 must == 0  e.g. 1236666321
else it is not


map<key: char, value: frequency>  time o(n)   space o(n)

sol2:
use hashset
iterate each character in the string
    if the character not in the set, add to set
    else remove it from the set

at last, if input string can form palindrome, then there should be <= 1 element left in the set
time O(n) space O(n)

*/
public class PalindromePermutation1 {
    public boolean canPermutePalindrome(String s) {
        // sanity check
        if (s == null || s.length() == 0) return false;

        Set<Character> set =new  HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
            } else {
                set.remove(c);
            }
        }
        return set.size() <= 1;
    }
}