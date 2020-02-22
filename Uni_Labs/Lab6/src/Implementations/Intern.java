package Implementations;

//TODO implementati interfata Visitable
public class Intern implements Visitable {

    private String  name;
    private int duration;  // in months

    public String getName() {
        return name;
    }

    @Override
    public void accept(Visitor v) {
            v.visit(this);
    }


    public Intern(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
