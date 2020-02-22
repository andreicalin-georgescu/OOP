package Ex2;

public class MyVector3 implements Summable {

    private int[] v = new int[3];

    public MyVector3(final int[] v) {
        this.v = v;
    }

    @Override
    public void addValue(final Summable value) {
        for (int i = 0; i < 3; i++) {
            v[i] += ((MyVector3) value).v[i];
        }
    }

    @Override
    public String toString() {
        String out = "MyVector3:\n";

        for (int i = 0; i < 3; i++) {
            out += v[i] + " ";
        }

        return out + '\n';
    }
}
