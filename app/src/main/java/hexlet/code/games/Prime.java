package hexlet.code.games;

import java.util.Random;

public final class Prime {
    private static final Random RANDOM = new Random();
    private static final int MAX_RANDOM = 100;
    private static int number = RANDOM.nextInt(MAX_RANDOM);
    private static final String GAME_DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
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
            QUESTIONS[i] = String.format("%d", number);
            if (isPrimeNumber()) {
                ANSWERS[i] = "yes";
            } else {
                ANSWERS[i] = "no";
            }
            number = RANDOM.nextInt(MAX_RANDOM);
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
