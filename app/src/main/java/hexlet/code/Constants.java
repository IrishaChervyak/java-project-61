package hexlet.code;

import java.util.Random;

public final class Constants {
    private Constants() {
        // Приватный конструктор
    }

    private static final Random RANDOM = new Random();
    private static final String EVEN_DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final String CALC_DESCRIPTION = "What is the result of the expression?";
    private static final String GCD_DESCRIPTION = "Find the greatest common divisor of given numbers.";
    private static final String PROGRESSION_DESCRIPTION = "What number is missing in the progression?";
    private static final String PRIME_DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int NUMBER_ROUNDS = 3;
    private static final String ERROR_MESSAGE = "'%s' is wrong answer ;(. Correct answer was '%s'.\n";

    public static Random getRandomVariable() {
        return RANDOM;
    }
    public static String getEvenGameDescription() {
        return EVEN_DESCRIPTION;
    }

    public static String getCalcGameDescription() {
        return CALC_DESCRIPTION;
    }

    public static String getGCDGameDescription() {
        return GCD_DESCRIPTION;
    }

    public static String getProgressionGameDescription() {
        return PROGRESSION_DESCRIPTION;
    }

    public static String getPrimeGameDescription() {
        return PRIME_DESCRIPTION;
    }

    public static int getNumberRounds() {
        return NUMBER_ROUNDS;
    }

    public static String getErrorMessages() {
        return ERROR_MESSAGE;
    }
}
