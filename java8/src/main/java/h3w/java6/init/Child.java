package h3w.java6.init;

public class Child extends Father {
	{
		System.out.println("CB0 ......");
	}

	static {
		System.out.println("CSB0 ......");
		// d\a无法在此打印，执行在此时d\a还位初始化
	}

	static int a = 1;

	static {
		System.out.println("CSB1 a:" + a);
		// d无法在此打印，执行在此时d还位初始化
	}

	int b = 1;

	static {

		a++;

		System.out.println("CSB2 a:" + a);

		// d无法在此打印，执行在此时d还位初始化

	}

	final static int c = 1;

	static {
		System.out.println("CSB3 c:" + c);
		// d无法在此打印，执行在此时d还位初始化
	}

	public Child() {
		a++;
		b++;
		System.out.println("C CONSTTRUCTOR a:" + a + ", b:" + b + ", c:" + c + ", d:" + d);
	}

	{
		a++;
		b++;
		System.out.println("CB4 a:" + a + ", b:" + b + ", c:" + c);
		// d无法在此打印，执行在此时d还位初始化
	}

	final int d = 1;

	public void func1() {
		a++;
		b++;
		System.out.println("C func1 a:" + a + ", b:" + b + ", c:" + c + ", d:" + d);
	}

	public static void func2() {
		a++;
		System.out.println("C func1 a:" + a + ", c:" + c);
	}

	public static class BBQ {
		static {
			System.out.println("BBQ");
		}
	}
}
