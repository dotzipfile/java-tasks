import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Survey {

    private static final String[] QUESTIONS = {
            "Q1, Are you over the age of 18? (Y/N)",
            "Q2, Do you have a higher level education? (Y/N)",
            "Q3, Do you have a full driving licence? (Y/N)",
            "Q4, Were you born in Ireland? (Y/N)",
            "Q5, Are you currently employed? (Y/N)",
            "Q6, Are you currently in a relationship? (Y/N)",
            "Q7, Do you own a car? (Y/N)",
            "Q8, Are you happy with your current internet service provider? (Y/N)",
            "Q9, Do you still live with your parents? (Y/N)",
            "Q10, Do you have any pets? (Y/N)"
    };
    private static final List<String> VALID_YES = Arrays.asList("yes", "y");
    private static final List<String> VALID_NO = Arrays.asList("no", "n");
    private final String[] answers = new String[QUESTIONS.length];
    private final Scanner scanner = new Scanner(System.in);

    private int totalYes = 0;
    private int totalNo = 0;

    public static void main(String[] args) {
        Survey survey = new Survey();
        survey.run();
    }

    public void run() {
        for (int i = 0; i < QUESTIONS.length; i++) {
            answers[i] = askQuestion(QUESTIONS[i]);
        }

        for (int i = 0; i < answers.length; i++) {
            System.out.println("Q" + (i + 1) + " answer: " + answers[i]);
        }

        System.out.println("Total yes: " + totalYes);
        System.out.println("Total no: " + totalNo);
    }

    public String askQuestion(String question) {
        while (true) {
            System.out.println(question);
            String answer = scanner.nextLine();
            if (validateAnswer(answer)) {
                return answer;
            } else {
                System.out.println(answer + " is not a valid answer...");
            }
        }
    }

    public boolean validateAnswer(String answer) {
        if (VALID_YES.contains(answer.toLowerCase())) {
            totalYes++;
            return true;
        } else if (VALID_NO.contains(answer.toLowerCase())) {
            totalNo++;
            return true;
        } else {
            return false;
        }
    }
}
