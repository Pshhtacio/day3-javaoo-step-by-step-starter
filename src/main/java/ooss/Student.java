package ooss;

import java.util.Objects;

public class Student extends Person {

    private Klass klass = new Klass(0);
    private boolean isLeader = false;

    private final String introduction = String.format("%s I am a student.", super.introduce());

    public Student(int id, String name, int age) {
        super(id, name, age);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public void setLeader(boolean isLeader) {
        this.isLeader = isLeader;
    }

    @Override
    public String introduce() {
        if (klass.getNumber() != 0) {
            return isLeader
                    ? String.format("%s I am the leader of class %d.", introduction, klass.getNumber())
                    : String.format("%s I am in class %d.", introduction, klass.getNumber());
        }
        return introduction;
    }

    public void join(Klass klass) {
        this.klass.setNumber(klass.getNumber());
    }

    public boolean isIn(Klass klass) {
        return this.klass.getNumber() == klass.getNumber();
    }

    public int getKlass() {
        return klass != null ? klass.getNumber() : 0;
    }
}
