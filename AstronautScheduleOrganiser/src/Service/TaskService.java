package Service;

import java.util.List;
import java.util.Scanner;

import Factory.TaskFactory;
import Singleton.ScheduleManager;
import model.Task;
import observer.UserNotifier;

public class TaskService {
	
//	private static final ScheduleManager scheduleManager = ScheduleManager.getInstance();
//    private static final TaskFactory taskFactory = new TaskFactory();
//    private static final UserNotifier userNotifier = new UserNotifier();
//
//    public TaskService() {
//        scheduleManager.addObserver(userNotifier);
//    }
//
//    public void addTask(Scanner scanner) {
//        System.out.print("Enter task description: ");
//        String description = scanner.nextLine().trim();
//
//        System.out.print("Enter start time (HH:mm): ");
//        String startTime = scanner.nextLine().trim();
//
//        System.out.print("Enter end time (HH:mm): ");
//        String endTime = scanner.nextLine().trim();
//
//        System.out.print("Enter priority level (High, Medium, Low): ");
//        String priority = scanner.nextLine().trim();
//
//        Task task = taskFactory.createTask(description, startTime, endTime, priority);
//        if (scheduleManager.addTask(task)) {
//            System.out.println("Task added successfully.");
//        } else {
//            System.out.println("Error: Task conflicts with an existing task or has invalid time format.");
//        }
//    }
//
//    public void removeTask(Scanner scanner) {
//        System.out.print("Enter task description to remove: ");
//        String description = scanner.nextLine().trim();
//
//        if (scheduleManager.removeTask(description)) {
//            System.out.println("Task removed successfully.");
//        } else {
//            System.out.println("Error: Task not found.");
//        }
//    }
//
//    public void viewTasks() {
//        List<Task> tasks = scheduleManager.viewTasks();
//        if (tasks.isEmpty()) {
//            System.out.println("No tasks scheduled for the day.");
//        } else {
//            tasks.forEach(task -> System.out.println(task));
//        }
//    }
//
//    public void editTask(Scanner scanner) {
//        System.out.print("Enter task description to edit: ");
//        String description = scanner.nextLine().trim();
//
//        if (!scheduleManager.taskExists(description)) {
//            System.out.println("Error: Task not found.");
//            return;
//        }
//
//        System.out.print("Enter new start time (HH:mm): ");
//        String startTime = scanner.nextLine().trim();
//
//        System.out.print("Enter new end time (HH:mm): ");
//        String endTime = scanner.nextLine().trim();
//
//        System.out.print("Enter new priority level (High, Medium, Low): ");
//        String priority = scanner.nextLine().trim();
//
//        Task task = taskFactory.createTask(description, startTime, endTime, priority);
//        if (scheduleManager.editTask(description, task)) {
//            System.out.println("Task edited successfully.");
//        } else {
//            System.out.println("Error: Task conflicts with an existing task or has invalid time format.");
//        }
//    }
//
//    public void markTaskAsCompleted(Scanner scanner) {
//        System.out.print("Enter task description to mark as completed: ");
//        String description = scanner.nextLine().trim();
//
//        try {
//			try {
//				if (scheduleManager.markTaskAsCompleted(description)) {
//				    System.out.println("Task marked as completed.");
//				} else {
//				    System.out.println("Error: Task not found.");
//				}
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    }
//
//    public void viewTasksByPriority(Scanner scanner) {
//        System.out.print("Enter priority level to filter tasks (High, Medium, Low): ");
//        String priority = scanner.nextLine().trim();
//
//        List<Task> tasks = scheduleManager.viewTasksByPriority(priority);
//        if (tasks.isEmpty()) {
//            System.out.println("No tasks found with priority " + priority + ".");
//        } else {
//            tasks.forEach(task -> System.out.println(task));
//        }
//}
	private static final ScheduleManager scheduleManager = ScheduleManager.getInstance();
    private static final TaskFactory taskFactory = new TaskFactory();
    private static final UserNotifier userNotifier = new UserNotifier();

    public TaskService() {
        scheduleManager.registerObserver(userNotifier);
    }

    public void addTask(Scanner scanner) {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine().trim();

        System.out.print("Enter start time (HH:mm): ");
        String startTime = scanner.nextLine().trim();

        System.out.print("Enter end time (HH:mm): ");
        String endTime = scanner.nextLine().trim();

        System.out.print("Enter priority level (High, Medium, Low): ");
        String priority = scanner.nextLine().trim();

        Task task = taskFactory.createTask(description, startTime, endTime, priority);
        if (scheduleManager.addTask(task)) {
            System.out.println("Task added successfully.");
        } else {
            System.out.println("Error: Task conflicts with an existing task or has invalid time format.");
        }
    }

    public void removeTask(Scanner scanner) {
        System.out.print("Enter task description to remove: ");
        String description = scanner.nextLine().trim();

        if (scheduleManager.removeTask(description)) {
            System.out.println("Task removed successfully.");
        } else {
            System.out.println("Error: Task not found.");
        }
    }

    public void viewTasks() {
        List<Task> tasks = scheduleManager.getTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
        } else {
            tasks.forEach(task -> System.out.println(task));
        }
    }

    public void editTask(Scanner scanner) {
        System.out.print("Enter task description to edit: ");
        String description = scanner.nextLine().trim();

        if (!scheduleManager.taskExists(description)) {
            System.out.println("Error: Task not found.");
            return;
        }

        System.out.print("Enter new start time (HH:mm): ");
        String startTime = scanner.nextLine().trim();

        System.out.print("Enter new end time (HH:mm): ");
        String endTime = scanner.nextLine().trim();

        System.out.print("Enter new priority level (High, Medium, Low): ");
        String priority = scanner.nextLine().trim();

        Task task = taskFactory.createTask(description, startTime, endTime, priority);
        if (scheduleManager.editTask(task)) {
            System.out.println("Task edited successfully.");
        } else {
            System.out.println("Error: Task conflicts with an existing task or has invalid time format.");
        }
    }

    public void markTaskAsCompleted(Scanner scanner) {
        System.out.print("Enter task description to mark as completed: ");
        String description = scanner.nextLine().trim();

        if (scheduleManager.markTaskAsCompleted(description)) {
            System.out.println("Task marked as completed.");
        } else {
            System.out.println("Error: Task not found.");
        }
    }

    public void viewTasksByPriority(Scanner scanner) {
        System.out.print("Enter priority level to filter tasks (High, Medium, Low): ");
        String priority = scanner.nextLine().trim();

        List<Task> tasks = scheduleManager.getTasksByPriority(priority);
        if (tasks.isEmpty()) {
            System.out.println("No tasks found with priority " + priority + ".");
        } else {
            tasks.forEach(task -> System.out.println(task));
        }
    }
    }
