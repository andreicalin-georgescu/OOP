package first;

public class RandomOutTask implements Task {

    @Override
    public void execute() {
        System.out.println(Math.random());
    }

    //Default constructor

}
