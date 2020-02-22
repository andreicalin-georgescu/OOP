package Ex4;

import Ex2.Student;

public class Student4 extends Student implements Comparable<Student4> {

    public Student4(final String name, final float average) {
        super(name, average);
    }

    @Override
    public int compareTo(final Student4 s) {
        return this.name.compareTo(s.name);
    }

}
