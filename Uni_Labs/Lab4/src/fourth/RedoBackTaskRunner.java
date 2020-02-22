package fourth;

import first.Task;
import second.Container;
import third.ContainerFactory;
import third.Strategy;

public class RedoBackTaskRunner extends AbstractTaskRunner {

    private Container reversedContainer;

    public RedoBackTaskRunner(Strategy strategy) {
        super(strategy);
        reversedContainer = ContainerFactory.INSTANCE.createContainer(Strategy.LIFO);
    }

    public void redo() {
        while (!reversedContainer.isEmpty())
            reversedContainer.pop().execute();
    }

    @Override
    protected void afterExecution(Task task) {
        reversedContainer.push(task);
    }

}
