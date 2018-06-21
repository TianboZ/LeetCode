package debugLaicode;

public class ReverseWordsInASentence1 {
    public String reverseWords(String input) {
        char[] arr = input.toCharArray();
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

    public static void main(String[] args) {
        ReverseWordsInASentence1 reverseWordsInASentence1 = new ReverseWordsInASentence1();
        String res = reverseWordsInASentence1.reverseWords("i     fuck      tanchen");
        System.out.println(res);
    }
}
