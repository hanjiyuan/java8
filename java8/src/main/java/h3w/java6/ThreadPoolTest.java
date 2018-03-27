package h3w.java6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ExecutorService的基本用法
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        for (int i = 1; i < 5; i++) {
            final int taskID = i;
            pool.execute(new Runnable() {
                public void run() {
                    for (int i = 1; i < 5; i++) {
                        try {
                            Thread.sleep(20);// 为了测试出效果，让每次任务执行都需要一定时间
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("第" + taskID + "个任务的第" + i + "次执行");
                    }
                }
            });
            try {
                Thread.sleep(20);// 为了测试出效果，让每次任务执行都需要一定时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        pool.shutdown();// 任务执行完毕，关闭线程池
    }
}
