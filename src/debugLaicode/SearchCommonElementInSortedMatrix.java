package debugLaicode;

import java.util.ArrayList;
import java.util.List;

public class SearchCommonElementInSortedMatrix {
    public int search(int[][] matrix) {
        // Write your solution here
        if (matrix == null || matrix.length <= 1 || matrix[0].length == 0) {
            return -1;
        }
        List<Integer> common = new ArrayList<>();
        for (int i = 0; i < matrix[0].length; i++) {
            common.add(matrix[0][i]);
        }

        for (int i = 1; i < matrix.length; i++) {
            common = findCommonElements(common, matrix[i]);
            if (common.size() == 0) {
                return -1;
            }
        }
        return common.get(0);
    }
    private List<Integer> findCommonElements(List<Integer> common, int[] arr) {
        int i = 0;
        int j = 0;
        List<Integer> res = new ArrayList<>();

        while (i < common.size() && j < arr.length) {
            if (common.get(i) == arr[j]) {
                res.add(common.get(i));
                i++;
                j++;
            } else if (common.get(i) < arr[j]) {
                i++;
            } else {
                j++;
            }
        }

        return res;
    }
}
