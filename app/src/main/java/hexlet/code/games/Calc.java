package hexlet.code;

import java.util.Random;

public class Calc implements GameGenerator {
    private static final String GAME_DESCRIPTION = "What is the result of the expression?";
    private final Random random = new Random();
    private int firstRandomTerm = random.nextInt(20);
    private int secondRandomTerm = random.nextInt(10);
    private final String[] operations = {"+", "-", "*"};
    private int randomOperation = random.nextInt(3);

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
