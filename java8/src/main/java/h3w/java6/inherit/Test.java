package h3w.java6.inherit;

public class Test {

    public static void main(String[] args) {

        Child c = new Child();

        Base b = c;

        System.out.println(b.s);
        // 成员变量不能继承,输出Base的成员变量m
        System.out.println(b.m);
        // 静态方法不能多态,实际调用Base.staticTest()
        b.staticTest();

        System.out.println("-------------");

        System.out.println(c.s);
        System.out.println(c.m);
        c.staticTest();
    }
}
