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
            System.out.printf("Question: %s\n", questions[i]);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            int gameResult = Objects.equals(userAnswer, answers[i]) ? 1 : 0;
            if (gameResult == 1 && !userAnswer.isEmpty()) {
                System.out.println("Correct!");
                scoredPoints += gameResult;
            } else {
                System.out.printf(Constants.getErrorMessages(), userAnswer, answers[i]);
                System.out.printf("Let's try again, %s!\n", Cli.getUserName());
                break;
            }
        }

        if (scoredPoints == Constants.getNumberRounds()) {
            System.out.printf("Congratulations, %s!\n", Cli.getUserName());
        }
    }
}
