package Ex2;

public class MyMatrix implements Summable {

    private int[][] matrix = new int[4][4];

    public MyMatrix(final int[][] newMatrix) {
        this.matrix = newMatrix;
    }

    @Override
    public void addValue(final Summable value) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] += ((MyMatrix) value).matrix[i][j];
            }
        }
    }

    @Override
    public String toString() {
        String out = "MyMatrix:\n";

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                out += matrix[i][j] + " ";
            }

            out += '\n';
        }

        return out;
    }
}
