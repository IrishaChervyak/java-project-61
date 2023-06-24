package hexlet.code.games;

import hexlet.code.GameGenerator;
import java.util.Random;

public class Progression implements GameGenerator {
    private static final String GAME_DESCRIPTION = "What number is missing in the progression?";
    private final Random random = new Random();
    private int progressionLength = random.nextInt(7, 11);
    private int firstElementValue = random.nextInt(21);
    private int progressionStep = random.nextInt(2, 7);
    private int hiddenElementIndex = random.nextInt(1, progressionLength - 2);
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
            progressionLength = random.nextInt(7, 11);
            firstElementValue = random.nextInt(21);
            progressionStep = random.nextInt(2, 7);
            hiddenElementIndex = random.nextInt(1, progressionLength - 2);
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
