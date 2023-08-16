package ooss;

import java.util.Objects;

public class Student extends Person {

    private Klass klass = null;

    private boolean isLeader = false;

    private final String introduction = String.format("%s I am a student.", super.introduce());

    public Student(int id, String name, int age) {
        super(id, name, age);
    }

    public void setLeader(boolean isLeader) {
        this.isLeader = isLeader;
    }

    public String introduce() {
        if (Objects.nonNull(this.klass)) {
            return isLeader
                    ? String.format("%s I am the leader of class %d.", introduction, this.klass.getNumber())
                    : String.format("%s I am in class 1.", introduction);
        }
        return introduction;
    }

    public void join(Klass klass) {
        this.klass = klass;
    }

    public boolean isIn(Klass klass) {
        return this.klass == klass;
    }

    public Klass getKlass() {
        return klass;
    }

}
