package ComplexNumber;

public class TestOperation {

    private Operations op = new Operations();

    public ComplexNumber getComplexNumber(float re, float im) {
        ComplexNumber c = new ComplexNumber();
        c.setRe(re);
        c.setIm(im);
        return c;
    }

    public void testAdd () {
        ComplexNumber c1 = getComplexNumber(3,4);
        ComplexNumber c2 = getComplexNumber(5,6);

        c1.print();
        c2.print();
        System.out.println("Rezultat: ");
        op.add(c1, c2).print();
    }

    public void testMultiply() {
        ComplexNumber c1 = getComplexNumber(3,4);
        ComplexNumber c2 = getComplexNumber(5,6);

        c1.print();
        c2.print();

        System.out.println("Rezultat: ");
        op.multiply(c1, c2).print();
    }

}
