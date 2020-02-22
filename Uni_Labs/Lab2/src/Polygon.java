public class Polygon {

    private Point[] points;

    public Polygon(final int n) {
        points = new Point[n];
    }

    public Polygon(final float[] p) {
        this(p.length / 2);

        int j = 0;

        for (int i = 0; i < points.length; i++) {
            this.points[i] = new Point(p[j], p[j + 1]);
            j+=2;
        }
    }

    public void printPolygon() {
        for (int i = 0; i < points.length; i++) {
            points[i].printPoint();
        }
    }

    public static void main(String[] args) {
        float[] points = {2, 3, 4, 0, -1, 6};

        Polygon poly = new Polygon(points);

        poly.printPolygon();
    }

}
