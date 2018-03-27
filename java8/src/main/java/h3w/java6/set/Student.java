package h3w.java6.set;

public class Student {

    String name;
    Integer age;
    
    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    
    @Override
    public boolean equals(Object o) {
        Student s = (Student) o;
        if (name.equals(s.name) && age.equals(s.age)) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public int hashCode() {
        return name.hashCode() + age.hashCode();
    }
}
