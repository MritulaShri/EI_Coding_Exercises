package Singleton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import model.Task;
import observer.Observer;

public class ScheduleManager {
//	private static ScheduleManager instance;
//    private final List<Task> tasks;
//    private final List<Observer> observers;
//
//    private ScheduleManager() {
//        tasks = new ArrayList<>();
//        observers = new ArrayList<>();
//    }
//
//    public static ScheduleManager getInstance() {
//        if (instance == null) {
//            instance = new ScheduleManager();
//        }
//        return instance;
//    }
//
//    public void registerObserver(Observer observer) {
//        observers.add(observer);
//    }
//
//    public boolean addTask(Task task) {
//        if (isConflict(task)) {
//            notifyObservers(task);
//            return false;
//        }
//        tasks.add(task);
//        Collections.sort(tasks, Comparator.comparing(Task::getStartTime));
//        return true;
//    }
//
//    public boolean removeTask(String description) {
//        return tasks.removeIf(task -> task.getDescription().equalsIgnoreCase(description));
//    }
//
//    public boolean taskExists(String description) {
//        return tasks.stream().anyMatch(task -> task.getDescription().equalsIgnoreCase(description));
//    }
//
//    public boolean editTask(Task newTask) {
//        if (isConflict(newTask)) {
//            notifyObservers(newTask);
//            return false;
//        }
//        removeTask(newTask.getDescription());
//        tasks.add(newTask);
//        Collections.sort(tasks, Comparator.comparing(Task::getStartTime));
//        return true;
//    }
//
//    public boolean markTaskAsCompleted(String description) {
//        for (Task task : tasks) {
//            if (task.getDescription().equalsIgnoreCase(description)) {
//                task.setCompleted(true);
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public List<Task> getTasks() {
//        return new ArrayList<>(tasks);
//    }
//
//    public List<Task> getTasksByPriority(String priority) {
//        List<Task> priorityTasks = new ArrayList<>();
//        for (Task task : tasks) {
//            if (task.getPriority().equalsIgnoreCase(priority)) {
//                priorityTasks.add(task);
//            }
//        }
//        return priorityTasks;
//    }
//
//    private boolean isConflict(Task newTask) {
//        for (Task task : tasks) {
//            if (task.conflictsWith(newTask)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private void notifyObservers(Task task) {
//        for (Observer observer : observers) {
//            observer.update(task);
//        }
//}

	private static ScheduleManager instance;
    private final List<Task> tasks;
    private final List<Observer> observers;

    private ScheduleManager() {
        tasks = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public boolean addTask(Task task) {
        if (isConflict(task)) {
            notifyObservers(task);
            return false;
        }
        tasks.add(task);
        Collections.sort(tasks, Comparator.comparing(Task::getStartTime));
        return true;
    }

    public boolean removeTask(String description) {
        return tasks.removeIf(task -> task.getDescription().equalsIgnoreCase(description));
    }

    public boolean taskExists(String description) {
        return tasks.stream().anyMatch(task -> task.getDescription().equalsIgnoreCase(description));
    }

    public boolean editTask(Task newTask) {
        if (isConflict(newTask)) {
            notifyObservers(newTask);
            return false;
        }
        removeTask(newTask.getDescription());
        tasks.add(newTask);
        Collections.sort(tasks, Comparator.comparing(Task::getStartTime));
        return true;
    }

    public boolean markTaskAsCompleted(String description) {
        for (Task task : tasks) {
            if (task.getDescription().equalsIgnoreCase(description)) {
                task.setCompleted(true);
                return true;
            }
        }
        return false;
    }

    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }

    public List<Task> getTasksByPriority(String priority) {
        List<Task> priorityTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getPriority().equalsIgnoreCase(priority)) {
                priorityTasks.add(task);
            }
        }
        return priorityTasks;
    }

    private boolean isConflict(Task newTask) {
        for (Task task : tasks) {
            if (task.conflictsWith(newTask)) {
                return true;
            }
        }
        return false;
    }

    private void notifyObservers(Task task) {
        for (Observer observer : observers) {
            observer.update(task);
        }
    }

}
