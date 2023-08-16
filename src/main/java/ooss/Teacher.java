package ooss;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person {

    private final String introduction = String.format("%s I am a teacher.", super.introduce());
    private List<Integer> klass = new ArrayList<Integer>();

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public String getKlasses(){
        return this.klass.stream()
                .map(klass -> Integer.toString(klass))
                .collect(Collectors.joining(", "));
    }

    public String introduce() {
        return !this.klass.isEmpty()
                ? String.format("%s I teach Class %s.", this.introduction, this.klass.stream()
                .map(klass -> Integer.toString(klass))
                .collect(Collectors.joining(", ")))
                : this.introduction;
    }

    public void assignTo(Klass klass) {
        this.klass.add(klass.getNumber());
    }

    public boolean belongsTo(Klass klass) {
        return this.klass.contains(klass.getNumber());
    }

    public boolean isTeaching(Student student) {
        return this.klass.contains(student.getKlass());
    }
}
