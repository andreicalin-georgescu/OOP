package ex23;

import java.util.ArrayList;
import java.util.List;


public class Test {

    public static void main(final String[] args) {
        Calculator calc = new Calculator();

        // Integer Overflow test
        try {
            System.out.println(calc.add(Integer.MAX_VALUE, 1));
        } catch (OverflowException e) {
            e.printStackTrace();
        }

        // Integer Underflow test
        try {
            System.out.println(calc.add(Integer.MIN_VALUE, -1));
        } catch (UnderflowException e) {
            e.printStackTrace();
        }

        // Calculator average test suite
        List<Integer> list = new ArrayList<>();

        list.add(4);
        list.add(-8);
        list.add(Integer.MAX_VALUE - 6);
        list.add(14);

        // Integer Overflow test
        try {
            System.out.println(calc.average(list));
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        list.clear();

        // Division by zero test -> finally proof
        try {
            System.out.println(calc.average(list));
        } catch (RuntimeException e) {
            e.printStackTrace();
            // This should force main to return
            return;
        } finally {
            // But wait, there is some more work to be done
            System.out.println("Some nasty business was going on!");
        }
    }

}
