package hexlet.code.games;

import java.util.Random;

public final class Even {

    private static final Random RANDOM = new Random();
    private static final int MAX_RANDOM = 100;
    private static int number = RANDOM.nextInt(MAX_RANDOM);
    private static final String GAME_DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";
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

            boolean isEven = number % 2 == 0;
            if (isEven) {
                ANSWERS[i] = "yes";
            } else {
                ANSWERS[i] = "no";
            }

            number = RANDOM.nextInt(MAX_RANDOM);
        }
    }
}
