import java.io.*;
import java.util.*;

public class ExpenseTracker {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        FileWriter fw = new FileWriter("expenses.txt", true);

        System.out.print("Enter expense: ");
        String item = sc.nextLine();

        System.out.print("Enter amount: ");
        int amt = sc.nextInt();

        fw.write(item + " - " + amt + "\n");
        fw.close();

        System.out.println("Expense saved!");
    }
}
