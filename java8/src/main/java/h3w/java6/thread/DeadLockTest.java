package h3w.java6.thread;

/**
 * A test case of dead lock. There are two threads, ReadThread and WriteThread.
 * The both need to acquire a lock to continue that held by the other.
 * 
 * @author HJY
 * @since 2012-12-5
 */
public class DeadLockTest extends Thread {

    private static class Resource {
    }

    public static void main(String[] args) {
        DeadLockTest deakLock = new DeadLockTest();
        Resource a = new Resource();
        Resource b = new Resource();
        Thread w = deakLock.new WriteThread(a, b);
        Thread r = deakLock.new ReadThread(a, b);
        w.start();
        r.start();
    }

    /**
     * ReadThread, it will acquire resourceA lock first, then acquire resourceB
     * lock
     * 
     * @author HJY
     * @since 2012-12-5
     */
    class ReadThread extends Thread {

        private Resource resourceA;
        private Resource resourceB;

        public ReadThread(Resource a, Resource b) {
            super("ReadThread");
            this.resourceA = a;
            this.resourceB = b;
        }

        public void run() {
            synchronized (resourceA) {
                try {
                    System.out.println(Thread.currentThread().getName() + "  has aquired resourceA lock.");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resourceB) {
                    // to do
                }
            }
        }
    }

    /**
     * WriteThread, it will acquire resourceB lock first, then acquire resourceA
     * lock
     * 
     * @author HJY
     * @since 2012-12-5
     */
    class WriteThread extends Thread {

        private Resource resourceA;
        private Resource resourceB;

        public WriteThread(Resource a, Resource b) {
            super("WriteThread");
            this.resourceA = a;
            this.resourceB = b;
        }

        public void run() {
            synchronized (resourceB) {
                System.out.println(Thread.currentThread().getName() + " has aquired resourceB lock.");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resourceA) {
                    // to do
                }
            }
        }
    }
}