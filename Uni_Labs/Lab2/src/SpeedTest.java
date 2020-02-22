public class SpeedTest {

    private long runInteger() {
        long start = System.nanoTime();
        new Integer(2+3); // function which run time we want to measure
        return System.nanoTime() - start;
    }

    private long run() {
        long start = System.nanoTime();
        int a = 2 + 3; // function which run time we want to measure
        return System.nanoTime() - start;
    }

    public static void main(String[] args) {
        SpeedTest st = new SpeedTest();
        if (st.runInteger() > st.run()) {
            System.out.println("2 + 3 faster");
        } else if (st.run() > st.runInteger()) {
            System.out.println("Integer(2 + 3) faster");
        } else {
            System.out.println("Same speed");
        }
    }

}
