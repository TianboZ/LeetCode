package MianJing;

public class GoogleOA {
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        GoogleOA googleOA = new GoogleOA();
        System.out.println(googleOA.nextCloestTime("20:59"));
    }

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
}
