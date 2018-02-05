package debugLaicode;

public class BitonicPoint {
    public static  void main(String[] args) {
        BitonicPoint bitonicPoint = new BitonicPoint();
        int[] arr = {0,1,6,9,5,3,2,-2,-4,-5};

        System.out.println(bitonicPoint.search(arr, 7));
    }
    public int search(int[] array, int target) {
        // Write your solution here.
        if (array.length == 0 || array == null) {
            return -1;
        }
        int bitonic = findBitonicPoint(array);
        int test = findPeakIndex(array);

        System.out.println("bitonic index  " + bitonic + " test: " + test);
        if (target == array[bitonic]) {
            return bitonic;
        }
        int leftRes = binarySearchAsending(array, 0, bitonic - 1, target);
        int rightRest = binarySearchDescending(array, bitonic + 1, array.length - 1, target);
        System.out.println("left result = " + leftRes);
        System.out.println("right result = " + rightRest);

        if (leftRes == -1 && rightRest == -1) {
            return -1;
        } else {
            return leftRes == -1 ? rightRest : leftRes;
        }
    }
    public int binarySearchAsending(int[] arr, int left, int right, int target) {

        if (left > right) {
            return  -1;
        }

        System.out.println("left: " + left + "   right: " + right);
        while (left + 1 < right) {
            System.out.println("left: " + left + "   right: " + right);
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (arr[right] == target) {
            return right;
        } else if (arr[left] == target) {
            return left;
        }
        return -1;
    }
    public int binarySearchDescending(int[] arr, int left, int right, int target) {

        if (left > right) {
            return  -1;
        }

        System.out.println("left: " + left + "   right: " + right);
        while (left + 1 < right) {
            System.out.println("left: " + left + "   right: " + right);
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (arr[right] == target) {
            return right;
        } else if (arr[left] == target) {
            return left;
        }
        return -1;
    }
    public int findBitonicPoint(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            else if (arr[mid] < arr[mid - 1]) {
                right = mid;
            } else  if (arr[mid] < arr[mid + 1]) {
                left = mid;
            }
        }
        if (arr[right] > arr[left]) {
            System.out.println("right: " + right);
            return right;
        } else {
            System.out.println("left: " + left);
            return left;
        }
    }
    public int findPeakIndex(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (arr[mid] > arr[mid - 1]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (arr[left] > arr[right]) {
            return left;
        } else {
            return right;
        }
    }

}