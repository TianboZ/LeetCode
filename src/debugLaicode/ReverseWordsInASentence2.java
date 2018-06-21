package debugLaicode;
//Reverse the words in a sentence and truncate all heading/trailing/duplicate space characters.
//Examples
//“ I  love  Google  ” → “Google love I”

public class ReverseWordsInASentence2 {
    public String reverseWords(String input) {
        // Write your solution here
        String s = remove(input);
        char[] arr = s.toCharArray();
        int slow = 0;
        // step1: reverse single word in the sentence
        for (int fast = 0; fast < arr.length; fast++) {
            if (arr[fast] == ' ') {
                reverse(arr, slow, fast - 1);
                slow = fast + 1;
            } else if (fast == arr.length - 1) {
                reverse(arr, slow, fast);
            } else {
                continue;
            }
        }
        // step2: reverse whole sentence
        reverse(arr, 0, arr.length - 1);
        return new String(arr, 0, arr.length);
    }
    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    private String remove(String s) {
        char[] arr = s.toCharArray();
        int slow = 0;
        for (int fast = 0; fast < arr.length; fast++) {
            if (arr[fast] == ' ') {
                if (fast == 0) {
                    continue;
                } else if (fast > 0 && arr[fast - 1] == ' ') {
                    continue;
                } else {
                    arr[slow] = arr[fast];
                    slow++;
                }
            } else {
                arr[slow] = arr[fast];
                slow++;
            }

        }
        if (slow > 0 && arr[slow - 1] == ' ') {
            return new String(arr, 0, slow -1);
        } else {
            return new String(arr, 0, slow);
        }
    }
}
