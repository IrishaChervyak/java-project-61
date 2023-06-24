package hexlet.code;

public interface GameGenerator {
    String ERROR_MESSAGE = "'%s' is wrong answer ;(. Correct answer was '%s'";
    String getGameDescription();
    String getQuestion();
    int checkAnswer(String answer);
}
