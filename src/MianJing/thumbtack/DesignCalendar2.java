package MianJing.thumbtack;

/*
*
* 1. use cases
*   -
*   -
*   -
*
* 2. design API
* int addEvent(parameters)     return the unique id for each event
*
* boolean deleteEvent(id)     delete event using id
*
* List<Event> getAllEvents(day)    return list of events, input date
*
* 3. design fields and internal state
*
* Map<key: date, value: list of events> map
*
* need a helper class Event
*
* need unique system id for each generate events
*
*
* 4. constructor implement
*
* ....
*
* 5. API implement
* ...
*
* */

import java.util.*;

public class DesignCalendar2 {
    // fields
    // helper class
    private static class Event{
        String time;
        String name;
        String attendness;
        String day;

        boolean repeat;

        Event(String t, String n, String a, String d, boolean r) {
            time = t;
            name = n;
            attendness = a;
            day = d;
            repeat = r;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Event event = (Event) o;
            return repeat == event.repeat &&
                    Objects.equals(time, event.time) &&
                    Objects.equals(name, event.name) &&
                    Objects.equals(attendness, event.attendness) &&
                    Objects.equals(day, event.day);
        }

        @Override
        public int hashCode() {

            return Objects.hash(time, name, attendness, day, repeat);
        }
    }

    private int id;

    private Map<String, Set<Event>> map; // key: day   value: list of events
    private Map<Integer, Event> idToEvent; // key： ID    value: event

    // constructor
    public DesignCalendar2 () {
        map = new HashMap<>();
        idToEvent = new HashMap<>();
        id = 0;
    }

    // API
    // return unique id for each event
    // time O(1)
    // space O(1)
    public int addEvent(String day, String name, String a, String time, boolean repeat) {
        Event event = new Event(time, name, a, day, repeat);
        idToEvent.put(id, event);
        id++;

        Set<Event> events  = map.get(day);
        if (events == null) {
            events = new HashSet<>();
            map.put(day, events);
        }
        events.add(event);

        return id - 1; // return event id
    }

    // return true if delete success
    // time O(1)
    // space O(1)
    public boolean deleteEvent(int id) {
        if (!idToEvent.containsKey(id)) {
            throw  new IllegalStateException("id does not exist");
        }

        Event event = idToEvent.get(id);
        idToEvent.remove(id);

        String day = event.day;
        map.get(day).remove(event);
        return true;
    }

    public Set<Event> getAllEvents(String day) {
        if (!map.containsKey(day)) throw new IllegalStateException("no such day");

        return map.get(day);
    }

    public static void main(String[] args) {
        DesignCalendar2 designCalendar2 = new DesignCalendar2();
        int id1 = designCalendar2.addEvent("11/01", "interview", "tianbo", "10:00", false); // id = 0
        int id2 = designCalendar2.addEvent("11/01", "flight", "tianbo", "16:00", false); // id = 1
        int id3 = designCalendar2.addEvent("11/11", "flight", "tianbo", "16:00", true); // id = 1

        Set<Event> events = designCalendar2.getAllEvents("11/01");
        for (Event event : events) {
            System.out.println("day: " + event.day + " time: " + event.time + " name: " + event.name + " attendness: " + event.attendness);
        }

        System.out.println("delete id1");
        designCalendar2.deleteEvent(id1);
        events = designCalendar2.getAllEvents("11/01");
        for (Event event : events) {
            System.out.println("day: " + event.day + " time: " + event.time + " name: " + event.name + " attendness: " + event.attendness);
        }
    }
}
