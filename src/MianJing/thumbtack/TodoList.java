package MianJing.thumbtack;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class TodoList {
    //fields
    private Map<Task, Boolean> map; // key: task     value: done or not
    private Map<Integer, Task> idToTask; // key: id    value: task

    private PriorityBlockingQueue<Task> queue; //
    private AtomicInteger id;

    private class CheckThread extends Thread {
        private int timeout = 100; // every 0.1 second, check thread once

        CheckThread() {

        }

        @Override
        public void run() {
            while (true) {
                long currTime = System.currentTimeMillis();
                while (!queue.isEmpty() && queue.peek().due <= currTime) {
                    Task dueTask = queue.poll();
                    System.out.println("task due!");
                    System.out.println(dueTask.name + " task due time: " + dueTask.due + " current time: " + currTime);
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
    static class Task {
        String name;
        long due;
        Task(String name, long due) {
            this.name = name;
            this.due = due;
        }
    }

    static class CP implements Comparator<Task> {
        @Override
        public int compare(Task t1, Task t2) {
            if (t1.due == t2.due) return 0;
            return t1.due < t2.due ? -1 : 1;
        }
    }
    // constructor
    public TodoList() {
        map = new ConcurrentHashMap<>();
        queue = new PriorityBlockingQueue<>(10, new CP());
        id = new AtomicInteger(0);
        idToTask = new ConcurrentHashMap<>();

        Thread thread = new CheckThread();
        thread.start();
    }

    // API
    public int create(String name, long due) {
        Task task = new Task(name, due);
        int currId = id.intValue();
        map.put(task, false);
        queue.offer(task);
        idToTask.put(currId, task);
        id.addAndGet(1);
        return currId;
    }

    public boolean deleteTask(int id) {
        // id not exist
        if (!idToTask.containsKey(id)) return false;

        Task task = idToTask.get(id);
        queue.remove(task);
        map.remove(task);
        idToTask.remove(id);
        return true;
    }

    public void finish(int id) {
        // id not exist
        if (!idToTask.containsKey(id)) return;

        Task task = idToTask.get(id);
        queue.remove(task);
        map.put(task, true);
    }



    public static void main(String[] args) {
        TodoList todoList = new TodoList();

        int id1 = todoList.create("a", System.currentTimeMillis() + 10000);
        int id2 = todoList.create("b", System.currentTimeMillis() + 2000);
        int id3 = todoList.create("c", System.currentTimeMillis() + 5000);
        int id4 = todoList.create("d", System.currentTimeMillis() + 8000);

        int id5 = todoList.create("aa", System.currentTimeMillis() + 20000);

        try {
            Thread.sleep(10000);
            todoList.deleteTask(4);
            todoList.finish(3);
        } catch (Exception e) {

        }

        //System.out.println("a");
    }
}
