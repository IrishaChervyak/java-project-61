package hexlet.code.games;

import hexlet.code.Constants;

public final class Even {
    private static final int MAX_RANDOM = 100;
    private static int number = Constants.getRandomVariable().nextInt(MAX_RANDOM);
    private static final String[] QUESTIONS = new String[Constants.getNumberRounds()];
    private static final String[] ANSWERS = new String[Constants.getNumberRounds()];

    public static void runGame() {
        System.out.println(Constants.getEvenGameDescription());
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

            boolean isEven = number % 2 == 0;
            if (isEven) {
                ANSWERS[i] = "yes";
            } else {
                ANSWERS[i] = "no";
            }

            number = Constants.getRandomVariable().nextInt(MAX_RANDOM);
        }
    }
}
