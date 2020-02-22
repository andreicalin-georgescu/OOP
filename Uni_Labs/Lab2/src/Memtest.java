public class Memtest {

    private String[] v = new String[10000000];

    Memtest() {
        for(int i = 0; i < 100; i++) {
            v[i] = "abc";
        }
    }

    Memtest(final String abc) {
        for(int i = 0; i < 100; i++) {
            v[i] = new String(abc);
        }
    }

    public void showUsedMemory() {
        long usedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println(usedMem);
    }

    public static void main(String[] args) {
        Memtest memtest = new Memtest();
        memtest.showUsedMemory();
        Memtest memtest1 = new Memtest("abc");
        memtest1.showUsedMemory();
    }

}

