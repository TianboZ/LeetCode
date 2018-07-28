package debugLaicode;

public class FlipGame2 {
    public boolean canWin(String s) {
        // Write your solution here
        int count = 0;
        char[] arr = s.toCharArray();
        return dfs(arr, count);
    }
    // if can win give char array
    private boolean dfs(char[] arr, int count) {
        // base-case
        if (!canFlip(arr)) {
            return count % 2 ==1 ? true : false;
        }
        // recursive rule
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1] && arr[i] == '+') {
                arr[i] = '-';
                arr[i + 1] = '-';
                if (dfs(arr, count + 1)) {
                    arr[i] = '+';
                    arr[i + 1] = '+';
                    return true;
                }
                arr[i] = '+';
                arr[i + 1] = '+';
            }
        }
        return false;
    }
    // if can keep flip
    private boolean canFlip(char[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1] && arr[i] == '+') {
                return true;
            }
        }
        return false;
    }
}
