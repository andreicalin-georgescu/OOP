package Ex3;

import Ex2.Student;

public class Student3 extends Student {

    public Student3(final String name, final float average) {
        super(name, average);
    }

    public boolean equals(final Student3 s) {
        return false;
    }

    public int hashCode() {
        int s = (int) this.average;

        for (int i = 0; i < this.name.length(); i++) {
            s += this.name.charAt(i);
        }

        s /= this.name.length();

        return s;
    }

}
