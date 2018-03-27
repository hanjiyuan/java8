package h3w.java6;

/**
 * 
 * 使用volatile关键字修饰逻辑型状态变量
 *
 */
public class VolatileTest {
    private volatile static boolean bChanged;

    public static void main(String[] args) throws InterruptedException {
        new Thread() {
            @Override
            public void run() {
                int i = 0;
                for (;;) {
                    if (bChanged == !bChanged) {
                        System.out.println("!=");
                        System.exit(0);
                    }
                    System.out.println(i++);
                }
            }
        }.start();

        Thread.sleep(1);

        new Thread() {
            @Override
            public void run() {
                for (;;) {
                    bChanged = !bChanged;
                }
            }
        }.start();
    }
}
