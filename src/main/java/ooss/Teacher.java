package ooss;

public class Teacher extends Person {
    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public String introduce() {
        return String.format("%s I am a teacher.", super.introduce());
    }
}
