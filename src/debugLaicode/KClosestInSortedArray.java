package debugLaicode;

/*

  sol:
  - do binary search, find largest <= target element, take time o(log n)
  - from there, use two pointers, find k cloest numbers, take time o(k)

  */

public class KClosestInSortedArray {
    public int[] kClosest(int[] array, int target, int k) {
        // Write your solution here
        int[] res = new int[k];
        if (k == 0) {
            return res;
        }

        int lo = largestSmallerEqual(array, target);
        int hi = lo + 1;
        for (int i = 0; i < k; i++) {
            if (hi >= array.length ||
                    lo >= 0 && hi < array.length &&
                            (Math.abs(target - array[lo]) <= Math.abs(target  - array[hi]))) {
                //res[i] = array[lo];
                lo--;
            } else {
                res[i] = array[hi];
                //hi++;
            }
        }

        // if need result is required sorted, leetcode
        int j = 0;
        for (int i = lo + 1; i < hi; i++) {
            res[j] = array[i];
        }

        return res;
    }

    private int largestSmallerEqual(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int lo = 0;
        int hi = array.length - 1;

        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (array[mid] <= target) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        // post processing
        if (target >= array[hi]) {
            return hi;
        } else if (target >= array[lo]) {
            return lo;
        }

        // can not find
        return -1;
    }

    public static void main(String[] args) {
        KClosestInSortedArray sol = new KClosestInSortedArray();
        int[] arr = {-1, 2, 3, 5, 6, 11};
        int target = 4;
        int[] result = sol.kClosest(arr, target, 4);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
