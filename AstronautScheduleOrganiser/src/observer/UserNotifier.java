package observer;

import model.Task;

public class UserNotifier implements Observer {
    @Override
    public void update(Task task) {
        System.out.println("Notification: Task '" + task.getDescription() + 
                           "' conflicts with an existing task. Please check your schedule.");
    }
}
