
import java.util.Scanner;

import Service.TaskService;

public class AstronautScheduleApp {
    private static final TaskService taskService = new TaskService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Welcome to the Astronaut Schedule Organizer!");
        printMenu();

        while (true) {
            System.out.print("\nEnter command: ");
            command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "1":
                    taskService.addTask(scanner);
                    break;
                case "2":
                    taskService.removeTask(scanner);
                    break;
                case "3":
                    taskService.viewTasks();
                    break;
                case "4":
                    taskService.editTask(scanner);
                    break;
                case "5":
                    taskService.markTaskAsCompleted(scanner);
                    break;
                case "6":
                    taskService.viewTasksByPriority(scanner);
                    break;
                case "exit":
                    System.out.println("Exiting the Astronaut Schedule Organizer. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid command. Please try again.");
                    printMenu();
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nMenu:");
        System.out.println("1 - Add Task");
        System.out.println("2 - Remove Task");
        System.out.println("3 - View All Tasks");
        System.out.println("4 - Edit Task");
        System.out.println("5 - Mark Task as Completed");
        System.out.println("6 - View Tasks by Priority");
        System.out.println("Type 'exit' to quit the application.");
    }
}

