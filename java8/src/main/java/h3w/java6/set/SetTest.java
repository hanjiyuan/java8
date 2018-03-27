package h3w.java6.set;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

    public static void main(String[] args) {

         test0();

        // test1();

        // test2();
//        test5();
    }

    public static void test0() {
        
        Student s1 = new Student("zhangsan", 5);
        Student s2 = new Student("lisi", 10);
        Student s3 = new Student("wangwu", 5);
        
        Set<Student> s = new HashSet<Student>();
        s.add(s1);
        s.add(s1);      // not err
        s.add(s2);
        s.add(s3);
        System.out.println(s);
    }
}
