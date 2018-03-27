package h3w.java6;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class InterruptTest {

    private static final ScheduledExecutorService cancelExec = Executors.newScheduledThreadPool(10);

    public static void main(String[] args) {
        timedRun(new InterruptTest().new Task(), 1, TimeUnit.SECONDS);
    }

    public static void timedRun(Runnable r, long timeout, TimeUnit unit) {
        final Thread taskThread = Thread.currentThread();
        cancelExec.schedule(new Runnable() {
            public void run() {
                taskThread.interrupt();
            }
        }, timeout, unit);
        cancelExec.shutdown();
        r.run();
    };

    class Task implements Runnable {
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
