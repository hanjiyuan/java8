package test.thread.prodcosu;



public class Test {

	public static void main(String[] args) {
		int size = 10;
		Repository rep = new Repository(size);
		Productor prod = new Productor(rep);
		prod.start();
		Consumer  coms = new Consumer(rep);
		coms.start();
	}

}
