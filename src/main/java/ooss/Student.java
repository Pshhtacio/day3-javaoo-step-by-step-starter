package ooss;

public class Student extends Person {

    private final Klass klass = new Klass(0);
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
        String studentIntroduction = String.format("%s I am in class %d.", introduction, klass.getNumber());
        String leaderIntroduction = String.format("%s I am the leader of class %d.", introduction, klass.getNumber());
        if (klass.getNumber() == 0) {
            return introduction;
        }
        return isLeader ? leaderIntroduction : studentIntroduction;
    }

    public void join(Klass klass) {
        this.klass.setNumber(klass.getNumber());
    }

    public boolean isIn(Klass klass) {
        return this.klass.equals(klass);
    }

    public int getKlass() {
        return klass.getNumber();
    }

    public void printAttachedMessage(String studentName) {
        System.out.printf("I am %s, student of Class %s. I know %s become Leader.\n",
                super.getName(), getKlass(), studentName);
    }
}
