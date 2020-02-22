package Array;

public class QueueAggregation {
    private Array actualArray;
    private int start, end, elemCount;
    private final int size;

    QueueAggregation(final int size) {
        this.size = size;
        actualArray = new Array(size);
        start = 0;
        end = 0;
        elemCount = 0;
    }

    //gets next elem
    private int next(final int v) {
        return (v + 1) % size;
    }

    final int push(final int element) {
        if (elemCount == size) {
            return Array.ERROR;
        }

        actualArray.set(end, element);
        end = next(end);
        elemCount++;

        return 0;
    }

    final int pop() {
        if (elemCount == 0) {
            return Array.ERROR;
        }

        int val = actualArray.get(start);
        start = next(start);
        elemCount--;

        return val;
    }

    @Override
    public final String toString() {
        StringBuilder s = new StringBuilder("[");

        for (int i = 0; i < elemCount; ++i) {
            s.append(actualArray.get((start + i) % size)).append(" ");
        }

        return s + "]";
    }

    public void testQueue(QueueAggregation que) {

        if (que.push(10) != Array.ERROR) {
            System.out.println(que);
        } else {
            System.out.println("Error pushing value");
        }

        if (que.pop() == 10) {
            System.out.println(que);
        } else {
            System.out.println("Error popping value");
        }

        if (que.push(3) != Array.ERROR) {
            System.out.println(que);
        } else {
            System.out.println("Error pushing value");
        }

        if (que.push(4) != Array.ERROR) {
            System.out.println(que);
        } else {
            System.out.println("Error pushing value");
        }

        if (que.push(5) != Array.ERROR) {
            System.out.println(que);
        } else {
            System.out.println("Error pushing value 5");
        }

        if (que.pop() == 3) {
            System.out.println(que);
        } else {
            System.out.println("Error popping value");
        }

        if (que.pop() == 4) {
            System.out.println(que);
        } else {
            System.out.println("Error popping value");
        }

        if (que.pop() == Array.ERROR) {
            System.out.println(que);
        } else {
            System.out.println("Error popping value");
        }

        System.out.println("success");
    }

    public static void main(final String[] args) {
        QueueAggregation que = new QueueAggregation(2);
        que.testQueue(que);
    }
}
