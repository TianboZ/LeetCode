package debugLaicode;

/*
  index       0   1   2   3   4   5   6   7
  height      0   1   0   2   1   0   1   3



for each index i, record the largest height from 0 to i-1 index, record the largest height from end to i + 1 index
iterate each element, we can compute how much water it can hold by comparing left heighest and right heighest value

*/
public class TrappingRainWater {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int water = 0;

        // iterate from left to right
        for (int i = 0; i < height.length; i++) {
            if (i == 0) {
                left[i] = height[i];
            } else {
                left[i] = Math.max(left[i - 1], height[i]);
            }
        }

        // iterate from right to left
        for (int i = height.length - 1; i >= 0; i--) {
            if (i == height.length - 1) {
                right[i] = height[i];
            } else {
                right[i] = Math.max(right[i + 1], height[i]);
            }
        }

        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(left[i - 1], right[i + 1]);
            if (min > height[i]) {
                water = water + min - height[i];
            }
        }
        return water;
    }
}