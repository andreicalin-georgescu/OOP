package second;

import first.Task;

import java.util.ArrayList;

public class Queue implements  Container {

    private ArrayList<Task> list = new ArrayList<>();

    @Override
    public Task pop() {
        return list.remove(list.size() - 1);
    }

    @Override
    public void push(Task task) {
        list.add(task);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }

    @Override
    public void transferFrom(Container container) {
        for (int i = 0; i < container.size(); i++) {
            this.push(container.pop());
        }
    }
}
