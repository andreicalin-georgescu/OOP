package Forms;

public class Triangle extends Form {
    private float height;
    private float base;

    public Triangle() {
        this.base = 0;
        this.height = 0;
    }

    public Triangle(final String color,final float height, final float base) {
        super(color);
        this.height = height;
        this.base = base;
    }

    @Override
    public float getArea() {
        return this.base * this.height / 2;
    }

    @Override
    public String toString() {
        return String.format("Triunghi: %s, %.2f", super.toString(), getArea());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Triangle)) {
            return false;
        }

        Triangle triangle = (Triangle) obj;

        if (!(this.color.equals(triangle.color))) {
            return false;
        }

        if (this.height != triangle.height) {
            return false;
        }

        if (this.base != triangle.base) {
            return false;
        }

        return true;
    }

    public void printTriangleDimensions() {
        System.out.println(String.format("Triunghi cu culoarea: %s, baza %.2f si inaltime %.2f", super.toString(), base, height));
    }
}
