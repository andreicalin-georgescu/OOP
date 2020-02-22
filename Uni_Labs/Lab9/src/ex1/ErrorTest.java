package ex1;

public class ErrorTest {

    public void outOfMemoryTest() {
        @SuppressWarnings("unused")
        double[] a = new double[Integer.MAX_VALUE];
    }

    public void stackOverflowTest() {
        stackOverflowTest();
    }

    public static void main(final String[] args) {
        ErrorTest test = new ErrorTest();

        try {
            test.outOfMemoryTest();
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }

        try {
            test.stackOverflowTest();
        } catch (StackOverflowError e) {
            e.printStackTrace();
        }

        System.out.println("We made some waves, but it's alright!");
    }
}
