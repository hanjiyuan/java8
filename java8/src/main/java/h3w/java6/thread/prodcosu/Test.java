package h3w.java6.thread.prodcosu;

public class Test {

	public static void main(String[] args) {
		int size = 10;
		Repository rep = new Repository(size);
		Productor prod = new Productor(rep);
		prod.start();
		Consumer coms = new Consumer(rep);
		coms.start();
		try {
			Thread.sleep(5 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
