package MianJing;

import java.util.*;

public class Visa {
    // question 1
    static class Date {
        int year;
        int month;
        int day;

        Date(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }
    }

    public static List<String> sortDates(List<String> dates) {
        if (dates == null) return dates;

        // key: Jan   value: 1
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("Jan", 1);
        map2.put("Feb", 2);
        map2.put("Mar", 3);
        map2.put("Apr", 4);
        map2.put("May", 5);
        map2.put("Jun", 6);
        map2.put("Jul", 7);
        map2.put("Aug", 8);
        map2.put("Sep", 9);
        map2.put("Oct", 10);
        map2.put("Nov", 11);
        map2.put("Dec", 12);

        // key: date    value : "01 Oct 2020"
        Map<Date, String> map = new HashMap<>();

        List<Date> list = new ArrayList<>();

        for (String s : dates) {
            //System.out.println(s);
            //System.out.println(s.substring(3,6));
            int year = Integer.parseInt(s.substring(7, 11));
            //System.out.println("year " + year);
            int month = map2.get(s.substring(3,6));
            //System.out.println("month  " + month);
            int day = Integer.parseInt(s.substring(0,2));
            //System.out.println("day  " + day);

            Date date = new Date(year, month, day);

            map.put(date, s);
            list.add(date);
        }

        MyComparator myComparator = new MyComparator();

        // sort the list of Date
        Collections.sort(list, myComparator);

        // final result
        List<String> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            res.add(map.get(list.get(i)));
        }
        return res;
    }



    private static class MyComparator implements Comparator<Date> {
        @Override
        public int compare(Date d1, Date d2) {
            if (d1.year < d2.year) {
                return -1;
            } else if (d1.year == d2.year) {
                if (d1.month < d2.month) {
                    return -1;
                } else if (d1.month == d2.month) {
                    if (d1.day < d2.day) {
                        return -1;
                    } else if (d1.day == d2.day) {
                        return 0;
                    } else {
                        return 1;
                    }
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        }
    }

//    public static void main(String[] args) {
//        Visa visa = new Visa();
//        List<String> list = new ArrayList<>();
//        list.add("20 Oct 1990");
//        list.add("01 Mar 2051");
//        list.add("04 Jun 2001");
//        list.add("16 Dec 2099");
//        list.add("31 Dec 1998");
//        list.add("11 Dec 1998");
//        list.add("11 Feb 1998");
//
//        visa.sortDates(list);
//    }

    ////////////////////////////////////////////////////////////
    // question 2
    public static List<String> findSchedules(int workHours, int dayHours, String pattern) {
        int totalHour = 0;
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) != '?') {
                totalHour = totalHour + pattern.charAt(i) - '0';
            }

        }

        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        System.out.println(pattern);
        System.out.println("hours remain=" + (workHours - totalHour));
        dfs(res, sb, pattern, 0, workHours - totalHour, dayHours);
        System.out.println(res);
        return res;
    }

    // start from index 0 to current index, find all the possible solutions
    private static void dfs(List<String> res, StringBuilder sb, String pattern, int index, int hourRemain, int maxHour) {
        // base-case
        if (index == pattern.length()) {
            if (hourRemain == 0) {

                res.add(sb.toString());
            }

            return;
        }

        // recursive rule
        if (pattern.charAt(index) == '?') {

            for (int hour = 0; hour <= maxHour; hour++) {
                if (hourRemain - hour >= 0) {
                    sb.append(hour);
                    dfs(res, sb, pattern, index + 1, hourRemain - hour, maxHour);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        } else {

            sb.append(pattern.charAt(index));
            dfs(res, sb, pattern, index + 1, hourRemain, maxHour);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public static void main(String[] args) {
        findSchedules(24, 4, "08??840");
    }
}
