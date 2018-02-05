package debugLaicode;

public class KthPermutation {
    boolean found;
    int res;
    int count;
    public String getPermutation(int n, int k) {
        // write your solution.
        found = false;
        res = -1;
        char[] arr = new char[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char)(i + 1 + '0');
        }
        count = 0;
        getPermutation(arr, 0, k);
        System.out.println(res);
        return Integer.toString(res);
    }
    public void getPermutation(char[] arr, int index, int k) {
        // base-case
        if (found) {
            return;
        }
        if (index == arr.length) {
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }
            System.out.println("aaaaaaaaaa");
            count++;
            if (count == k) {
                found = true;
                res = Integer.parseInt(new String(arr));
            }
            return;
        }

        // recursive rule
        for (int i = index; i < arr.length; i++) {
            swap(arr, i, index);
            getPermutation(arr, index + 1, k);
            swap(arr, i, index);
        }
    }
    public void swap(char[] arr, int left, int right) {
        char tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }


    public static void main(String[] args) {
        KthPermutation kthPermutation = new KthPermutation();
        kthPermutation.getPermutation(3,2);

    }
}
