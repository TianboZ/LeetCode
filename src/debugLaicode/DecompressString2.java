package debugLaicode;

public class DecompressString2 {
    // in-place method
    // when we say in place, it usually means the input is a long enough char array
    // and the original string only occupies part of the array starting from index 0,
    // and usually the length to represent the original string is given
//    public String decompress(String input) {
//        if (input == null || input.length() == 0) {
//            return input;
//        }
//        char[] arr = input.toCharArray();
//        // case1:  a0   a1   a2   decoded string becomes shorter
//        // case2:  a3   a5   a10   decoded string becomes longer
//        // we need to handle two cases in two steps
//        return decodeLonger(arr, decodeShorter(arr));
//    }
//
//    // return the length of decoded string
//    private int decodeShorter(char[] arr) {
//        int slow = 0;
//        for (int fast = 0; fast < arr.length; fast++) {
//            if (Character.isDigit(arr[fast])) {
//                // digit
//                int j = fast;
//                int num = 0;
//                // get number
//                while (j < arr.length && Character.isDigit(arr[j])) {
//                    num = num * 10 + Character.getNumericValue(arr[j]);
//                    j++;
//                }
//                if (num <= 2) {
//                    for (int i = 0; i < num; i++) {
//                        arr[slow] = arr[fast];
//                        slow++;
//                    }
//                }
//            } else {
//                // character
//                arr[slow] = arr[fast];
//                slow++;
//            }
//        }
//        for (char c : arr) {
//            System.out.println(c);
//        }
//        return slow;
//    }
//
//    // length of the valid partition starting from index 0
//    private String decodeLonger(char[] arr, int length) {
//        int newLen = length;
//        // get new length
//        for (int i = 0; i < length; i++) {
//            if (Character.isDigit(arr[i])) {
//                // digit
//                int j = i;
//                int num = 0;
//                // get number
//                while (j < arr.length && Character.isDigit(arr[j])) {
//                    num = num * 10 + Character.getNumericValue(arr[j]);
//                    j++;
//                }
//                newLen = newLen + num - 2;
//            }
//        }
//        // notice: if it is required to do this in place ,usually the input array is sufficient large one,
//        // you will not need to allocate a new array. this solution is only for demonstration
//        char[] res = new char[newLen];
//
//        for (int i = length - 1; i >= 0; i--) {
//            if (Character.isDigit(arr[i])) {
//                // digit
//                int j = i;
//                int num = 0;
//                // get number
//                while (j >= 0 && Character.isDigit(arr[j])) {
//                    num = num + Character.getNumericValue(arr[j]) ;
//                    j++;
//                }
//            }
//        }
//    }

    public String decompress1(String input) {
        // Write your solution here.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                int j = i + 1;
                int num = 0;
                // calculate the number
                while (j < input.length() && Character.isDigit(input.charAt(j))) {
                    num = num * 10 + Character.getNumericValue(input.charAt(j));
                    j++;
                }
                // j - 1 is last index of digit
                for (int k = 0; k < num; k++) {
                    sb.append(input.charAt(i));
                }
                // i jump to last index of digit
                i = j - 1;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        DecompressString2 decompressString2 = new DecompressString2();
        decompressString2.decompress1("x20y0i0z3");
    }
}
