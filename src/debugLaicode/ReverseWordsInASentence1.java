package debugLaicode;

public class ReverseWordsInASentence1 {
    // assumption
    // 1. no heading or trailing space
    // 2. single space between words
    public String reverseWords(String input) {
        // sanity check

//        char[] arr = input.toCharArray();
//        int slow = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == ' ' && i - 1 >= 0) {
//                // detect space
//                reverse(arr, slow, i - 1);
//                slow = i + 1;
//            } else if (i == arr.length - 1) {
//                reverse(arr, slow, i);
//            }
//        }
//
//        reverse(arr, 0, arr.length - 1);


        char[] chars = input.toCharArray();

        // reverse whole string
        reverse(chars, 0, chars.length - 1);

        // reverse words
        int i = 0;
        while (i < chars.length) {
            if (chars[i] == ' ') {
                i++;
                continue;
            }
            int j = i;
            while (j < chars.length && chars[j] != ' ') {
                j++;
            }
            //System.out.println(j);
            reverse(chars, i, j - 1);
            i = j;
        }

        // remove heading space
        i = 0;
        int slow = 0;    // [0, slow): retain   at most 1 space
        while (i < chars.length) {
            if (chars[i] == ' ') {
                int j = i;
                while (j < chars.length && chars[j] == ' ') j++;
                chars[slow] = chars[j - 1];
                slow++;
                i = j;
            } else  {
                chars[slow] = chars[i];
                slow++;
                i++;
            }
        }

        System.out.println(new String(chars));
        return "";
    }

//    public String reverseWords(String input) {
//        char[] arr = input.toCharArray();
//        int slow = 0;
//        // step1: reverse single word in the sentence
//        for (int fast = 0; fast < arr.length; fast++) {
//            if (arr[fast] == ' ') {
//                reverse(arr, slow, fast - 1);
//                slow = fast + 1;
//            } else if (fast == arr.length - 1) {
//                reverse(arr, slow, fast);
//            } else {
//                continue;
//            }
//        }
//        // step2: reverse whole sentence
//        reverse(arr, 0, arr.length - 1);
//        return new String(arr, 0, arr.length);
//    }
    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }


    public static void main(String[] args) {
        ReverseWordsInASentence1 sol = new ReverseWordsInASentence1();
        String res = sol.reverseWords("   i  fuck  ");
        System.out.println(res);
    }
}
