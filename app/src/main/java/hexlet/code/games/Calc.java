package hexlet.code.games;

import hexlet.code.GameGenerator;

import java.util.Random;

public final class Calc implements GameGenerator {
    private static final String GAME_DESCRIPTION = "What is the result of the expression?";
    private final Random random = new Random();
    private static final int MAX_FIRST_RANDOM_TERM = 20;
    private int firstRandomTerm = random.nextInt(MAX_FIRST_RANDOM_TERM);
    private static final int MAX_SECOND_RANDOM_TERM = 10;
    private int secondRandomTerm = random.nextInt(MAX_SECOND_RANDOM_TERM);
    private final String[] operations = {"+", "-", "*"};
    private static final int MAX_RANDOM_OPERATION = 3;
    private int randomOperation = random.nextInt(MAX_RANDOM_OPERATION);

    @Override
    public String getGameDescription() {
        return GAME_DESCRIPTION;
    }

    @Override
    public String getQuestion() {
        int firstTerm = firstRandomTerm;
        int secondTerm = secondRandomTerm;
        int operation = randomOperation;
        return String.format("%d %s %d", firstTerm, operations[operation], secondTerm);
    }

    @Override
    public int checkAnswer(String answer) {
        int firstTerm = firstRandomTerm;
        int secondTerm = secondRandomTerm;
        int operation = randomOperation;

        int result = switch (operation) {
            case 0 -> firstTerm + secondTerm;
            case 1 -> firstTerm - secondTerm;
            case 2 -> firstTerm * secondTerm;
            default -> 0;
        };

        int answerNumber = 0;
        try {
            answerNumber = Integer.parseInt(answer);
        } catch (NumberFormatException e) {
            System.out.println("Error converting a string to a number: " + e.getMessage());
        }

        boolean isCorrect = result == answerNumber;
        if (isCorrect) {
            firstRandomTerm = random.nextInt(20);
            secondRandomTerm = random.nextInt(10);
            randomOperation = random.nextInt(3);
            return 1;
        } else {
            String errorMessage = String.format(GameGenerator.ERROR_MESSAGE, answer, result);
            System.out.println(errorMessage);
            return 0;
        }
    }
}
