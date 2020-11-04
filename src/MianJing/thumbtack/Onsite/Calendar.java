package MianJing.thumbtack.Onsite;

import java.util.*;

/*
*
* 1. clarify uses cases
*
* 2. design API
*       addEvent()    input: day, time of that day, name of event    output: unique if of each event
*       deleteEvent()   input: id    output: true if delete success
*       getEvent()   input: day    output: list of event happened on that day
*
* 3. design class internal states, fields
*
*    class Event {
*       ...
*    }
*
*    Map<key: day, value: set of id>
*    Map<key: id, value: event>
*
* 4. implement Constructor
*       initialize the fields
*
* 5. implement API
*
*
*
* */
public class Calendar {
    // helper class
    private static class Event {
        String day; // date  e.g.   11/10
        String time; // time of that day  e.g.   11:00
        String name; // event name
        boolean repeat;

        Event(String d, String t, String n) {
            day = d;
            time = t;
            name = n;
        }
    }

    // fields
    private Map<Integer, Event> idToEvent;
    private Map<String, Set<Integer>> map;
    private int systemId;

    // constructor
    public Calendar() {
        idToEvent = new HashMap<>();
        map = new HashMap<>();
        systemId = 0;
    }


    // API
    public List<Integer> addEvent(String day, String time, String name, boolean repeat) {
        List<Integer> list = new ArrayList<>(); // list of ids
        if (repeat) {
            String date = day.split("/")[1];
            for (int i = 1; i <= 12; i++) {
                // some month only 30 days, assume all month is 31 days
                String newday = Integer.toString(i) + "/" + date;
                list.add(createEvent(newday, time, name));
            }
        } else {
            list.add(createEvent(day, time, name));
        }
        return list;
    }

    // return unique id for each event
    private int createEvent(String day, String time, String name) {
        Event event = new Event(day, time, name);
        int id = systemId;

        systemId++;
        Set<Integer> ids = map.get(day);
        if (ids == null) {
            ids = new HashSet<>();
            map.put(day, ids);
        }
        ids.add(id);

        idToEvent.put(id, event);
        return id;
    }

    public boolean delete(int id) {
        if (!idToEvent.containsKey(id)) {
            throw new IllegalStateException("id does not exist!");
        }

        Event e = idToEvent.get(id);
        idToEvent.remove(id);

        String day = e.day;
        map.get(day).remove(id);

        return true;
    }

    public List<Event> getEvent(String day) {
        if (!map.containsKey(day)) {
            throw new IllegalStateException("this day does not exist!");
        }

        Set<Integer> ids = map.get(day);
        List<Event> events = new ArrayList<>();
        for (Integer id : ids) {
            events.add(idToEvent.get(id));
        }

        return events;
    }

    public static void main(String[] args) {
        Calendar calendar = new Calendar();
        System.out.println("a");

        // add events
        calendar.addEvent("10/1", "11:00", "flight to sf", false);
        calendar.addEvent("10/11", "12:00", "coding", false);
        calendar.addEvent("10/11", "13:00", "lunch", true);

        List<Event> events = calendar.getEvent("10/11");
        for (Event e : events) {
            System.out.println("day: " + e.day + " time: " + e.time + " name: " + e.name);
        }

        // delete event
        //calendar.delete(100); // this id not exist now
        System.out.println("after delete event");

        events = calendar.getEvent("7/11");
        for (Event e : events) {
            System.out.println("day: " + e.day + " time: " + e.time + " name: " + e.name);
        }

    }
}
