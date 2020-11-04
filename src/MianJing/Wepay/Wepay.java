package MianJing.Wepay;

import java.util.*;

public class Wepay {
    private boolean maxWindows(int[] array, int k, List<Cell> cells, float increase) {
        int sum = 0;
        Map<Integer, Integer> count = new HashMap<>();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            while (!deque.isEmpty() && array[deque.peekLast()] <= array[i]) {
                deque.pollLast();
            }

            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            deque.offerLast(i);


            sum = sum + array[i];
            if (i - k + 1 >= 0) {
                if (i - k >= 0) {
                    sum = sum - array[i - k];
                }
                // in each window, get the max value and the sum of this window
                cells.add(new Cell(array[deque.peekFirst()], sum));
                // count the frequency of max value in each window
                Integer num = count.get(array[deque.peekFirst()]) ;
                if (num == null) {
                    count.put(array[deque.peekFirst()], 1);
                } else {
                    count.put(array[deque.peekFirst()], 1 + num);
                }

            }
        }
        for (Cell cell : cells) {
            System.out.println("max: " + cell.max + " sum :  " + cell.sum);
        }
        System.out.println(count);

        Float prevAvg = null;
        // key: max value in each window     value: frequency


        // key: max value in each window     value: frequency that this max number larger than requirement
        Map<Integer, Integer> countLargerThanAvg = new HashMap<>();
        // iterate cell list
        for (int i = 0; i < cells.size(); i++) {
            // current window avg
            float avg = cells.get(i).sum / k;

            // check current window average and previous window average
            if (prevAvg == null) {
                prevAvg = avg;
            } else {
                if (avg > prevAvg * increase){
                    return true;
                } else {
                    prevAvg = avg;
                }
            }

            // check current window max
            if (cells.get(i).max > increase * avg) {
                Integer num = countLargerThanAvg.get(cells.get(i).max);
                if (num == null) {
                    countLargerThanAvg.put(cells.get(i).max, 1);
                } else {
                    countLargerThanAvg.put(cells.get(i).max, 1 + num);
                }

            }
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int max = entry.getKey();
            if (entry.getValue() == countLargerThanAvg.get(max)) return true;
        }
        return  false;
    }
    class Cell {
        int max;
        int sum;
        Cell (int max, int sum) {
            this.max = max;
            this.sum = sum;
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 100, 2, 2};
        Wepay wepay = new Wepay();
        List<Cell> list = new ArrayList<>();
        boolean res = wepay.maxWindows(arr, 2, list, (float) 2.5);
        System.out.println(res);
    }

}
