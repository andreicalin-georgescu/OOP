package first;

public class CounterOutTask implements Task {

    public static int counter = 0;

    @Override
    public void execute() {
        System.out.println(CounterOutTask.counter);
    }

    public CounterOutTask() {
        CounterOutTask.counter++;
    }
}
