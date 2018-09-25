package debugLaicode;

import java.util.*;

public class KthSmallestSumInKSortedArray {
    public int kthSmallestSum(int[][] m, int k) {
        int rows = m.length;
        // create a arraylist to store each state’s index
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m.length; i++) {
            list.add(0);
        }
        int val = getValue(m, list);
        Set<State> visited = new HashSet<>();
        int count = 0;
        Queue<State> q = new PriorityQueue<>(new MyComparator());

        // initial
        q.offer(new State(list, val));
        visited.add(new State(list, val));

        // terminate
        while(!q.isEmpty()) {
            // expand
            State curr = q.poll();
            List<Integer> currIndexList = curr.index;
            count++;
            if (count == k) {
                return curr.val;
            }

            // generate
            for (int i = 0; i < m.length; i++) {
                List<Integer> newIndexList = new ArrayList<>(currIndexList);
                int newCol = newIndexList.get(i) + 1;
                newIndexList.set(i, newCol);
                if (newCol < m[i].length) {
                    int newVal = getValue(m, newIndexList);
                    if (visited.add(new State(newIndexList, newVal))) q.offer(new State(newIndexList, newVal));

                }
            }
        }
        return -1;
    }
    private int getValue(int[][] m, List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < m.length; i++) {
            sum  = sum + m[i][list.get(i)];
        }
        return sum;
    }
    class State {
        List<Integer> index;
        int val;
        State(List<Integer> index, int val) {
            this.index = new ArrayList<>();
            this.index = index;
            this.val = val;
        }

        @Override
        public boolean equals(Object obj) {
            State other = (State) obj;
            for (int i = 0; i < index.size(); i++) {
                if (index.get(i) != other.index.get(i)) {
                    return false;
                }
            }
            return this.val == other.val;
        }

        @Override
        public int hashCode() {
            return val * 31 + index.hashCode();
        }
    }
    class MyComparator implements Comparator<State> {
        @Override
        public int compare(State s1, State s2) {
            if (s1.val == s2.val) return 0;
            return s1.val < s2.val ? -1 : 1;
        }
    }

    public static void main(String[] args) {
        KthSmallestSumInKSortedArray kthSmallestSumInKSortedArray = new KthSmallestSumInKSortedArray();
        int[][] m = {{1,2,3,4}, {2,3,4,9}, {-10,0,1,100}};
        int res = kthSmallestSumInKSortedArray.kthSmallestSum(m, 4);
        System.out.println(res);
    }
}
