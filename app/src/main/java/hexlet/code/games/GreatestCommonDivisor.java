package hexlet.code.games;

import hexlet.code.Constants;
import hexlet.code.Engine;

import java.util.Scanner;

public final class GreatestCommonDivisor {
    public static final int[] ANSWERS = new int[Constants.getNumberRounds()];

    public static void runGame(Scanner scanner) {
        System.out.println(Constants.getGCDGameDescription());

        String[] questions = getQuestions();
        String[] answers = getAnswers();

        Engine.gameOutput(scanner, questions, answers);
    }

    private static String[] getQuestions() {
        String[] questions = new String[Constants.getNumberRounds()];

        final int maxValue = 101;

        int firstNumber = Constants.getRandomVariable().nextInt(maxValue);
        int secondNumber = Constants.getRandomVariable().nextInt(maxValue);
        for (int i = 0; i < questions.length; i++) {
            questions[i] = String.format("%d %d", firstNumber, secondNumber);
            ANSWERS[i] = gcd(firstNumber, secondNumber);

            firstNumber = Constants.getRandomVariable().nextInt(maxValue);
            secondNumber = Constants.getRandomVariable().nextInt(maxValue);
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

    private static int gcd(int firstNum, int secondNum) {
        return (firstNum % secondNum == 0) ? Math.abs(secondNum) : gcd(secondNum, firstNum % secondNum);
    }
}
