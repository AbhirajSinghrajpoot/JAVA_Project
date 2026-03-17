import java.io.*;
import java.util.Scanner;

public class FileManager {
    private Scanner scanner;
    
    public FileManager() {
        scanner = new Scanner(System.in);
    }
    
    public void createFile(String fileName, String content) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(content);
            writer.close();
            System.out.println("File created: " + fileName);
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }
    
    public void readFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            System.out.println("\n=== File Content ===");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    
    public void appendToFile(String fileName, String content) {
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write("\n" + content);
            writer.close();
            System.out.println("Content appended to file!");
        } catch (IOException e) {
            System.out.println("Error appending to file: " + e.getMessage());
        }
    }
    
    public void deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.delete()) {
            System.out.println("File deleted: " + fileName);
        } else {
            System.out.println("Error deleting file!");
        }
    }
    
    public void listFiles(String directory) {
        File dir = new File(directory);
        File[] files = dir.listFiles();
        if (files == null) {
            System.out.println("Directory not found!");
            return;
        }
        System.out.println("\n=== Files in " + directory + " ===");
        for (File file : files) {
            System.out.println(file.getName());
        }
    }
    
    public void run() {
        int choice;
        while (true) {
            System.out.println("\n=== File Manager ===");
            System.out.println("1. Create File");
            System.out.println("2. Read File");
            System.out.println("3. Append to File");
            System.out.println("4. Delete File");
            System.out.println("5. List Files");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter file name: ");
                    String fileName = scanner.nextLine();
                    System.out.print("Enter content: ");
                    String content = scanner.nextLine();
                    createFile(fileName, content);
                    break;
                case 2:
                    System.out.print("Enter file name: ");
                    readFile(scanner.nextLine());
                    break;
                case 3:
                    System.out.print("Enter file name: ");
                    String appendFileName = scanner.nextLine();
                    System.out.print("Enter content to append: ");
                    String appendContent = scanner.nextLine();
                    appendToFile(appendFileName, appendContent);
                    break;
                case 4:
                    System.out.print("Enter file name: ");
                    deleteFile(scanner.nextLine());
                    break;
                case 5:
                    System.out.print("Enter directory path: ");
                    listFiles(scanner.nextLine());
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    
    public static void main(String[] args) {
        FileManager manager = new FileManager();
        manager.run();
    }
}
