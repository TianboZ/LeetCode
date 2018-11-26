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
    int end; // next element of last element


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

    private void sift_up(int[] array, int index) {
        int parent = (index - 1) / 2;
        while (parent >= 0) {
            if (array[index] < array[parent]) {
                swap(array, index, parent);
            } else {
                break;
            }
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    public void push(int element) {
        array[end] = element;
        sift_up(array, end);
        end++;
    }

    //
    private void sift_down(int[] array, int index, int end) {
        // step 1 : swap the start index with the smaller child until we reach the end of the array
        while(index < end){
            int right = index * 2 + 2;
            int left = index * 2 + 1;
            // compare and get the smaller one
            int smaller = index;
            if (left < end && array[smaller] > array[left]) {
                smaller = left;
            }
            if (right < end && array[smaller] > array[right]) {
                smaller = right;
            }
            if (smaller != index) {
                swap(array, index, smaller);
                index = smaller;
            } else {
                break;
            }
        }
    }

    public int pop() {
        // swap the 0 with the index  end - 1
        int value = array[0];
        swap(array, 0, end - 1);
        end--;
        // sift down
        sift_down(array, 0, end);

        return value;
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
            sift_down(array, i, end);
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
