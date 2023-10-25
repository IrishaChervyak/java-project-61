package hexlet.code.games;

import hexlet.code.Constants;

public final class Calc {
    private static final int MAX_RANDOM = 20;
    private static final String[] OPERATIONS = {"+", "-", "*"};
    private static int firstTerm = Constants.getRandomVariable().nextInt(MAX_RANDOM);
    private static int secondTerm = Constants.getRandomVariable().nextInt(MAX_RANDOM);
    private static final String[] QUESTIONS = new String[Constants.getNumberRounds()];
    private static final String[] ANSWERS = new String[Constants.getNumberRounds()];

    public static void runGame() {
        System.out.println(Constants.getCalcGameDescription());
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

            firstTerm = Constants.getRandomVariable().nextInt(MAX_RANDOM);
            secondTerm = Constants.getRandomVariable().nextInt(MAX_RANDOM);
            i++;
        }
    }
}
