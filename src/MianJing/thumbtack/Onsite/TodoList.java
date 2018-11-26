package MianJing.thumbtack.Onsite;

import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/*
* 1. use cases
* - alert if tast due
* - add todo event
*
* 2. design API
*  addEvent()  input: due time    output: event id(unique)
*
*  create a thread to monitor the process
*
* 3. design class member fields, state
* use a priority queue to store all the event, sorted by event due time
* use a Map<key: event, value : finished or not>
*
* 4. constructor
* initial member fields, PriorityQueue, HashMap
* initial another thread to monitor the other thread
*
* 5. implement API
*
*
* */
public class TodoList {
    // helper class
    private static class TODO {
        long due;
        String name;
        int id;

        TODO (long d, String n, int i){
            due = d;
            name = n;
            id = i;
        }
    }

    private static class CheckThread extends Thread {
        // fields
        int time = 1000; // every 1 second, check thread

        // constructor
        CheckThread() {

        }

        // API
        @Override
        public void run() {
            while (true) {
                long curr = System.currentTimeMillis();
                if (!pq.isEmpty() && pq.peek().due <= curr) {
                    TODO todo = pq.poll();
                    System.out.println("due! " + " name: " + todo.name);
                }
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {

                }
            }
        }
    }

    private static class CP implements Comparator<TODO> {
        @Override
        public int compare(TODO todo1, TODO todo2) {
            if (todo1.due == todo2.due) return 0;
            return todo1.due < todo2.due ? -1 : 1; // sorted by increasing order
        }
    }

    // fields
    private static AtomicInteger systemId;
    private static Map<TODO, Boolean> map;
    private static PriorityBlockingQueue<TODO> pq;
    private static Map<Integer, TODO> idToEvent;

    // constructor
    public TodoList() {
        map = new ConcurrentHashMap<>();
        pq = new PriorityBlockingQueue<>(10, new CP());
        systemId = new AtomicInteger(0);
        idToEvent = new ConcurrentHashMap<>();
        Thread checkThread = new CheckThread();
        checkThread.start();
    }
    // API
    public int addEvent(String name, long due) {
        int id = systemId.intValue();
        TODO todo = new TODO(due, name, id);
        pq.offer(todo);
        map.put(todo, false);
        idToEvent.put(id, todo);

        systemId.addAndGet(1);
        return id;
    }

    public boolean delete(int id) {
        if (!idToEvent.containsKey(id)) throw new IllegalStateException("id does not exist");
        pq.remove(idToEvent.get(id));
        idToEvent.remove(id);
        return true;
    }

    public static void main(String[] args) {
        System.out.println("todo list");

        TodoList todoList = new TodoList();
        int id1 = todoList.addEvent("todo1", System.currentTimeMillis() + 5000);
        int id2 = todoList.addEvent("todo2", System.currentTimeMillis() + 1000);
        int id3 = todoList.addEvent("todo3", System.currentTimeMillis() + 10000);

        try {
            Thread.sleep(7000);
            boolean res = todoList.delete(id3);
            System.out.println("delete success: " + res);
        } catch (InterruptedException e) {

        }

    }
}
