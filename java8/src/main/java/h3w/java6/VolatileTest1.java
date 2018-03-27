package h3w.java6;

/**
 * 
 * 使用volatile关键字修饰计数变量
 *
 */
public class VolatileTest1 {

    // 不论是否使用volatile关键字，计数结果都是错误的。
    public volatile static int count = 0;

    public static void inc() {

        // 这里延迟1毫秒，使得结果明显
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
        }
        // synchronized (Counter.class){
        count++;
        // }
    }

    public static void main(String[] args) {

        // 同时启动1000个线程，去进行i++计算，看看实际结果
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                public void run() {
                    VolatileTest1.inc();
                }
            }).start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 这里每次运行的值都有可能不同,可能为1000
        System.out.println("运行结果:Counter.count=" + VolatileTest1.count);
    }
}