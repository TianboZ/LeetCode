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
}



