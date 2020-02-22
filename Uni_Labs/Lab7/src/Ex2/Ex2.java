package Ex2;

import java.util.HashSet;

public class Ex2 {
    public static void main(final String[] args) {
        HashSet<Student2> set = new HashSet<Student2>();

        int size = set.size();
        set.add(new Student2("Matei", 7F));

        if (size == set.size()) {
            System.out.println("EROARE!!! ELEMENT DUPLICAT 1");
        }

        size = set.size();
        set.add(new Student2("Andrei", 8F));

        if (size == set.size()) {
            System.out.println("EROARE!!! ELEMENT DUPLICAT 2");
        }

        size = set.size();
        set.add(new Student2("Matei", 7F));

        if (size == set.size()) {
            System.out.println("EROARE!!! ELEMENT DUPLICAT 3");
        }

        size = set.size();
        set.add(new Student2("George", 9F));

        if (size == set.size()) {
            System.out.println("EROARE!!! ELEMENT DUPLICAT 4");
        }

        size = set.size();
        set.add(new Student2("Andrei", 6F));

        if (size == set.size()) {
            System.out.println("EROARE!!! ELEMENT DUPLICAT 5");
        }
    }
}
