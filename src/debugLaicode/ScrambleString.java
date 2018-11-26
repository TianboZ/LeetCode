package debugLaicode;


public class ScrambleString {
    public static void main(String[] args) {
        ScrambleString scrambleString = new ScrambleString();
        scrambleString.isScramble("abcd","abce");
    }
    public boolean isScramble(String s1, String s2) {
        // Write your solution here.
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        return isScramble(arr1, arr2, 0, arr1.length - 1, 0, arr2.length - 1);
    }
    public boolean isScramble(char[] arr1, char[] arr2, int left1, int right1, int left2, int right2) {
        // base-case
        if (left1  == right1) {
            return arr1[left1] == arr2[left2];
        }
        if (left1 + 1 == right1) {
            return arr1[left1] == arr2[left2] && arr1[right1] == arr2[right2]
                    || arr1[left1] == arr2[right2] && arr1[right1] == arr2[left2];
        }

        System.out.println("left1: " + left1 + " right1: " + right1 + "         left2: " + left2 + "  right2: " + right2);

        // recursive rule
        for (int i = left1 + 1; i < arr1.length; i++) {
            if (isScramble(arr1, arr2, left1, i - 1, left2, i - 1) && isScramble(arr1, arr2, i, right1, i, right2)
                    || isScramble(arr1, arr2, left1, i - 1, right2 - i + 1, right2) && isScramble(arr1, arr2, i, right1, left2, right2 - i)) {
                return true;
            }
        }
        return false;
    }
}
