package Ex4;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class MyMap extends TreeMap<Integer, List<Student4>> {

    public MyMap(final Comparator<Integer> c) {
        super(c);
    }

    public void add(final Student4 s) {
        int m = Math.round(s.average);

        if (super.get(m) == null) {
            LinkedList<Student4> s1 = new LinkedList<Student4>();

            super.put(m, s1);
        }

        List<Student4> list = super.get(m);
        list.add(s);
    }
}
