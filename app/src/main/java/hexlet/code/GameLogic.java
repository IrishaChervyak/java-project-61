package hexlet.code;

public class GameLogic {
    public static int processAnswer(boolean condition, String answer, String correctAnswer) {
        if ((condition && answer.equals("yes")) || (!condition && answer.equals("no"))) {
            return 1;
        } else {
            String errorMessage = String.format(GameGenerator.ERROR_MESSAGE, answer, correctAnswer);
            System.out.println(errorMessage);
            return 0;
        }
    }
}
