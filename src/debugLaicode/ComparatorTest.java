package debugLaicode;

import java.util.*;

public class ComparatorTest implements Comparator<Integer> {

    public int compare(Integer one, Integer two) {
        return two - one; // descending order
    }
}

class CompareFor2Darray implements Comparator<int[]> {
    public int compare(int[] a, int[] b) {
        if (a[0] == b[0]) {
            return b[1] - a[1]; // height is decreasing
        } else {
            return a[0] - b[0]; // width is increasing
        }
    }
}


