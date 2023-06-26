package hexlet.code.games;

import hexlet.code.GameGenerator;

import java.util.Random;

public final class GreatestCommonDivisor implements GameGenerator {
    private static final String GAME_DESCRIPTION = "Find the greatest common divisor of given numbers.";
    private final Random random = new Random();
    private static final int MAX_FIRST_RANDOM = 101;
    private int firstRandomNumber = random.nextInt(MAX_FIRST_RANDOM);
    private static final int MAX_SECOND_RANDOM = 101;
    private int secondRandomNumber = random.nextInt(MAX_SECOND_RANDOM);

    @Override
    public String getGameDescription() {
        return GAME_DESCRIPTION;
    }

    @Override
    public String getQuestion() {
        return String.format("%d %d", firstRandomNumber, secondRandomNumber);
    }

    @Override
    public int checkAnswer(String answer) {
        int answerNumber = 0;
        try {
            answerNumber = Integer.parseInt(answer);
        } catch (NumberFormatException e) {
            System.out.println("Error converting a string to a number: " + e.getMessage());
        }

        int result = gcd(firstRandomNumber, secondRandomNumber);
        boolean isCorrect = result == answerNumber;
        if (isCorrect) {
            firstRandomNumber = random.nextInt(MAX_FIRST_RANDOM);
            secondRandomNumber = random.nextInt(MAX_SECOND_RANDOM);
            return 1;
        } else {
            String errorMessage = String.format(GameGenerator.ERROR_MESSAGE, answer, result);
            System.out.println(errorMessage);
            return 0;
        }
    }

    private static int gcd(int firstNum, int secondNum) {
        return (firstNum % secondNum == 0) ? Math.abs(secondNum) : gcd(secondNum, firstNum % secondNum);
    }
}
