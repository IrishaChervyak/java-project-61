package hexlet.code;

import java.util.Scanner;

public final class Engine {
    private Engine() {
        // Приватный конструктор
    }

    private static final int TARGET_SCORE = 3;

    public static void gameOutput(Scanner scanner, GameGenerator game) {
        System.out.println(game.getGameDescription());

        int scoredPoints = 0;
        while (scoredPoints < TARGET_SCORE) {
            System.out.printf("Question: %s\n", game.getQuestion());
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            int gameResult = game.checkAnswer(userAnswer);
            if (gameResult == 1) {
                System.out.println("Correct!");
                scoredPoints += gameResult;
            } else {
                System.out.printf("Let's try again, %s!\n", Cli.userName);
                break;
            }
        }

        if (scoredPoints == TARGET_SCORE) {
            System.out.printf("Congratulations, %s!\n", Cli.userName);
        }
    }
}
