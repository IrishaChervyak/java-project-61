package hexlet.code.games;

import java.util.Random;

public final class GreatestCommonDivisor {
    private static final Random RANDOM = new Random();
    private static final int MAX_RANDOM = 101;
    private static int firstNumber = RANDOM.nextInt(MAX_RANDOM);
    private static int secondNumber = RANDOM.nextInt(MAX_RANDOM);
    private static final String GAME_DESCRIPTION = "Find the greatest common divisor of given numbers.";
    private static final String[] QUESTIONS = new String[3];
    private static final String[] ANSWERS = new String[3];

    public static void runGame() {
        System.out.println(GAME_DESCRIPTION);
        generateQuestionsAndAnswersForGame();
    }

    public static String[] getQuestions() {
        return QUESTIONS;
    }

    public static String[] getAnswers() {
        return ANSWERS;
    }

    private static void generateQuestionsAndAnswersForGame() {
        for (int i = 0; i < 3; i++) {
            QUESTIONS[i] = String.format("%d %d", firstNumber, secondNumber);
            ANSWERS[i] = Integer.toString(gcd(firstNumber, secondNumber));
            firstNumber = RANDOM.nextInt(MAX_RANDOM);
            secondNumber = RANDOM.nextInt(MAX_RANDOM);
        }
    }

    private static int gcd(int firstNum, int secondNum) {
        return (firstNum % secondNum == 0) ? Math.abs(secondNum) : gcd(secondNum, firstNum % secondNum);
    }
}
