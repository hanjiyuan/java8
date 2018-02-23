package h3w.java6.thread.prodcosu;


public class Producer extends Thread {

	private Repository rep;

	public Producer(Repository rep) {
		super("PRODUCER");
		this.rep = rep;
	}

	public void run() {
		int count = 0;
		while (true) {
			if (count >= rep.getSize()) break;
			try {
				rep.put();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			count++;
		}
	}
}
