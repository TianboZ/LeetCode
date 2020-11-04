//package MianJing.thumbtack;
//
//import java.util.*;
//
//public class DesignCalendar1 {
//    static class Meta {
//        String hour;
//        String name;
//        boolean rec = false;
//        String attendness;
//
//        Meta (String h, String n, boolean r, String a) {
//            hour = h;
//            name = n;
//            rec = r;
//            attendness = a;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Meta meta = (Meta) o;
//            return rec == meta.rec &&
//                    Objects.equals(hour, meta.hour) &&
//                    Objects.equals(name, meta.name) &&
//                    Objects.equals(attendness, meta.attendness);
//        }
//
//        @Override
//        public int hashCode() {
//
//            return Objects.hash(hour, name, rec, attendness);
//        }
//    }
//    static Map<String, Set<Meta>> map;
//    static Map<String, Set<Meta>> recMap;
//
//    public void addEvent(String day, Meta meta) {
//        if (!meta.rec) {
//            Set<Meta> set =map.getOrDefault(day, new HashSet<>());
//            set.add(meta);
//            map.put(day, set);
//        } else {
//            String tmptDay = day.split("/")[1];
//            Set<Meta> set =map.getOrDefault(day, new HashSet<>());
//            set.add(meta);
//            recMap.put(tmptDay, set);
//        }
//    }
//
//    public List<Meta> getAllEvents(String day) {
//        Set<Meta> set = map.getOrDefault(day, new HashSet<>());
//        set.addAll(recMap.getOrDefault(day.split("/")[1], new HashSet<>()));
//        return new ArrayList<Meta>(set);
//
//    }
//
//    public void delete(String day, Meta meta) {
//
//    }
//
//}
