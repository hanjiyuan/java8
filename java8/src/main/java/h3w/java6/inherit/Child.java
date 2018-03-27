package h3w.java6.inherit;

public class Child extends Base {

    public static String s = "static child";

    public String m = "member of child";

    public static void staticTest() {
        System.out.println("child static: " + s);
    }
}
