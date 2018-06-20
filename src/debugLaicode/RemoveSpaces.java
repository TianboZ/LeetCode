package debugLaicode;

public class RemoveSpaces {
    public String removeSpaces(String input) {
        // [0, slow) : keep
        // [slow, fast): delete
        // [fast, end] : to explore
        char[] arr = input.toCharArray();
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
            return new String(arr, 0, slow - 1);
        } else {
            return new String(arr, 0, slow);
        }
    }

    public static void main(String[] args) {
        RemoveSpace removeSpace = new RemoveSpace();
        String res= removeSpace.removeSpaces("    a b     d  ");
        System.out.println(res);
    }
}
