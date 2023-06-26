package hexlet.code.games;

import hexlet.code.GameGenerator;
import hexlet.code.GameLogic;

import java.util.Random;

public final class Even implements GameGenerator {
    private static final String GAME_DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private final Random random = new Random();
    private static final int MAX_RANDOM = 100;
    private int number = nextNumber();

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
        boolean isEven = isEvenNumber();
        String correctAnswer = isEven ? "yes" : "no";
        if (GameLogic.processAnswer(isEven, answer, correctAnswer)) {
            number = nextNumber();
        }
        return 1;
    }

    private int nextNumber() {
        return random.nextInt(MAX_RANDOM);
    }

    private boolean isEvenNumber() {
        return number % 2 == 0;
    }
}
