package debugLaicode;

import java.lang.reflect.Array;
import java.util.*;

public class IsPalindrome {
    public boolean test(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        char cHead, cTail;
        while(left <= right) {
            cHead = s.charAt(left);
            cTail = s.charAt(right);
            if (!Character.isLetterOrDigit(cHead)) {
                left++;
            } else if(!Character.isLetterOrDigit(cTail)) {
                right--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                left++;
                right--;
            }
        }

        return true;
    }
}
