package Forms;

public class Circle extends Form {
    private float radius;

    public Circle() {
        this.radius = 0;
    }

    public Circle(final String color, final float radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public float getArea() {
        return (float) (this.radius * Math.PI * Math.PI);
    }

    @Override
    public String toString() {
        return String.format("Cerc: %s, %.2f", super.toString(), getArea());
    }

    public void printCircleDimensions() {
        System.out.println(String.format("Cerc cu culoare: %s si raza %.2f", super.toString(), radius));
    }
}
