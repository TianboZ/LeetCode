package debugLaicode;

public class MaxSumOfTwoIndices {
    public int[] maxSum(int[] array) {
        if (array == null || array.length == 0) {
            return new int[] {};
        }
        int maxI = array[0] - 0;
        int maxJ = array[0] + 0;

        int curI = 0;
        int curJ = 0;

        int[] res = new int[2];
        res[0] = curI;
        res[1] = curJ;

        int max = maxI + maxJ;
        for (int i = 1; i < array.length; i++) {
            if (array[i] + i > maxJ) {
                // update
                curJ = i;
            }
            if (array[i] - i > maxI) {
                // update
                curJ = i;
                curI = i;
            }

            if (array[curI] + array[curJ] + curJ - curI > max) {
                res[0] = curI;
                res[1] = curJ;
                max = array[curI] + array[curJ] + curJ - curI;
            }
        }
        return res;
    }
}
