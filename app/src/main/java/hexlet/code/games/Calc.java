package hexlet.code.games;

import hexlet.code.Constants;
import hexlet.code.Engine;

import java.util.Scanner;

public final class Calc {
    private static final String[] OPERATIONS = {"+", "-", "*"};
    private static final int[] ANSWERS = new int[Constants.getNumberRounds()];

    public static void runGame(Scanner scanner) {
        System.out.println(Constants.getCalcGameDescription());

        String[] questions = getQuestions();
        String[] answers = getAnswers();

        Engine.gameOutput(scanner, questions, answers);
    }

    private static String[] getQuestions() {
        String[] questions = new String[Constants.getNumberRounds()];

        final int maxValue = 20;

        int firstTerm = Constants.getRandomVariable().nextInt(maxValue);
        int secondTerm = Constants.getRandomVariable().nextInt(maxValue);

        for (int i = 0; i < questions.length; i++) {
            questions[i] = String.format("%d %s %d", firstTerm, OPERATIONS[i], secondTerm);
            ANSWERS[i] = getCalcResult(OPERATIONS[i], firstTerm, secondTerm);

            firstTerm = Constants.getRandomVariable().nextInt(maxValue);
            secondTerm = Constants.getRandomVariable().nextInt(maxValue);
        }

        return questions;
    }

    private static String[] getAnswers() {
        String[] answers = new String[Constants.getNumberRounds()];

        for (int i = 0; i < answers.length; i++) {
            answers[i] = Integer.toString(ANSWERS[i]);
        }

        return answers;
    }

    private static int getCalcResult(String operation, int firstTerm, int secondTerm) {
        return switch (operation) {
            case "+" -> firstTerm + secondTerm;
            case "-" -> firstTerm - secondTerm;
            case "*" -> firstTerm * secondTerm;
            default -> throw new IllegalStateException("Unexpected value: " + operation);
        };
    }
}
