package h3w.java6.thread;

/**
 * About wait() and notify() usage
 * 
 * @author HJY
 * @since 2012-12-6
 */
public class NotifyWaitTest {

	public static void main(String[] args) {

		NotifyWaitTest t = new NotifyWaitTest();

		Resource res = new Resource();

		ThreadA threadA = t.new ThreadA(res);
		ThreadB threadB = t.new ThreadB(res);

		threadA.start();
		threadB.start();
	}

	/**
	 * ThreadA will invoke wait()
	 * 
	 * @author HJY
	 * @since 2012-12-6
	 */
	class ThreadA extends Thread {

		private Resource res;

		public ThreadA(Resource res) {
			this.res = res;
		}

		public void run() {
			synchronized (res) {
				try {
					System.out.println("before threadA.wait()");
					// invoke wait() will free lock
					// this is different from Thread.sleep()
					res.wait();
					System.out.println("after  threadA.wait()");
				} catch (InterruptedException e) {
					System.out.println("wait() occur exception");
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * ThreadB will invoke notify()
	 * 
	 * @author HJY
	 * @since 2012-12-6
	 */
	class ThreadB extends Thread {

		private Resource res;

		public ThreadB(Resource res) {
			this.res = res;
		}

		public void run() {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (res) {
				res.notifyAll();	// res.notify() is also OK
				System.out.println("has invoked res.notify()");
			}
		}
	}
}

class Resource {

}