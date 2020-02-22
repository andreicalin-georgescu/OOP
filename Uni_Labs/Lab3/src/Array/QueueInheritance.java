package Array;

public class QueueInheritance extends Array {
    private int start, end, elemCount;
    private final int size;

    QueueInheritance(final int size) {
        super(size);

        this.size = size;
        start = 0;
        end = 0;
        elemCount = 0;
    }


    private int next(final int v) {
        return (v + 1) % size;
    }


    final int push(final int element) {
        if (elemCount == size) {
            return Array.ERROR;
        }

        this.set(end, element);
        end = next(end);
        elemCount++;
        return 0;
    }

    final int pop() {
        if (elemCount == 0) {
            return Array.ERROR;
        }

        int val = this.get(start);
        start = next(start);
        elemCount-- ;
        return 0;
    }

    @Override
    public final String toString() {
        StringBuilder s = new StringBuilder("[");

        for (int i = 0; i < elemCount; ++i) {
            s.append(this.get((start + i) % size)).append(" ");
        }

        return s + "]";
    }


}
