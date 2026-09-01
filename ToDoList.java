import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String taskName;
    boolean completed;

    Task(String taskName) {
        this.taskName = taskName;
        this.completed = false;
    }
}

public class ToDoList {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Task> tasks = new ArrayList<>();

        while (true) {

            System.out.println("\n===== TO-DO LIST =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Complete Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter task: ");
                    String taskName = sc.nextLine();

                    tasks.add(new Task(taskName));

                    System.out.println("Task added successfully!");
                    break;

                case 2:

                    if (tasks.isEmpty()) {
                        System.out.println("No tasks available.");
                    } else {

                        System.out.println("\n===== YOUR TASKS =====");

                        for (int i = 0; i < tasks.size(); i++) {

                            Task task = tasks.get(i);

                            System.out.println(
                                    (i + 1) + ". " +
                                            task.taskName + " - " +
                                            (task.completed ? "Completed" : "Pending")
                            );
                        }
                    }
                    break;

                case 3:

                    if (tasks.isEmpty()) {
                        System.out.println("No tasks available.");
                    } else {

                        System.out.print("Enter task number: ");
                        int number = sc.nextInt();

                        if (number >= 1 && number <= tasks.size()) {

                            tasks.get(number - 1).completed = true;

                            System.out.println("Task completed!");

                        } else {
                            System.out.println("Invalid task number.");
                        }
                    }
                    break;

                case 4:

                    if (tasks.isEmpty()) {
                        System.out.println("No tasks available.");
                    } else {

                        System.out.print("Enter task number to delete: ");
                        int number = sc.nextInt();

                        if (number >= 1 && number <= tasks.size()) {

                            tasks.remove(number - 1);

                            System.out.println("Task deleted!");

                        } else {
                            System.out.println("Invalid task number.");
                        }
                    }
                    break;

                case 5:

                    System.out.println("Thank you for using To-Do List!");
                    sc.close();
                    return;

                default:

                    System.out.println("Invalid choice!");
            }
        }
    }
}