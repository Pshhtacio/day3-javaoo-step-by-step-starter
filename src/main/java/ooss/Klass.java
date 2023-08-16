package ooss;

import java.util.ArrayList;
import java.util.List;

public class Klass {

    private int number;
    private int leaderId = 0;

    private final List<Teacher> attachedTeachers = new ArrayList<>();
    private final List<Student> attachedStudents = new ArrayList<>();

    public Klass(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
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
            leaderId = student.getId();
            student.setLeader(true);
            displayAttachedMessage(student.getName());
        } else {
            System.out.println("It is not one of us.");
        }
    }

    private void displayAttachedMessage(String name) {
        attachedTeachers.forEach(teacher -> displayTeacherMessage(teacher, name));
        attachedStudents.forEach(student -> displayStudentMessage(student, name));
    }

    private void displayTeacherMessage(Teacher teacher, String studentName) {
        if (attachedTeachers.contains(teacher)) {
            System.out.printf("I am %s, teacher of Class %s. I know %s become Leader.\n",
                    teacher.getName(), teacher.getKlasses(), studentName);
        }
    }

    private void displayStudentMessage(Student student, String studentName) {
        if (attachedStudents.contains(student)) {
            System.out.printf("I am %s, student of Class %s. I know %s become Leader.\n",
                    student.getName(), student.getKlass(), studentName);
        }
    }

    private boolean isInSameClass(Student student) {
        return student.getKlass() == this.number;
    }

    public boolean isLeader(Student student) {
        return leaderId == student.getId();
    }

    public <T extends Person> void attach(T attachable) {
        if (attachable instanceof Teacher) {
            attachedTeachers.add((Teacher) attachable);
        } else if (attachable instanceof Student) {
            attachedStudents.add((Student) attachable);
        }
    }
}
