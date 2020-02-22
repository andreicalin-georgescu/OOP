package Forms;

final class Test {

    private Test() {
    }

    public static void main(final String[] args) {

        Circle c1 = new Circle("verde", 2);
        Circle c2 = new Circle("rosu", 2);
        Circle c3 = new Circle("verde", 2);

        Triangle t1 = new Triangle("albastru", 3, 1);
        Triangle t2 = new Triangle("verde", 2, 2);
        Triangle t3 = new Triangle("albastru", 3, 1);

        System.out.println(c1);
        System.out.println(t1);
        System.out.println(c1.equals(c3));
        System.out.println(t1.equals(t3));

        Form[] f = new Form[4];
        f[0] = c1;
        f[1] = c2;
        f[2] = t1;
        f[3] = t2;

        for (int i = 0; i < f.length; i++) {
            System.out.println(f[i].toString());
        }

        for (int i = 0; i < f.length; i++) {
            if (f[i] instanceof Circle) {
                ((Circle) f[i]).printCircleDimensions();
            }

            if (f[i] instanceof Triangle) {
                ((Triangle) f[i]).printTriangleDimensions();
            }
        }
    }
}
