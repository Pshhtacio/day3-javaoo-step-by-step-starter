package ooss;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person {
    private final List<Integer> klasses;

    public Teacher(int id, String name, int age) {
        super(id, name, age);
        klasses = new ArrayList<>();
    }

    public String getKlasses() {
        return klasses.stream()
                .map(klass -> Integer.toString(klass))
                .collect(Collectors.joining(", "));
    }

    @Override
    public String introduce() {
        String teacherIntroduction = String.format("%s I am a teacher.", super.introduce());
        String teacherWithKlassIntroduction = getKlassIntroduction(teacherIntroduction);
        if (klasses.isEmpty()) {
            return teacherIntroduction;
        }
        return teacherWithKlassIntroduction;
    }

    private String getKlassIntroduction(String introduction) {
        return String.format("%s I teach Class %s.", introduction, klasses.stream()
                .map(klass -> Integer.toString(klass))
                .collect(Collectors.joining(", ")));
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

    public void printAttachedMessage(String studentName) {
        System.out.printf("I am %s, teacher of Class %s. I know %s become Leader.\n",
                super.getName(), getKlasses(), studentName);
    }
}
