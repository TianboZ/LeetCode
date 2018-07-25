package debugLaicode;

public class MaximumSumSuchThatNoTwoElementsAdjacent {
    public int sumArray1(int[] arr) {
        int[] m = new int[arr.length];
        // m[i] represent the max sum can get from 0 to i index
        m[0] = arr[0];
        m[1] = Math.max(arr[0], arr[1]);

        // inductive rule
        for (int i = 2; i < arr.length; i++) {
            m[i] = Math.max(arr[i], Math.max(m[i - 1], m[i - 2] + arr[i]));
            //m[i] = Math.max(m[i - 1], m[i - 2] + arr[i]);
        }
        return m[m.length - 1];
    }

        public static void main(String[] args) {
        MaximumSumSuchThatNoTwoElementsAdjacent maximumSumSuchThatNoTwoElementsAdjacent = new MaximumSumSuchThatNoTwoElementsAdjacent();
        int arr[] = new int[]{-5,  -10, -100, 1000, 1001};
        //int res = maximumSumSuchThatNoTwoElementsAdjacent.sumArray(arr);
        int res2 = maximumSumSuchThatNoTwoElementsAdjacent.sumArray1(arr);

        //System.out.println(res);
        System.out.println(res2);
    }
}
