package hexlet.code.games;

import hexlet.code.GameGenerator;
import hexlet.code.TextUtil;

import java.util.Random;

public final class Prime implements GameGenerator {
    private static final String GAME_DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private final Random random = new Random();
    private static final int MAX_RANDOM = 100;
    private int number = random.nextInt(MAX_RANDOM);

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
        if (isPrime == TextUtil.textToBoolean(answer)) {
            number = random.nextInt(MAX_RANDOM);
            return 1;
        }
        String errorMessage = String.format(GameGenerator.ERROR_MESSAGE, answer, TextUtil.booleanToText(isPrime));
        System.out.println(errorMessage);
        return 0;
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
