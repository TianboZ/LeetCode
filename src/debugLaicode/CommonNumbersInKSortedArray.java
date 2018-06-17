package debugLaicode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonNumbersInKSortedArray {
    public List<Integer> common(int[][] arrayOfarrays) {
        List<Integer> tmp = new ArrayList<>();
        for (int i : arrayOfarrays[0]) {
            tmp.add(i);
        }

        for (int i = 1; i < arrayOfarrays.length; i++) {
            int[] arr = arrayOfarrays[i];
            int m = 0;
            int n = 0;
            List<Integer> common = new ArrayList<>();
            while (m < arr.length && n < tmp.size()) {
                if (arr[m] == tmp.get(n)) {
                    common.add(arr[m]);
                    m++;
                    n++;
                } else if (arr[m] < tmp.get(n)) {
                    m++;
                } else {
                    n++;
                }
            }
            tmp = common;
        }
        System.out.println(tmp);
        return tmp;
    }
    public static void main(String[] args) {
        CommonNumbersInKSortedArray commonNumbersInKSortedArray = new CommonNumbersInKSortedArray();
        int[][] arrayOfarrays = {
                {1, 2, 2, 3, 5},
                {2, 2, 5, 5, 6},
                {2, 2, 5, 10},
                {2, 2, 2, 2, 2, 2, 5},
        };

        commonNumbersInKSortedArray.common(arrayOfarrays);
    }
}
