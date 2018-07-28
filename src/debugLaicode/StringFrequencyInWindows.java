package debugLaicode;

import java.util.*;

public class StringFrequencyInWindows {
    public List<Frequency> frequency(String input) {
        // key: character value: count how many characters needed
        Map<Character, Integer> map = countMap("ABCD");
        Map<String, Integer> res = new LinkedHashMap<>();
        int match = 0;
        for (int i = 0; i < input.length(); i++) {
            // handle right most
            char c = input.charAt(i); // right most char
            Integer count = map.get(c);
            if (count != null) {
                map.put(input.charAt(i), count - 1);
                if (count == 1) {
                    match++;
                }
            }
            // handle left most
            if (i >= 4) {
                c = input.charAt(i - 4);// left most char
                count = map.get(c);
                if (count != null) {
                    map.put(c, count + 1);
                    if (count == 0) {
                        match--;
                    }
                }
            }
            System.out.println(match);
            // check the current sliding window
            if (match == 4) {
                String s = input.substring(i - 3, i + 1);
                System.out.println(s);
                Integer count1 = res.get(s);
                if (count1 == null) {
                    res.put(s, 1);
                } else {
                    res.put(s, count1 + 1);
                }
            }
        }
        List<Frequency> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : res.entrySet()) {
            list.add(new Frequency(entry.getKey(), entry.getValue()));
        }
        //System.out.println(list);
        Collections.sort(list, new MyComparator());
        for (Frequency e : list) {
            System.out.println(e.s);
        }
        return list;
    }


    private Map<Character, Integer> countMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            Integer i = map.get(ch);
            if (i == null) {
                map.put(ch, 1);
            } else {
                map.put(ch, i + 1);
            }
        }
        return map;
    }

    private class MyComparator implements Comparator<Frequency> {
        @Override
        public int compare(Frequency s1, Frequency s2) {
            if (s1.count < s2.count) {
                return 1;
            } else if (s1.count > s2.count) {
                return -1;
            }
            return s1.s.compareTo(s2.s);
        }
    }

    private class Frequency {
        String s;
        int count;
        Frequency (String s , int count) {
            this.s = s;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        StringFrequencyInWindows stringFrequencyInWindows = new StringFrequencyInWindows();
        stringFrequencyInWindows.frequency("CABDACBCCDADCB");
    }
}
