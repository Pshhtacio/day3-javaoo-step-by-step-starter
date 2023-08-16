package ooss;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person {

    private final String introduction = String.format("%s I am a teacher.", super.introduce());
    private List<Integer> klasses = new ArrayList<>();

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public String getKlasses() {
        return klasses.stream()
                .map(klass -> Integer.toString(klass))
                .collect(Collectors.joining(", "));
    }

    @Override
    public String introduce() {
        return !klasses.isEmpty()
                ? String.format("%s I teach Class %s.", introduction, klasses.stream()
                .map(klass -> Integer.toString(klass))
                .collect(Collectors.joining(", ")))
                : introduction;
    }

    public void assignTo(Klass klass) {
        klasses.add(klass.getNumber());
    }

    public boolean belongsTo(Klass klass) {
        return klasses.contains(klass.getNumber());
    }

    public boolean isTeaching(Student student) {
        return klasses.contains(student.getKlass());
    }
}
