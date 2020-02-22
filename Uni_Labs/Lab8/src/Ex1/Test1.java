package Ex1;

public class Test1 {

    static class Pair implements Comparable<Pair> {
        private int a;
        private int b;

        Pair(final int newA, final int newB) {
            this.a = newA;
            this.b = newB;
        }

        @Override
        public int hashCode() {
            return Math.abs(this.a - this.b) * 10 + Math.min(this.a, this.b);
        }

        @Override
        public boolean equals(final Object o) {
            return (o instanceof Pair) && ((Pair) o).hashCode() == this.hashCode();
        }

        @Override
        public int compareTo(final Pair p) {
            return this.hashCode() - p.hashCode();
        }

        @Override
        public String toString() {
            return "(" + a + ", " + b + ")";
        }
    }

    public static void main(final String[] args) {
        MyHashMap<Pair, Integer> hashmap = new MyHashMap<>();

        hashmap.put(new Pair(1, 2), 3);
        hashmap.put(new Pair(5, 1), 5);
        hashmap.put(new Pair(5, 1), 15);    // suprascrie (5,1) -> 5
        hashmap.put(new Pair(3, 2), 4);
        hashmap.put(new Pair(2, 3), 11);    // suprascrie (3,2) -> 4

        Pair p = new Pair(4, 8);

        hashmap.put(p, 10);

        System.out.println(hashmap.get(p)); // 10
        System.out.println(hashmap.get(new Pair(6, 2))); // null

        System.out.println(hashmap);

        for (Pair pair : hashmap) {
            System.out.println(pair);
        }
    }
}