package Ex5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class MyLinkedList extends LinkedList<Integer> {
    private int size = 0;

    @Override
    public boolean add(final Integer a) {
        size++;

        return super.add(a);
    }

    @Override
    public boolean addAll(final Collection<? extends Integer> c) {
        size += c.size();

        return super.addAll(c);
    }

    public static void main(final String[] args) {
        MyLinkedList h = new MyLinkedList();
        ArrayList<Integer> l = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++) {
            l.add(i);
        }

        h.add(234);
        System.out.println(h.size);

        h.add(67);
        System.out.println(h.size);

        h.add(3455);
        System.out.println(h.size);

        h.addAll(l);
        System.out.println(h.size);
    }
}
