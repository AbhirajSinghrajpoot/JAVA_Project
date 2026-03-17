import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
    private static class Student {
        int id;
        String name;
        double gpa;
        
        Student(int id, String name, double gpa) {
            this.id = id;
            this.name = name;
            this.gpa = gpa;
        }
        
        @Override
        public String toString() {
            return "ID: " + id + ", Name: " + name + ", GPA: " + gpa;
        }
    }
    
    private ArrayList<Student> students;
    private Scanner scanner;
    
    public StudentManagement() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    
    public void addStudent(int id, String name, double gpa) {
        students.add(new Student(id, name, gpa));
        System.out.println("Student added successfully!");
    }
    
    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }
        System.out.println("\n=== All Students ===");
        for (Student student : students) {
            System.out.println(student);
        }
    }
    
    public void searchStudent(int id) {
        for (Student student : students) {
            if (student.id == id) {
                System.out.println("Found: " + student);
                return;
            }
        }
        System.out.println("Student not found!");
    }
    
    public void deleteStudent(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).id == id) {
                students.remove(i);
                System.out.println("Student deleted!");
                return;
            }
        }
        System.out.println("Student not found!");
    }
    
    public void updateGPA(int id, double newGPA) {
        for (Student student : students) {
            if (student.id == id) {
                student.gpa = newGPA;
                System.out.println("GPA updated!");
                return;
            }
        }
        System.out.println("Student not found!");
    }
    
    public void run() {
        int choice;
        while (true) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Update GPA");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter GPA: ");
                    double gpa = scanner.nextDouble();
                    addStudent(id, name, gpa);
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    System.out.print("Enter ID to search: ");
                    searchStudent(scanner.nextInt());
                    break;
                case 4:
                    System.out.print("Enter ID to delete: ");
                    deleteStudent(scanner.nextInt());
                    break;
                case 5:
                    System.out.print("Enter ID: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter new GPA: ");
                    double newGPA = scanner.nextDouble();
                    updateGPA(updateId, newGPA);
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
        StudentManagement system = new StudentManagement();
        system.run();
    }
}
