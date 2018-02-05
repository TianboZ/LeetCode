package debugLaicode;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class NextCloestTime {

    public static void main(String[] args) {
        NextCloestTime nextCloestTime = new NextCloestTime();
        String res = nextCloestTime.nextClosestTime("23:09");
        System.out.println(res);
    }

    int globalMin;
    public String nextClosestTime(String time) {
        globalMin = 10000;
        char[] c = time.toCharArray();
        int[] t = new int[4];
        int k = 0;
        Set<Integer> set = new HashSet<>();
        for (char character : c) {
            if (character == ':') {
                continue;
            }
            int digit = Character.getNumericValue(character);
            set.add(digit);
            t[k] = digit;
            k++;
        }
        List<Integer> now = new ArrayList<>();
        String[] res = new String[1];
        List<Integer> list = new ArrayList<>(set);
        dfs(res, 0, t, list, now);
        return res[0].substring(0, 2) + ":" + res[0].substring(2, 4);
    }

    public void dfs(String[] res, int index, int[] ori, List<Integer> list, List<Integer> now) {
        // base-case
        if (index == ori.length) {
            if (isValid(ori, now)) {
                // update
                String s = "";
                for(int i = 0; i < now.size(); i++) {
                    s = s + Integer.toString(now.get(i));
                }
                res[0] = s;
                System.out.println(s);
            }
            return;
        }

        // recursive rule
        for (int i = 0; i < list.size(); i++) {
            now.add(list.get(i));
            dfs(res, index + 1, ori, list, now);
            now.remove(now.size() - 1);
        }
    }

    public boolean isValid(int[] ori, List<Integer> now) {
        int hour = now.get(0) * 10 + now.get(1);
        int min = now.get(2) * 10 + now.get(3);
        if (hour > 23 || min > 59) {
            return false;
        }
        int nowTime = hour * 60 + min;
        //System.out.println("hour: " + hour + " min: " + min);
        //System.out.println("original: " + "hour: " + (time[0] * 10 + time[1]) + " min: " + (time[2] * 10 + time[3]));
        int oriTime = (ori[0] * 10 + ori[1]) * 60 + (ori[2] * 10 + ori[3]);

        if (nowTime > oriTime && nowTime - oriTime < globalMin) {
            globalMin = nowTime - oriTime;
            return true;
        } else if (nowTime <= oriTime && nowTime + 24 * 60 - oriTime < globalMin){
            globalMin = nowTime + 24 * 60 - oriTime;
            return true;
        }
        return false;
    }

}