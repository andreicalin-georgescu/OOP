package fourth;

import first.Task;
import third.Strategy;

import java.util.Date;


public class PrintTimeTaskRunner extends AbstractTaskRunner {

    @Override
    protected void afterExecution(Task task) {
        System.out.println(new Date().toString());
    }

    public PrintTimeTaskRunner(Strategy strategy) {
        super(strategy);
    }
}
