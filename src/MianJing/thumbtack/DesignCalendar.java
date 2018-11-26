package MianJing.thumbtack;

import java.util.*;


public class DesignCalendar {
    // fields
    private int id;
    private Map<Integer, List<Event>> events;   // key: time       value: list of events
    private Map<Integer, Event> ids; // key: id      value: event

    // helper class
    private static class Event {
        int id;
        String title;
        List<Integer> times;

        Event (String title, List<Integer> times) {
            this.title = title;
            this.times = new ArrayList<>(times);
        }
    }

    private class Event1 {

    }

    // constructor
    public DesignCalendar() {
        this.id = 0;
        this.events = new HashMap<>();
        this.ids = new HashMap<>();
    }

    // API
    public void addEvent(Event e) {
        e.id = id; // get system id

        ids.put(id, e);
        List<Integer> times = e.times;
        for (Integer time : times) {
            if (events.containsKey(time)) {
                List<Event> lists = events.get(time);
                lists.add(e);
            } else {
                List<Event> lists = new ArrayList<>();
                lists.add(e);
                events.put(time, lists);
            }
        }

        id++; // update system id
    }

    public void removeEvent(int id) {
        Event e = ids.get(id);
        if (e == null) return; // id does not exist!

        // remove this id from ids
        ids.remove(id);

        // remove this event from events
        for(List<Event> list : events.values()) {
            list.remove(e);
        }
    }

    public List<Event> getEventsByTime(int time) {
        return events.get(time);
    }

    public static void main(String[] args) {
        List<Integer> times1 = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> times2 = new ArrayList<>(Arrays.asList(3,4,5));

        DesignCalendar.Event e2 = new DesignCalendar.Event("todo2", times2);
        Event e1 = new Event("todo1", times1);

        DesignCalendar calendar = new DesignCalendar();

        DesignCalendar.Event1 event1 = calendar.new Event1();

        calendar.addEvent(e1);
        calendar.addEvent(e2);

        calendar.removeEvent(100);
        calendar.removeEvent(1);

        System.out.println(calendar.events);
    }
}


