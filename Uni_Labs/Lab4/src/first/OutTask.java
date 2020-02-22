package first;

public class OutTask implements Task {

    private String message;

    @Override
    public void execute() {
        System.out.println(this.message);
    }

    public OutTask(String message) {
        this.message = message;
    }
}
