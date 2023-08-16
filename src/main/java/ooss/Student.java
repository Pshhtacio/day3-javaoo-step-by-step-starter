package ooss;

import java.util.Objects;

public class Student extends Person {

    private Klass klass = null;

    private String introduction = String.format("%s I am a student.", super.introduce());
    public Student(int id, String name, int age) {
        super(id, name, age);
    }

    public String introduce() {
        return Objects.nonNull(this.klass)? String.format("%s I am in class 1.", introduction) : introduction;
    }

    public void join(Klass klass) {
        this.klass = klass;
    }

    public boolean isIn(Klass klass) {
        return this.klass == klass;
    }

}
