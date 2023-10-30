package hexlet.code;

import java.util.Objects;
import java.util.Scanner;

public final class Engine {
    private Engine() {
        // Приватный конструктор
    }

    public static void gameOutput(Scanner scanner, String[] questions, String[] answers) {
        int scoredPoints = 0;
        int countRounds = Constants.getNumberRounds();

        for (int i = 0; i < countRounds; i++) {
            String question = questions[i];
            String userAnswer = getUserAnswer(scanner, question);

            int gameResult = checkAnswer(userAnswer, answers[i]);

            if (gameResult == 1) {
                System.out.println("Correct!");
                scoredPoints++;
            } else {
                handleIncorrectAnswer(userAnswer, answers[i]);
                break;
            }
        }

        if (scoredPoints == Constants.getNumberRounds()) {
            System.out.printf("Congratulations, %s!\n", Cli.getUserName());
        }
    }

    private static String getUserAnswer(Scanner scanner, String question) {
        System.out.printf("Question: %s\n", question);
        System.out.print("Your answer: ");
        return scanner.nextLine();
    }

    private static int checkAnswer(String userAnswer, String correctAnswer) {
        return Objects.equals(userAnswer, correctAnswer) && !userAnswer.isEmpty() ? 1 : 0;
    }

    private static void handleIncorrectAnswer(String userAnswer, String correctAnswer) {
        System.out.printf(Constants.getErrorMessages(), userAnswer, correctAnswer);
        System.out.printf("Let's try again, %s!\n", Cli.getUserName());
    }
}
