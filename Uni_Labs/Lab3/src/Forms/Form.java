package Forms;

public class Form {

    public String color;

    public float getArea() {
        return 0;
    }

    public Form(final String color) {
        this.color = color;
    }

    public Form() {

    }

    @Override
    public String toString() {
        return color;
    }
}
