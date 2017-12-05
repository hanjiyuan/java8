package test.thread.prodcosu;


public class Productor extends Thread {

	private Repository rep;

	public Productor(Repository rep) {
		super("PRODUCTOR");
		this.rep = rep;
	}

	public void run() {
		int count = 0;
		while (true) {
			if (count == rep.getSize()) break;
			try {
				System.out.println(Thread.currentThread().getName()  
						+ ": put " +  rep.put());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			count++;
		}
	}
}
