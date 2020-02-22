package Ex4;

import java.util.Collections;
import java.util.Comparator;

public class Ex4 {

    public static Comparator<Integer> comparator() {
        return new Comparator<Integer>() {
            @Override
            public int compare(final Integer a, final Integer b) {
                return -a.compareTo(b);
            }
        };
    }

    public static void main(final String[] args) {
        MyMap map = new MyMap(comparator());

        map.add(new Student4("Matei", 7.43F));
        map.add(new Student4("Andrei", 8.56F));
        map.add(new Student4("Matei", 7.88F));
        map.add(new Student4("George", 9.21F));
        map.add(new Student4("Cristi", 6.50F));
        map.add(new Student4("Laura", 9.50F));
        map.add(new Student4("Adriana", 8.50F));
        map.add(new Student4("Mara", 9.25F));
        map.add(new Student4("Lucian", 9.98F));

        for (int k : map.keySet()) {
            Collections.sort(map.get(k));
            System.out.println(map.get(k));
        }
    }
}
