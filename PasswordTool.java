import java.util.Random;
import java.util.Scanner;

public class PasswordTool {

    static String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter password length: ");
        int len = sc.nextInt();

        String password = generatePassword(len);
        System.out.println("Generated Password: " + password);

        checkStrength(password);
    }

    static String generatePassword(int len) {
        Random rand = new Random();
        String pass = "";

        for (int i = 0; i < len; i++) {
            pass += chars.charAt(rand.nextInt(chars.length()));
        }
        return pass;
    }

    static void checkStrength(String pass) {
        int score = 0;

        if (pass.length() >= 8) score++;
        if (pass.matches(".*[A-Z].*")) score++;
        if (pass.matches(".*[a-z].*")) score++;
        if (pass.matches(".*[0-9].*")) score++;
        if (pass.matches(".*[!@#$%].*")) score++;

        if (score >= 4)
            System.out.println("Strong Password 💪");
        else
            System.out.println("Weak Password ⚠");
    }
}
