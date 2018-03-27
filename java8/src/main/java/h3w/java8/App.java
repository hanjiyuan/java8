package h3w.java8;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int i;
        App a = new App();
        a.count();
        // System.out.println(a.j);
    }

    public void count() {

        int j = 11;
        System.out.println(j);
        // System.out.println(this.j);
        a();

        System.out.println(j);

    }

    public void a() {
        int j = 11;
        System.out.println(j);
    }

    int i;
    private int j = 10;
}
