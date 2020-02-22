package Ex3;

import java.util.HashSet;
import java.util.Iterator;

public class Ex3 {

    public static void main(final String[] args) {
        HashSet<Student3> set = new HashSet<Student3>();

        set.add(new Student3("Matei", 7F));
        set.add(new Student3("Andrei", 8F));
        set.add(new Student3("Matei", 7F));
        set.add(new Student3("George", 9F));
        set.add(new Student3("Andrei", 6F));

        Iterator<Student3> it = set.iterator();

        while (it.hasNext()) {
            Student3 element = it.next();

            System.out.println(element.equals(element));
            System.out.println(((Object) element).equals(element));
            System.out.println();
        }
    }
}
