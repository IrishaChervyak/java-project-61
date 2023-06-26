package hexlet.code.games;

import hexlet.code.GameGenerator;
import java.util.Random;

public final class Progression implements GameGenerator {
    private static final String GAME_DESCRIPTION = "What number is missing in the progression?";
    private final Random random = new Random();
    private static final int MIN_RANDOM_LENGTH = 7;
    private static final int MAX_RANDOM_LENGTH = 11;
    private int progressionLength = random.nextInt(MIN_RANDOM_LENGTH, MAX_RANDOM_LENGTH);
    private static final int MAX_ELEMENT_VALUE_RANDOM = 21;
    private int firstElementValue = random.nextInt(MAX_ELEMENT_VALUE_RANDOM);
    private static final int MIN_RANDOM_STEP = 2;
    private static final int MAX_RANDOM_STEP = 7;
    private int progressionStep = random.nextInt(MIN_RANDOM_STEP, MAX_RANDOM_STEP);
    private static final int MIN_RANDOM_HIDDEN_ELEMENT_INDEX = 1;
    private int hiddenElementIndex = random.nextInt(MIN_RANDOM_HIDDEN_ELEMENT_INDEX, progressionLength - 2);
    private int hiddenElementValue = 0;

    @Override
    public String getGameDescription() {
        return GAME_DESCRIPTION;
    }

    @Override
    public String getQuestion() {
        String[] progression = generateProgression();
        hiddenElementValue = hideElementInProgression(progression);
        return String.join(" ", progression);
    }

    @Override
    public int checkAnswer(String answer) {
        boolean isCorrect = answer.equals(Integer.toString(hiddenElementValue));
        if (isCorrect) {
            progressionLength = random.nextInt(MIN_RANDOM_LENGTH, MAX_RANDOM_LENGTH);
            firstElementValue = random.nextInt(MAX_ELEMENT_VALUE_RANDOM);
            progressionStep = random.nextInt(MIN_RANDOM_STEP, MAX_RANDOM_STEP);
            hiddenElementIndex = random.nextInt(MIN_RANDOM_HIDDEN_ELEMENT_INDEX, progressionLength - 2);
            return 1;
        } else {
            String errorMessage = String.format(GameGenerator.ERROR_MESSAGE, answer, hiddenElementValue);
            System.out.println(errorMessage);
            return 0;
        }
    }

    private String[] generateProgression() {
        String[] progression = new String[progressionLength];
        progression[0] = Integer.toString(firstElementValue);

        int nextElement = firstElementValue + progressionStep;
        for (int i = 1; i < progression.length; i++) {
            progression[i] = Integer.toString(nextElement);
            nextElement += progressionStep;
        }

        return progression;
    }

    private int hideElementInProgression(String[] progression) {
        int hiddenElement = Integer.parseInt(progression[hiddenElementIndex]);
        progression[hiddenElementIndex] = "..";
        return hiddenElement;
    }
}
