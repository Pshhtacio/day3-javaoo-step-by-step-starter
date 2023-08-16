package ooss;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Teacher extends Person {

    private final String introduction = String.format("%s I am a teacher.", super.introduce());
    private List<Klass> klass = new ArrayList<>();
    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public String introduce() {
        return !this.klass.isEmpty()
                ? String.format("%s I teach Class %s.", introduction, klass.stream()
                    .map(klass -> Integer.toString(klass.getNumber()))
                    .collect(Collectors.joining(", ")))
                : introduction;
    }

    public void assignTo(Klass klass) {
        this.klass.add(klass);
    }

    public boolean belongsTo(Klass klass) {
        return this.klass.contains(klass);
    }

    public boolean isTeaching(Student student) {
        return this.klass.contains(student.getKlass());
    }
}
