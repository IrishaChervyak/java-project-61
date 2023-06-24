package hexlet.code.games;

import hexlet.code.GameGenerator;

import java.util.Random;

public class Prime implements GameGenerator {
    private static final String GAME_DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private final Random random = new Random();
    private int number = random.nextInt(100);
    @Override
    public String getGameDescription() {
        return GAME_DESCRIPTION;
    }

    @Override
    public String getQuestion() {
        return Integer.toString(number);
    }

    @Override
    public int checkAnswer(String answer) {
        boolean isPrime = isPrimeNumber();

        String correctAnswer = isPrime ? "yes" : "no";
        if ((isPrime && answer.equals("yes")) || (!isPrime && answer.equals("no"))) {
            number = random.nextInt(100);
            return 1;
        } else {
            String errorMessage = String.format(GameGenerator.ERROR_MESSAGE, answer, correctAnswer);
            System.out.println(errorMessage);
            return 0;
        }
    }

    private boolean isPrimeNumber() {
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
