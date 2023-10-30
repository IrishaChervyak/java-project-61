package hexlet.code.games;

import hexlet.code.Constants;
import hexlet.code.Engine;

import java.util.Scanner;

public final class Even {
    private static final int[] QUESTIONS = new int[Constants.getNumberRounds()];

    public static void runGame(Scanner scanner) {
        System.out.println(Constants.getEvenGameDescription());

        String[] questions = getQuestions();
        String[] answers = getAnswers();

        Engine.gameOutput(scanner, questions, answers);
    }

    private static String[] getQuestions() {
        String[] result = new String[Constants.getNumberRounds()];

        final int maxValue = 100;

        int number = Constants.getRandomVariable().nextInt(maxValue);
        for (int i = 0; i < Constants.getNumberRounds(); i++) {
            QUESTIONS[i] = number;
            result[i] = String.format("%d", number);

            number = Constants.getRandomVariable().nextInt(maxValue);
        }

        return result;
    }

    private static String[] getAnswers() {
        String[] answers = new String[Constants.getNumberRounds()];

        for (int i = 0; i < QUESTIONS.length; i++) {
            if (isEven(QUESTIONS[i])) {
                answers[i] = "yes";
            } else {
                answers[i] = "no";
            }
        }

        return answers;
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
