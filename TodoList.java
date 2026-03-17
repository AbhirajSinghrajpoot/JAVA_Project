import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {
    private ArrayList<String> tasks;
    private Scanner scanner;
    
    public TodoList() {
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    
    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added: " + task);
    }
    
    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            String removed = tasks.remove(index);
            System.out.println("Task removed: " + removed);
        } else {
            System.out.println("Invalid task number!");
        }
    }
    
    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks!");
            return;
        }
        System.out.println("\n=== Todo List ===");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
        System.out.println();
    }
    
    public void run() {
        int choice;
        while (true) {
            System.out.println("\n1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter task: ");
                    String task = scanner.nextLine();
                    addTask(task);
                    break;
                case 2:
                    displayTasks();
                    System.out.print("Enter task number to remove: ");
                    int taskNum = scanner.nextInt();
                    removeTask(taskNum - 1);
                    break;
                case 3:
                    displayTasks();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    
    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        todoList.run();
    }
}
