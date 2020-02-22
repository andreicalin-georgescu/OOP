package Ex2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Test2 {

    static <T extends Summable> T sumAll(final Collection<T> c) {
        Iterator<T> it = c.iterator();
        T sum = it.next();

        while (it.hasNext()) {
            sum.addValue(it.next());
        }

        return sum;
    }

    public static void main(final String[] args) {
        int[][] m = {{1, 1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}, {4, 4, 4, 4}};

        MyMatrix mm1 = new MyMatrix(m);
        MyMatrix mm2 = new MyMatrix(m);
        MyMatrix mm3 = new MyMatrix(m);
        ArrayList<Summable> am = new ArrayList<>();

        am.add(mm1);
        am.add(mm2);
        am.add(mm3);

        System.out.println(sumAll(am));

        int[] v = {3, 2, 1};

        MyVector3 mv1 = new MyVector3(v);
        MyVector3 mv2 = new MyVector3(v);
        MyVector3 mv3 = new MyVector3(v);
        ArrayList<Summable> av = new ArrayList<>();

        av.add(mv1);
        av.add(mv2);
        av.add(mv3);

        System.out.println(sumAll(av));
    }
}
