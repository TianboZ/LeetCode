package debugLaicode;


import java.util.*;

public class MaxValInKSizeSlidingWindow {
    public List<Integer> maxWindows(int[] array, int k) {
        List<Integer> res = new ArrayList<>();
        Queue<Element> maxHeap = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            maxHeap.offer(new Element(array[i], i));
            // make sure we start after sliding window
            if (i - (k - 1) >= 0) {
                while (!maxHeap.isEmpty() && maxHeap.peek().index < i - (k - 1)) {
                    maxHeap.poll();
                }
                res.add(maxHeap.peek().val);
            }
        }
        return res;
    }
    class CP implements Comparator<Element> {
        @Override
        public int compare(Element e1, Element e2) {
            return e2.val - e1.val;
        }
    }
    class Element {
        int val;
        int index;
        public Element (int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    // sol2:
    // use deque
    public List<Integer> maxWindows1(int[] array, int k) {
        List<Integer> max = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            while (!deque.isEmpty() && array[deque.peekLast()] <= array[i]) {
                deque.pollLast();
            }

            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            deque.offerLast(i);

            if (i - k + 1 >= 0) {
                max.add(array[deque.peekFirst()]);
            }
        }
        return max;
    }
}



