package hexlet.code.games;

import hexlet.code.GameGenerator;
import hexlet.code.TextUtil;

import java.util.Random;

public final class Even implements GameGenerator {
    private static final String GAME_DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";
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
        boolean isEven = number % 2 == 0;
        if (isEven == TextUtil.textToBoolean(answer)) {
            number = random.nextInt(MAX_RANDOM);
            return 1;
        }
        String errorMessage = String.format(GameGenerator.ERROR_MESSAGE, answer, TextUtil.booleanToText(isEven));
        System.out.println(errorMessage);
        return 0;
    }
}
