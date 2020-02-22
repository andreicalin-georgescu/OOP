package ex23;

import java.util.Collection;


public class Calculator {

    public int add(final int a, final int b) {
        if ((b > 0) && (a > Integer.MAX_VALUE - b)) {
            throw new OverflowException();
        }

        if ((b < 0) && (a < Integer.MIN_VALUE - b)) {
            throw new UnderflowException();
        }

        return a + b;
    }

    public int divide(final int a, final int b) {
        return a / b;
    }

    public int average(final Collection<Integer> c) {
        int sum = 0;

        for (Integer x : c) {
            sum = add(sum, x);
        }

        return divide(sum, c.size());
    }

}
