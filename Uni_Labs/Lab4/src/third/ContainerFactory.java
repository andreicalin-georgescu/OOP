package third;

import second.Container;
import second.Queue;
import second.Stack;

public class ContainerFactory implements IFactory {
    public static final ContainerFactory INSTANCE = new ContainerFactory();

    private ContainerFactory() {
    }

    @Override
    public Container createContainer(Strategy strategy) {
        if (strategy == Strategy.LIFO) {
            return new Queue();
        }

        if (strategy == Strategy.FIFO) {
            return new Stack();
        }

        return null;
    }
}