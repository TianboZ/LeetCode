package debugLaicode;

import java.util.*;

public class LargestProductOfLength {
    public int largestProduct(String[] dict) {
        // make sure the length of string is decreasing sorted
        Arrays.sort(dict, new MyComparator());
        for (String s: dict) {
            System.out.println(s);
        }
        // maxHeap
        Queue<Element> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[dict.length][dict.length];
        // initial
        visited[0][1] = true;
        pq.offer(new Element(0, 1, dict[0].length() * dict[1].length()));

        // terminate
        while (!pq.isEmpty()) {
            // expand
            Element curr = pq.poll();
            int i = curr.i;
            int j = curr.j;
            if (common(dict[i], dict[j])) {
                System.out.println(dict[i] + " " + dict[j]);
                return curr.product;
            }
            // generate
            if (i + 1 < dict.length && !visited[i + 1][j]) {
                pq.offer(new Element(i + 1, j, dict[i + 1].length() * dict[j].length()));
                visited[i + 1][j] = true;
            }
            if (j + 1 < dict.length && !visited[i][j + 1]) {
                pq.offer(new Element(i, j + 1, dict[i].length() * dict[j + 1].length()));
                visited[i][j + 1] = true;
            }
        }
        return -1;
    }

    // if there are common characters, return false
    private boolean common(String s1, String s2) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            set.add(s1.charAt(i));
        }
        for (int i = 0; i < s2.length(); i++) {
            if (set.contains(s2.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    class Element implements Comparable<Element> {
        // fields
        int i;
        int j;
        int product;

        // constructor
        public Element(int i, int j, int product) {
            this.i = i;
            this.j = j;
            this.product = product;
        }

        // API
        @Override
        public int compareTo(Element another) {
            if (this.product == another.product) {
                return 0;
            }
            return this.product < another.product ? 1 : -1;
        }
    }

    class MyComparator implements Comparator<String> {
        @Override
        public int compare(String i, String j) {
            if (i.length() == j.length()) {
                return 0;
            }
            return i.length() < j.length() ? 1 : -1;
        }
    }

    public static void main(String[] args) {
        LargestProductOfLength largestProductOfLength = new LargestProductOfLength();
        String[] arr = {"abcdefhi","ix","hj","x"};
        int res = largestProductOfLength.largestProduct(arr);
        System.out.println(res);
    }
}
