package practice;

/*
java里一般用PriorityQueue

Heap实现：
如何实现一个heap
         5
        / \
       4  3
      /
     3

array

[5, 4, 3, 3]


given index i
left: 2 * i + 1
right: 2 * i + 2
parent: (i - 1) / 2

* */
public class MinHeap1 {
    int[] array;
    int end; // [0, end)  : not including end

    public MinHeap1() {
        this.array = new int[1000];
    }

    // constructor, the only place that uses heapify()
    public MinHeap1(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("input cannot be null or empty");
        }
        this.array = array;
        end = array.length;
        heapify();
    }

    private void sift_up(int[] arr, int i) {
        int pIdx = (i - 1) / 2; // parent index
        while (pIdx >= 0) {
            if (arr[i] >= arr[pIdx]) break;

            swap(arr, i, pIdx);
            i = pIdx;
            pIdx = (i - 1) / 2;
        }
    }

    public void push(int element) {
        array[end] = element;
        end++;
        sift_up(array, end);
    }

    // i  is index of element needs to shift down
    private void sift_down(int[] array, int i) {
        while(i < end){
            int right = i * 2 + 2;
            int left = i * 2 + 1;
            // compare and get the smaller one
            int smaller = i;
            if (left < end && array[smaller] > array[left]) {
                smaller = left;
            }
            if (right < end && array[smaller] > array[right]) {
                smaller = right;
            }
            if (smaller != i) {
                swap(array, i, smaller);
                i = smaller;
            } else {
                break;
            }
        }
    }

    public int pop() {
        // swap the 0 with the index  end - 1
        int res = array[0];
        swap(array, 0, end - 1);
        end--;
        // sift down
        sift_down(array, 0);

        return res;
    }

    private void swap(int[] arr, int i, int j) {
        int tmpt = arr[i];
        arr[i] = arr[j];
        arr[j] = tmpt;
    }

    // time O(n)
    public void heapify() {
        //int length = arr.length;
        for (int i = end - 1; i >= 0; i--) {
            sift_down(array, i);
        }
    }

    public boolean isEmpty() {
        return end == 0;
    }

    public static void main(String[] args) {
        int[] arr = {100, 1, -1, 1, 2, 5, 0, 9};
        MinHeap1 minHeap = new MinHeap1(arr);
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.pop());
        }
    }
}
