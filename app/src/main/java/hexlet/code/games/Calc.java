package hexlet.code.games;

import java.util.Random;

public final class Calc {
    private static final Random RANDOM = new Random();
    private static final int MAX_RANDOM = 20;
    private static final String[] OPERATIONS = {"+", "-", "*"};
    private static int firstTerm = RANDOM.nextInt(MAX_RANDOM);
    private static int secondTerm = RANDOM.nextInt(MAX_RANDOM);
    private static final String GAME_DESCRIPTION = "What is the result of the expression?";
    private static final String[] QUESTIONS = new String[3];
    private static final String[] ANSWERS = new String[3];

    public static void runGame() {
        System.out.println(GAME_DESCRIPTION);
        generateQuestionsAndAnswersForGame();
    }

    public static String[] getQuestion() {
        return QUESTIONS;
    }

    public static String[] getAnswers() {
        return ANSWERS;
    }

    private static void generateQuestionsAndAnswersForGame() {
        int i = 0;

        for (String operation : OPERATIONS) {
            QUESTIONS[i] = String.format("%d %s %d", firstTerm, operation, secondTerm);

            ANSWERS[i] = switch (operation) {
                case "+" -> Integer.toString(firstTerm + secondTerm);
                case "-" -> Integer.toString(firstTerm - secondTerm);
                case "*" -> Integer.toString(firstTerm * secondTerm);
                default -> throw new IllegalStateException("Unexpected value: " + operation);
            };

            firstTerm = RANDOM.nextInt(MAX_RANDOM);
            secondTerm = RANDOM.nextInt(MAX_RANDOM);
            i++;
        }
    }
}
