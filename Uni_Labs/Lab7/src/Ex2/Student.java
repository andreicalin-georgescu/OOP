package Ex2;

public class Student {

    protected String name;
    public float average;

    public Student(final String newName, final float newAverage) {
        this.name = newName;
        this.average = newAverage;
    }

    public String toString() {
        return "[" + name + ", " + average + "]";
    }

}
