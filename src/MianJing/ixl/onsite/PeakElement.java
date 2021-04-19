package MianJing.ixl.onsite;

public class PeakElement {
    public void findPeak(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid - 1] < arr[mid]) {
                lo = mid;
            } else if (arr[mid - 1] == arr[mid]) {
                hi--;
            } else {
                hi = mid;
            }
        }

        int res = arr[lo] > arr[hi] ? arr[lo] : arr[hi];
        System.out.println(res);
    }

    public static void main(String[] args) {
        PeakElement sol = new PeakElement();
        int[] arr = {1,2,2,2,4,4,10,3,3,3,3};
        sol.findPeak(arr);
    }
}
