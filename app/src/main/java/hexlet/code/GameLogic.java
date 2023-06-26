package hexlet.code;

public class GameLogic {
    public static boolean processAnswer(boolean condition, String answer, boolean correctAnswer) {
        String textAnswer = correctAnswer ? "yes" : "no";
        if ((condition && answer.equals("yes")) || (!condition && answer.equals("no"))) {
            return true;
        } else {
            String errorMessage = String.format(GameGenerator.ERROR_MESSAGE, answer, textAnswer);
            System.out.println(errorMessage);
            return false;
        }
    }
}
