package debugLaicode;

public class LargestSubarrayProduct {
    public double largestProduct(double[] array) {
        // write your solution here
        // max[i] represents the largest subarray product, ends with index i in array
        double[] max = new double[array.length];

        // min[i] represents the largest subarray product, ends with index i in array
        double[] min = new double[array.length];

        // base-case
        max[0] = array[0];
        min[0] = array[0];

        double globalMax = max[0];
        // inductive rule
        for (int i = 1; i< array.length; i++) {
            max[i] = Math.max(max[i - 1] * array[i], min[i - 1] * array[i]);
            max[i] = Math.max(max[i], array[i]);

            min[i] = Math.min(max[i - 1] * array[i], min[i - 1] * array[i]);
            min[i] = Math.min(min[i], array[i]);

            // update global max
            if (max[i] > globalMax) {
                globalMax = max[i];
            }
        }

        return globalMax;
    }
}
