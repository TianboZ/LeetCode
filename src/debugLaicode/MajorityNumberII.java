package debugLaicode;

import java.util.ArrayList;
import java.util.List;

public class MajorityNumberII {
    public List<Integer> majority(int[] array) {
        List<Integer> list = new ArrayList<Integer>();
        if (array == null || array.length == 0) {
            return list;
        }

        //initialize two pair objects to record the value and counter
        Pair p1 = new Pair(0, 0);
        Pair p2 = new Pair(0, 0);

        //iterate the array and choose two possible candidates
        for (int i = 0; i < array.length; i++) {
            if (array[i] == p1.number) {
                p1.counter++;
            } else if (array[i] == p2.number) {
                p2.counter++;
            } else if (p1.counter == 0) {
                p1.number = array[i];
                p1.counter = 1;
            } else if (p2.counter == 0) {
                p2.number = array[i];
                p2.counter = 1;
            } else {
                p1.counter--;
                p2.counter--;
            }
        }

        //iterate array again to count the candidates occurrences in the array
        int count1 = 0;
        int count2 = 0;
        int len = array.length / 3;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == p1.number) {
                count1++;
            } else if (array[i] == p2.number) {
                count2++;
            }
        }

        if (count1 > len) {
            list.add(p1.number);
        }
        if (count2 > len) {
            list.add(p2.number);
        }

        return list;
    }

    static class Pair {
        int number;
        int counter;
        Pair(int number, int counter) {
            this.number = number;
            this.counter = counter;
        }

    }

    public static void main(String[] args) {
        MajorityNumberII majorityNumberII = new MajorityNumberII();
        int[] array = {1,2,2,4,3,2,3,3};
        System.out.println(majorityNumberII.majority(array));
    }
}
