package debugLaicode;

public class RemoveSpaces {
    /*
    * assumption:
    *
    * solution:
    * use slow and fast pointer, divide array into:
    * [0, slow): retain
    * [slow, fast): ignore
    * [fast, end]: explore
    *
    * if array[fast] is ' ', while loop to find the last consecutive ' '
    *   case1: slow == 0, skip (since we don't want leading ' ')
    *   case2: slow != 0, array[slow] = array[fast] slow++ fast++
    * else, array[slow] = array[fast] slow++ fast++
    *
    *
    * complexity:
    *
    * time o(n)
    * space o(n)  : convert input string to char array for in-place operation
    *
    * */
    public String removeSpaces(String input) {
        // sanity check

        char[] arr = input.toCharArray();
        int slow = 0;
        int fast = 0;

        while (fast < arr.length) {
            if (arr[fast] == ' ') {
                int fast2 = fast;
                while (fast2 < arr.length && arr[fast2] == ' ') {
                    fast2++;
                }
                // fast2 - 1 is last index of ' '
                if (slow == 0) {
                    fast = fast2;
                } else {
                    arr[slow] = arr[fast2 - 1];
                    slow++;
                    fast = fast2;
                }
            } else {
                arr[slow] = arr[fast];
                slow++;
                fast++;
            }
        }

        // post process trailing ' '
        if (slow > 0 && arr[slow - 1] == ' ') {
            return new String(arr, 0, slow - 1);
        }

        return new String(arr, 0, slow);
    }


//    public String removeSpaces(String input) {
//        // [0, slow) : keep
//        // [slow, fast): delete
//        // [fast, end] : to explore
//        char[] arr = input.toCharArray();
//        int slow = 0;
//        for (int fast = 0; fast < arr.length; fast++) {
//            if (arr[fast] == ' ') {
//                if (fast == 0) {
//                    continue;
//                } else if (fast > 0 && arr[fast - 1] == ' ') {
//                    continue;
//                } else {
//                    arr[slow] = arr[fast];
//                    slow++;
//                }
//            } else {
//                arr[slow] = arr[fast];
//                slow++;
//            }
//        }
//        if (slow > 0 && arr[slow - 1] == ' ') {
//            return new String(arr, 0, slow - 1);
//        } else {
//            return new String(arr, 0, slow);
//        }
//    }

    public static void main(String[] args) {
        RemoveSpaces removeSpace = new RemoveSpaces();
        String res= removeSpace.removeSpaces("    a b     d  ");
        System.out.println(res);
    }
}
