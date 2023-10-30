package hexlet.code.games;

import hexlet.code.Constants;
import hexlet.code.Engine;

import java.util.Scanner;

public final class Progression {
    private static final int ARRAY_LENGTH = 12;
    public static final int[] ANSWERS = new int[Constants.getNumberRounds()];

    public static void runGame(Scanner scanner) {
        System.out.println(Constants.getProgressionGameDescription());

        String[] questions = getQuestions();
        String[] answers = getAnswers();

        Engine.gameOutput(scanner, questions, answers);
    }

    private static String[] getQuestions() {
        String[] questions = new String[Constants.getNumberRounds()];

        final int maxElementValue = 31;
        final int minStepValue = 2;
        final int maxStepValue = 9;
        final int minHiddenElementIndex = 1;

        int firstElementValue = Constants.getRandomVariable().nextInt(maxElementValue);
        int progressionStep = Constants.getRandomVariable().nextInt(minStepValue, maxStepValue);
        int hiddenElementIndex = Constants.getRandomVariable().nextInt(minHiddenElementIndex, ARRAY_LENGTH - 2);

        for (int i = 0; i < questions.length; i++) {
            questions[i] = getQuestion(firstElementValue, progressionStep, hiddenElementIndex, i);

            firstElementValue = Constants.getRandomVariable().nextInt(maxElementValue);
            progressionStep = Constants.getRandomVariable().nextInt(minStepValue, maxStepValue);
            hiddenElementIndex = Constants.getRandomVariable().nextInt(minHiddenElementIndex, ARRAY_LENGTH - 2);
        }

        return questions;
    }

    private static String[] getAnswers() {
        String[] answers = new String[Constants.getNumberRounds()];

        for (int i = 0; i < answers.length; i++) {
            answers[i] = Integer.toString(ANSWERS[i]);
        }

        return answers;
    }

    public static String getQuestion(int firstElementValue, int progressionStep, int hiddenElementIndex, int i) {
        String[] progression = generateProgression(firstElementValue, progressionStep);
        ANSWERS[i] = Integer.parseInt(progression[hiddenElementIndex]);

        return String.join(" ", hideElementInProgression(progression, hiddenElementIndex));
    }

    private static String[] generateProgression(int firstElementValue, int progressionStep) {
        String[] progression = new String[ARRAY_LENGTH];

        progression[0] = Integer.toString(firstElementValue);
        int nextElement = firstElementValue + progressionStep;
        for (int i = 1; i < progression.length; i++) {
            progression[i] = Integer.toString(nextElement);
            nextElement += progressionStep;
        }

        return progression;
    }

    private static String[] hideElementInProgression(String[] progression, int hiddenElementIndex) {
        progression[hiddenElementIndex] = "..";
        return progression;
    }
}
