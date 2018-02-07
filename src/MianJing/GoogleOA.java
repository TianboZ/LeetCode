package MianJing;

import java.util.*;

public class GoogleOA {
    /*
    https://www.evernote.com/Home.action?login=true#n=ef964691-f6ae-4db5-bec3-15760adcfa19&s=s493&ses=4&sh=2&sds=5&
    */
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        GoogleOA googleOA = new GoogleOA();
        System.out.println(googleOA.nextCloestTime("12:21"));

        int[] flower = {1,3,2,5,6,7,4,9,8};
        googleOA.kBloomedSlots(flower,3);
        googleOA.kBloomedSlots1(flower,3);
        googleOA.solution(flower, 3);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    int globalMin;

    public String nextCloestTime(String time) {
        globalMin = 10000;

        char[] c = time.toCharArray();
        int[] original = new int[4];
        int k = 0;
        for (char character : c) {
            if (character == ':') {
                continue;
            }
            int digit = Character.getNumericValue(character);
            original[k] = digit;
            k++;
        }
        int[] t = original.clone();
        String[] res = new String[1];
        dfs(res, 0, t, original);
        return res[0].substring(0, 2) + ":" + res[0].substring(2, 4);
    }

    public void dfs(String[] res, int index, int[] arr, int[] time) {
        // base-case
        if (index == arr.length) {
            if (isValid(arr, time)) {
                // update
                String s = "";
                for(int i = 0; i < arr.length; i++) {
                    s = s + Integer.toString(arr[i]);
                }
                res[0] = s;
                //System.out.println(s);
            }
            return;
        }

        // recursive rule
        for (int i = index; i < arr.length; i++) {
            swap(arr, i, index);
            dfs(res, index + 1, arr, time);
            swap(arr, i, index);
        }
    }

    public boolean isValid(int[] arr, int[] time) {
        int hour = arr[0] * 10 + arr[1];
        int min = arr[2] * 10 + arr[3];


        if (hour > 23 || min > 59) {
            return false;
        }

        int now = hour * 60 + min;
        int ori = (time[0] * 10 + time[1]) * 60 + (time[2] * 10 + time[3]);

        if (now > ori && now - ori < globalMin) {
            globalMin = now - ori;
            return true;
        } else if (now <= ori && now + 24 * 60 - ori < globalMin){
            globalMin = now + 24 * 60 - ori;
            return true;
        }
        return false;
    }
    public void swap(int[] arr, int left, int right) {
        int tmp = arr[right];
        arr[right] = arr[left];
        arr[left] = tmp;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void kBloomedSlots(int[] flowers, int k) {


        int[] pos = new int[flowers.length];
        for (int i = 0; i < flowers.length; i++) {
            pos[i] = flowers[i];
        }

        // find max val in slide window
        List<Integer> max = new ArrayList<Integer>();
        Deque<Integer> deque1 = new LinkedList<>();

        for (int i = 0; i < pos.length; i++) {
            // poll all of the older and smaller element in the deque if they exist
            while (!deque1.isEmpty() && pos[deque1.peekLast()] <= pos[i]) {
                deque1.pollLast();
            }

            // now, safe to add new element
            deque1.offerLast(i);

            // handle left most element in the deque, may be their index already out
            // of the boundary of window, find them and poll them
            while (!deque1.isEmpty() && deque1.peekFirst() < i - k + 1) {
                deque1.pollFirst();
            }

            // now, the largest element in the deque is left most element, that is solution
            if (i >= k - 1) {
                max.add(pos[deque1.peekFirst()]);
            }
        }
        System.out.println(max);

        // find min val in slide window
        List<Integer> min = new ArrayList<>();
        Deque<Integer> deque2 = new LinkedList<>();

        for (int i = 0; i < pos.length; i++) {
            // poll all of the older and bigger element in the deque if they exist
            while (!deque2.isEmpty() && pos[deque2.peekLast()] >= pos[i]) {
                deque2.pollLast();
            }

            // now, safe to add new element
            deque2.offerLast(i);

            // handle left most element in the deque, may be their index already out
            // of the boundary of window, find them and poll them
            while (!deque2.isEmpty() && deque2.peekFirst() < i - k + 1) {
                deque2.pollFirst();
            }

            // now, the smallest element in the deque is left most element, that is solution
            if (i >= k - 1) {
                min.add(pos[deque2.peekFirst()]);
            }
        }
        System.out.println(min);

        //
        int day = 0;
        for (int i = 0; i < max.size(); i++) {
            if (max.get(i) - min.get(i) == k - 1) {
                day = i + k;
                System.out.println(day);
            }
        }

        System.out.println("last day: " + day);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    Set<Integer> protectPos = new HashSet<>();
    public void kBloomedSlots1(int[] flowers, int k) {
        Set<Integer> set = new HashSet<>();
        int lastDay = -1;
        for (int i = 0; i < flowers.length; i++) {
            set.add(flowers[i]);
            if(check(set, flowers[i], k)) {
                System.out.println("true");
                lastDay = i + 1;
            }
        }
        System.out.println(lastDay);
    }
    public boolean check(Set<Integer> set, int pos, int k) {
        set.add(pos);
        // look left
        int left = -1; // left is postion that so far not exist
        for (int i = 1; i <= k; i++) {
            if (!set.contains(pos - i)) {
                left = pos - i;
                break;
            }
        }
        // look right
        int right = -1; // right is postion that so far not exist
        for (int i = 1; i <= k; i++) {
            if (!set.contains(pos + i)) {
                right = pos + i;
                break;
            }
        }
        System.out.println("pos: " + pos + "  left: " + left + "  right: " + right);

        // get protect set
        if (right - left == k+1) {
            protectPos.add(left);
            protectPos.add(right);
        }

        if (protectPos.contains(pos)) {
            return false;
        } else {
            return true;
        }
    }
    //
    private static class Interval implements Comparable<Interval> {
        int beg;
        int end;
        public Interval(int beg, int end) {
            this.beg = beg;
            this.end = end;
        }

        public boolean isIn(int i) {
            return this.beg <= i && this.end >= i;
        }

        public int size() {
            return this.end - this.beg + 1;
        }

        public List<Interval> insert(int i) {
            List<Interval> l = new ArrayList<>();
            if (this.beg == this.end) {
                return Collections.emptyList();
            }
            if (i == this.beg) {
                l.add(new Interval(beg + 1, end));
                return l;
            }
            if (i == this.end) {
                l.add(new Interval(beg, end - 1));
                return l;
            }
            l.add(new Interval(beg, i - 1));
            l.add(new Interval(i + 1, end));
            return l;
        }
        @Override
        public int compareTo(Interval o) {
            return Integer.compare(this.beg, o.beg);
        }
    }
    public int solution(int[] P, int K) {
        TreeSet<Interval> s = new TreeSet<>();
        s.add(new Interval(0, P.length - 1));
        int day = 0;
        for (int i : P) {
            day++;
            Interval interval = this.find(i - 1, s);
            s.remove(interval);
            s.addAll(interval.insert(i - 1));
            if (check(K, s)) {
                return day;
            }
        }

        System.out.println("sol from Cao Yi Qun: " + day);
        return -1;
    }
    private boolean check(int K, TreeSet<Interval> s) {
        for (Interval interval : s) {
            if (interval.size() == K) {
                return true;
            }
        }
        return false;
    }
    private Interval find(int i, TreeSet<Interval> s) {
        for (Interval interval : s) {
            if (interval.isIn(i)) {
                return interval;
            }
        }

        throw new IllegalStateException();
    }
}
