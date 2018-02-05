package MianJing;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class GoogleOA {
    /*
    https://www.evernote.com/Home.action?login=true#n=ef964691-f6ae-4db5-bec3-15760adcfa19&s=s493&ses=4&sh=2&sds=5&
    */
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        GoogleOA googleOA = new GoogleOA();
        //System.out.println(googleOA.nextCloestTime("20:59"));

        int[] flower = {1,3,2,5,6,7,4};
        googleOA.kBloomedSlots(flower,3);
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
}
