package ooss;

import java.util.ArrayList;
import java.util.List;

public class Klass {

    private int number;
    private int leader = 0;

    private List<Teacher> attachedTeachers = new ArrayList<>();
    private List<Student> attachedStudents = new ArrayList<>();

    public Klass(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Klass)) return false;
        Klass klass = (Klass) o;
        return number == klass.number;
    }

    public void assignLeader(Student student) {
        if (isInSameClass(student)) {
            this.leader = student.getId();
            student.setLeader(true);
            displayAttachedMessage(student.getName());
        } else {
            System.out.println("It is not one of us.");
        }
    }

    private void displayAttachedMessage(String name) {
        attachedTeachers.forEach(teacher -> {
            if (attachedTeachers.contains(teacher))
                System.out.printf(String.format("I am %s, teacher of Class %s. I know %s become Leader.", teacher.getName(), teacher.getKlasses(), name));
        });
        attachedStudents.forEach(student -> {
            if (attachedStudents.contains(student))
                System.out.printf(String.format("I am %s, student of Class %s. I know %s become Leader.", student.getName(), student.getKlass(), name));
        });
    }

    private boolean isInSameClass(Student student) {
        return student.getKlass() == this.number;
    }

    public boolean isLeader(Student student) {
        return this.leader == student.getId();
    }

    public <T extends Person> void attach(T attachable) {
        if (attachable instanceof Teacher) {
            attachedTeachers.add((Teacher) attachable);
        } else if (attachable instanceof Student) {
            attachedStudents.add((Student) attachable);
        }
    }


}
