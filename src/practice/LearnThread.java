package practice;

public class LearnThread {
    static class Test extends Thread {
        @Override
        public void run() {
            System.out.println("hello multi thread!");
        }
    }
    static class Test1 extends Thread {
        @Override
        public void run() {
            System.out.println("hello multi thread1!");
        }
    }
    static class Test2 extends Thread {
        @Override
        public void run() {
            System.out.println("before sleeping");
            try {


                Thread.sleep(10000);

                if (Thread.interrupted()) {
                    System.out.println("thread is interrupted");
                    return;
                }
            } catch (Exception e) {
                if (Thread.interrupted()) {
                    System.out.println("thread is interrupted");
                    return;
                }
                return;
            }


            System.out.println("after sleeping");
        }
    }

    public static void main(String[] args) {
        Thread thread2 = new Test2();
        Thread thread = new Test();
        Thread thread1 = new Test1();



        thread.run();
        thread1.run();
        thread2.run();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            return;
        }

        thread2.interrupt();
    }
}
