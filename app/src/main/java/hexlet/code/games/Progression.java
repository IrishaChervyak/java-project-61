package hexlet.code.games;

import hexlet.code.Constants;

public final class Progression {
    private static final int PROGRESSION_LENGTH = 12;
    private static final int MAX_ELEMENT_VALUE_RANDOM = 31;
    private static int firstElementValue = Constants.getRandomVariable().nextInt(MAX_ELEMENT_VALUE_RANDOM);
    private static final int MIN_RANDOM_STEP = 2;
    private static final int MAX_RANDOM_STEP = 9;
    private static int progressionStep = Constants.getRandomVariable().nextInt(MIN_RANDOM_STEP, MAX_RANDOM_STEP);
    private static final int MIN_RANDOM_HIDDEN_ELEMENT_INDEX = 1;
    private static int hiddenElementIndex = Constants.getRandomVariable().nextInt(
            MIN_RANDOM_HIDDEN_ELEMENT_INDEX,
            PROGRESSION_LENGTH - 2);
    private static int hiddenElementValue = 0;

    private static final String[] QUESTIONS = new String[Constants.getNumberRounds()];
    private static final String[] ANSWERS = new String[Constants.getNumberRounds()];

    public static void runGame() {
        System.out.println(Constants.getProgressionGameDescription());
        generateQuestionsAndAnswersForGame();
    }

    public static String[] getQuestions() {
        return QUESTIONS;
    }

    public static String[] getAnswers() {
        return ANSWERS;
    }

    private static void generateQuestionsAndAnswersForGame() {
        for (int i = 0; i < Constants.getNumberRounds(); i++) {
            QUESTIONS[i] = getQuestion();
            ANSWERS[i] = Integer.toString(hiddenElementValue);
            hiddenElementIndex = Constants.getRandomVariable().nextInt(
                    MIN_RANDOM_HIDDEN_ELEMENT_INDEX,
                    PROGRESSION_LENGTH - 2);
            firstElementValue = Constants.getRandomVariable().nextInt(MAX_ELEMENT_VALUE_RANDOM);
            progressionStep = Constants.getRandomVariable().nextInt(MIN_RANDOM_STEP, MAX_RANDOM_STEP);
        }
    }

    public static String getQuestion() {
        String[] progression = generateProgression();
        hiddenElementValue = hideElementInProgression(progression);
        return String.join(" ", progression);
    }

    private static String[] generateProgression() {
        String[] progression = new String[PROGRESSION_LENGTH];
        progression[0] = Integer.toString(firstElementValue);

        int nextElement = firstElementValue + progressionStep;
        for (int i = 1; i < progression.length; i++) {
            progression[i] = Integer.toString(nextElement);
            nextElement += progressionStep;
        }

        return progression;
    }

    private static int hideElementInProgression(String[] progression) {
        int hiddenElement = Integer.parseInt(progression[hiddenElementIndex]);
        progression[hiddenElementIndex] = "..";
        return hiddenElement;
    }
}
