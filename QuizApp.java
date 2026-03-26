import java.util.*;

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] questions = {
            "Java is platform independent?",
            "2 + 2 = ?"
        };

        String[][] options = {
            {"1. Yes", "2. No"},
            {"1. 3", "2. 4"}
        };

        int[] answers = {1, 2};
        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            for (String opt : options[i]) {
                System.out.println(opt);
            }

            int ans = sc.nextInt();
            if (ans == answers[i]) score++;
        }

        System.out.println("Score: " + score);
    }
}
