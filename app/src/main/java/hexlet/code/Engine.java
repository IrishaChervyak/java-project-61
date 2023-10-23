package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GreatestCommonDivisor;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Objects;
import java.util.Scanner;

public final class Engine {
    private Engine() {
        // Приватный конструктор
    }

    private static final int TARGET_SCORE = 3;
    private static final String ERROR_MESSAGE = "'%s' is wrong answer ;(. Correct answer was '%s'.\n";

    public static void gameOutput(Scanner scanner, String selectedGame) {
        String[] questions = new String[]{};
        String[] answers = new String[]{};

        switch (selectedGame) {
            case "2" -> {
                questions = Even.getQuestions();
                answers = Even.getAnswers();
            }
            case "3" -> {
                questions = Calc.getQuestion();
                answers = Calc.getAnswers();
            }
            case "4" -> {
                questions = GreatestCommonDivisor.getQuestions();
                answers = GreatestCommonDivisor.getAnswers();
            }
            case "5" -> {
                questions = Progression.getQuestions();
                answers = Progression.getAnswers();
            }
            case "6" -> {
                questions = Prime.getQuestions();
                answers = Prime.getAnswers();
            }
            default -> System.out.println("Invalid choice. Please try again.");
        }

        int scoredPoints = 0;
        for (int i = 0; i < TARGET_SCORE; i++) {
            System.out.printf("Question: %s\n", questions[i]);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            int gameResult = Objects.equals(userAnswer, answers[i]) ? 1 : 0;
            if (gameResult == 1 && !userAnswer.isEmpty()) {
                System.out.println("Correct!");
                scoredPoints += gameResult;
            } else {
                System.out.printf(ERROR_MESSAGE, userAnswer, answers[i]);
                System.out.printf("Let's try again, %s!\n", Cli.getUserName());
                break;
            }
        }

        if (scoredPoints == TARGET_SCORE) {
            System.out.printf("Congratulations, %s!\n", Cli.getUserName());
        }
    }
}
