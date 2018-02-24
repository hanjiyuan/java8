package h3w.java6.thread.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
	/**
	 *  打印队列
	 *  用于描述每个打印机的空闲状态
	 *  true为空闲，false为工作状态
	 */
	private boolean freePrinters[];

	// 用于同步控制访问freePrinters
	private Lock printersLock;

	// 定义公司最大的打印机数目
	private int MAX_PRINTER = 3;

	// 定义一个信号量对象
	private final Semaphore semaphore;

	public PrintQueue() {

		semaphore = new Semaphore(MAX_PRINTER);
		freePrinters = new boolean[MAX_PRINTER];

		// 初始化打印的状态
		for (int i = 0; i < MAX_PRINTER; i++) {
			freePrinters[i] = true;
		}
		printersLock = new ReentrantLock();
	}

	/**
	 *  利用信号量进行流量控制的经典"三段论"
	 */
	public void print(Document doc) {
		
		try {
			semaphore.acquire();

			// 获取空闲打印机
			int printerID = getPrinter();

			System.out.println("No." + printerID 
					+ " is working now: Title=>" + doc.getTitle() 
					+ ";Content=>" + doc.getContent());

			// 模拟一个耗时操作
			Thread.sleep(1000);
			
			System.out.println("No." + printerID + "'s work is done!");

			// 注意：完成任务后，一定要重置打印机为空闲状态，以便接收后续任务
			freePrinters[printerID] = true;

		} catch (InterruptedException ex) {
			ex.printStackTrace();
		} finally {
			semaphore.release();
		}
	}

	/**
	 *  利用锁修改资源的经典"三段式"
	 */
	private int getPrinter() {

		int ret = -1;
		try {
			printersLock.lock();

			// 查找到空闲的打印机序号
			for (int i = 0; i < freePrinters.length; i++) {
				if (true == freePrinters[i]) {
					ret = i;
					freePrinters[i] = false;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			printersLock.unlock();
		}
		return ret;
	}
}
