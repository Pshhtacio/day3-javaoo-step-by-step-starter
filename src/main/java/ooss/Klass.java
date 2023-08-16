package ooss;

public class Klass {

    private final int number;
    private int leader = 0;

    public Klass(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
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
        } else {
            System.out.println("It is not one of us.");
        }
    }

    private boolean isInSameClass(Student student) {
        return student.getKlass() != null && student.getKlass().equals(this);
    }

    public boolean isLeader(Student student) {
        return this.leader == student.getId();
    }
}
