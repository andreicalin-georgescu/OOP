package Ex2;

public class Student2 extends Student {

    public Student2(final String name, final float average) {
        super(name, average);
    }

    @Override
    public boolean equals(final Object s) {
        return (this.name.equals(((Student2) s).name))
                && (this.average == ((Student2) s).average);
    }

    @Override
    public int hashCode() {
        int s = (int) this.average;
        for (int i = 0; i < this.name.length(); i++) {
            s += this.name.charAt(i);
        }
        s /= this.name.length();
        return s;
    }

}
