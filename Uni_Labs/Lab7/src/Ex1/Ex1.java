package Ex1;

import java.util.HashSet;

public class Ex1 {
    public static void main(final String[] args) {
        HashSet<String> set = new HashSet<String>();

        for (int i = 0; i < 10; i++) {
            int size = set.size();

            if (set.add(String.valueOf(i % 5))) {
                System.out.println(i % 5);
            }

            if (size == set.size()) {
                System.out.println("EROARE!!! ELEMENT DUPLICAT " + i % 5);
            }
        }
    }
}
