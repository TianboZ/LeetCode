package debugLaicode;

public class MaximumSumOf3NonOverlappingSubarrays {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        // Write your solution here
        int[] ps = new int[nums.length];
        int max = 0;
        ps[0] = nums[0];
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;

        int len = nums.length;

        for (int i = 1; i < nums.length; i++) {
            ps[i] = ps[i - 1] + nums[i];
            //System.out.println(ps[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + k; j < nums.length; j++) {
                for (int m = j + k; m < nums.length; m++) {
                    if (i + k - 1 < len && j + k - 1 < len && m + k - 1 < len) {
                        int sum = ps[i + k - 1] - ps[i] + nums[i]
                                + ps[j + k - 1] - ps[j] + nums[j]
                                + ps[m + k - 1] - ps[m] + nums[m];

                        if (sum > max) {
                            i1 = i;
                            i2 = j;
                            i3 = m;
                            //System.out.println("sum is   " + sum + "   " + i1 + " " + i2 + " " + i3);
                            max = sum;
                        }
                    }

                }
            }
        }

        return new int[] {i1, i2, i3};
    }
}
