package debugLaicode;

import java.util.Arrays;

public class ThreeSumCloest {
    public int threeSumClosest(int[] num, int target) {
        // Write your solution here
        Arrays.sort(num);
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < num.length; i++) {
            int left = i + 1;
            int right = num.length - 1;

            while (left < right) {
                int sum = num[i] + num[left] + num[right];
                if (sum < target) {
                    if (Math.abs(sum - target) < min) {
                        min = Math.abs(sum - target);
                        res = sum;
                    }
                    left++;
                } else if (sum == target) {
                    return sum;
                } else {
                    if (Math.abs(sum - target) < min) {
                        min = Math.abs(sum - target);
                        res = sum;
                    }
                    right--;
                }
            }
        }
        return res;
    }
}
