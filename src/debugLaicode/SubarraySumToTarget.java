package debugLaicode;

public class SubarraySumToTarget {
    public boolean sumToTarget(int[] array, int target) {
        // Write your solution here.
        if (array == null || array.length == 0) {
            return false;
        }
        int[] ps = new int[array.length];
        ps[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            ps[i] = ps[i - 1] + array[i];
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (ps[i] - ps[j] + array[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
