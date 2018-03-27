package h3w.java6.init;

public class Father {
    {
        System.out.println("FB0 ......");
    }

    static {
        System.out.println("FSB0 ......");
        // d\a无法在此打印，执行在此时d\a还位初始化
    }

    static int a = 1;

    static {
        System.out.println("FSB1 a:" + a);
        // d无法在此打印，执行在此时d还位初始化
    }

    int b = 1;

    static {
        a++;
        System.out.println("FSB2 a:" + a);
        // d无法在此打印，执行在此时d还位初始化
    }

    final static int c = 1;

    static {
        System.out.println("FSB3 c:" + c);
        // d无法在此打印，执行在此时d还位初始化
    }

    public Father() {
        a++;
        b++;
        System.out.println("F CONSTTRUCTOR a:" + a + ", b:" + b + ", c:" + c + ", d:" + d);
    }

    {
        a++;
        b++;
        System.out.println("FB4 a:" + a + ", b:" + b + ", c:" + c);
        // d无法在此打印，执行在此时d还位初始化
    }

    final int d = 1;

    public void func1() {
        a++;
        b++;
        System.out.println("F func1 a:" + a + ", b:" + b + ", c:" + c + ", d:" + d);
    }

    public static void func2() {
        a++;
        System.out.println("F func1 a:" + a + ", c:" + c);
    }
}
