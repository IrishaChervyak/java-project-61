package hexlet.code.games;

import hexlet.code.Constants;

public final class GreatestCommonDivisor {
    private static final int MAX_RANDOM = 101;
    private static int firstNumber = Constants.getRandomVariable().nextInt(MAX_RANDOM);
    private static int secondNumber = Constants.getRandomVariable().nextInt(MAX_RANDOM);
    private static final String[] QUESTIONS = new String[Constants.getNumberRounds()];
    private static final String[] ANSWERS = new String[Constants.getNumberRounds()];

    public static void runGame() {
        System.out.println(Constants.getGCDGameDescription());
        generateQuestionsAndAnswersForGame();
    }

    public static String[] getQuestions() {
        return QUESTIONS;
    }

    public static String[] getAnswers() {
        return ANSWERS;
    }

    private static void generateQuestionsAndAnswersForGame() {
        for (int i = 0; i < Constants.getNumberRounds(); i++) {
            QUESTIONS[i] = String.format("%d %d", firstNumber, secondNumber);
            ANSWERS[i] = Integer.toString(gcd(firstNumber, secondNumber));
            firstNumber = Constants.getRandomVariable().nextInt(MAX_RANDOM);
            secondNumber = Constants.getRandomVariable().nextInt(MAX_RANDOM);
        }
    }

    private static int gcd(int firstNum, int secondNum) {
        return (firstNum % secondNum == 0) ? Math.abs(secondNum) : gcd(secondNum, firstNum % secondNum);
    }
}
