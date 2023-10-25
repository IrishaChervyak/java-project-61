package hexlet.code.games;

import hexlet.code.Constants;

public final class Prime {
    private static final int MAX_RANDOM = 100;
    private static int number = Constants.getRandomVariable().nextInt(MAX_RANDOM);
    private static final String[] QUESTIONS = new String[Constants.getNumberRounds()];
    private static final String[] ANSWERS = new String[Constants.getNumberRounds()];

    public static void runGame() {
        System.out.println(Constants.getPrimeGameDescription());
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
            QUESTIONS[i] = String.format("%d", number);
            if (isPrimeNumber()) {
                ANSWERS[i] = "yes";
            } else {
                ANSWERS[i] = "no";
            }
            number = Constants.getRandomVariable().nextInt(MAX_RANDOM);
        }
    }

    private static boolean isPrimeNumber() {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
