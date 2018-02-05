package debugLaicode;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NextPermutation {
    //http://blog.csdn.net/linhuanmars/article/details/20434115
    /*
    假设数组大小为 n
        1.从后往前，找到第一个 A[i-1] < A[i]的。也就是第一个排列中的  6那个位置，可以看到A[i]到A[n-1]这些都是单调递减序列。
        2.从 A[n-1]到A[i]中找到一个比A[i-1]大的值（也就是说在A[n-1]到A[i]的值中找到比A[i-1]大的集合中的最小的一个值）
        3.交换 这两个值，并且把A[n-1]到A[i+1]排序，从小到大。
    */
    public void nextPermutation(int[] num) {
        if (num == null || num.length == 0)
            return;
        int i = num.length - 2;
        while (i >= 0 && num[i] >= num[i + 1])
            i--;

        if (i >= 0) {
            int j = i + 1;
            while (j < num.length && num[j] > num[i])
                j++;
            j--;
            swap(num, i, j);
        }
        reverse(num, i + 1, num.length - 1);
    }

    private void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    private void reverse(int[] num, int i, int j) {
        while (i < j)
            swap(num, i++, j--);
    }
}