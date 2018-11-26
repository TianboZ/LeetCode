package MianJing.thumbtack;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TODO {

    static private Date epoch = new Date();

    static public class TODOEvent {
        private static AtomicInteger counter = new AtomicInteger(0);

        public int id;
        public String message;
        public Date dueTime;

        TODOEvent(String message, Date dueTime) {
            this.id = counter.addAndGet(1);
            this.message = message;
            this.dueTime = dueTime;
        }
    }

    static private class CheckThread implements Runnable {

        static private int timeout = 1000;
        private	TODO todo;

        CheckThread(TODO todo) {
            this.todo = todo;
        }

        @Override
        public void run() {
            while (true) {
                Date now = new Date();
                List<TODOEvent> dueEvents = this.todo.popBefore(now);

                for (TODOEvent e: dueEvents) {
                    System.out.format("[%.3f] Event #%d due: %s\n",
                            (now.getTime() - epoch.getTime()) / 1000.0,
                            e.id, e.message);
                }

                try {
                    //System.out.println("sleeping");
                    Thread.sleep(timeout);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    // key : due time   value: map of <event id : event>
    TreeMap<Date, HashMap<Integer, TODOEvent>> events = new TreeMap<>();
    HashMap<Integer, Date> idToDueTime = new HashMap<>();

    TODO() {
        CheckThread checkThread = new CheckThread(this);
        new Thread(checkThread).start();
    }

    public int create(String message, Date dueTime) {
        TODOEvent event = new TODOEvent(message, dueTime);

        synchronized (events) {
            HashMap<Integer, TODOEvent> eventsAtTime = events.getOrDefault(dueTime, new HashMap<>());

            idToDueTime.put(event.id, dueTime);
            eventsAtTime.put(event.id, event);
            events.put(dueTime, eventsAtTime);
        }

        return event.id;
    }

    public boolean remove(int id) {
        synchronized (events) {
            Date dueTime = idToDueTime.get(id);

            if (dueTime == null)
                return false;

            events.get(dueTime).remove(id);
        }
        return true;
    }

    private List<TODOEvent> popBefore(Date time) {
        List<TODOEvent> poped = new ArrayList<>();

        synchronized (events) {
            while (!events.isEmpty() && events.firstKey().compareTo(time) < 0) {
                Date earliest = events.firstKey();
                poped.addAll(events.get(earliest).values());
                events.remove(earliest);
            }
        }

        return poped;
    }

    public static void main(String[] args) {
        Date epoch = new Date();
        TODO todo = new TODO();

        int id1 = todo.create("#1 Due at 3s", new Date(epoch.getTime() + 3000));
        int id2 = todo.create("#2 Due at 9s", new Date(epoch.getTime() + 9000));
        int id3 = todo.create("#3 Due at 5s", new Date(epoch.getTime() + 5000));
        int id4 = todo.create("#4 Due at 7s", new Date(epoch.getTime() + 7000));

        todo.remove(id3);
    }
}
