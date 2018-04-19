package h3w.java6.hash;

import java.util.Objects;

public class Student {

    String name;
    Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name,age);
    }
}
