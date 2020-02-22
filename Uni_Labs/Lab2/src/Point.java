public class Point {

    private float x;
    private float y;

    public Point(final float x, final float y) {
        this.changeCoords(x, y);
    }

    public void changeCoords(final float x, final float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void printPoint() {
        System.out.println("( " + this.getX() + " " + this.getY() + " )");
    }

}
