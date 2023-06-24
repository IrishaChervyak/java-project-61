package hexlet.code;

import java.util.Scanner;

public class App {
    private static final int TARGET_SCORE = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        displayGameMenu();
        String selectedGameNumber = scanner.nextLine();

        System.out.println();
        switch (selectedGameNumber) {
            case "0" -> System.out.println("Good Bye!");
            case "1" -> Cli.welcomeUser(scanner);
            case "2", "3" -> {
                Cli.welcomeUser(scanner);
                GameGenerator game = createGame(selectedGameNumber);
                assert game != null;
                gameOutput(scanner, game);
            }
            default -> System.out.println("Invalid choice. Please try again.");
        }

        scanner.close();
    }

    private static void displayGameMenu() {
        final String[] games = {"1 - Greet", "2 - Even", "3 - Calc", "0 - Exit"};
        System.out.println("Please enter the game number and press Enter.");
        for (String game : games) {
            System.out.println(game);
        }
        System.out.print("Your choice: ");
    }

    private static GameGenerator createGame(String choice) {
        switch (choice) {
            case "2" -> {
                return new Even();
            }
            case "3" -> {
                return new Calc();
            }
            default -> {
                System.out.println("Invalid choice. Please try again.");
                return null;
            }
        }
    }

    public static void gameOutput(Scanner scanner, GameGenerator game) {
        System.out.println(game.getGameDescription());

        int scoredPoints = 0;
        while (scoredPoints < TARGET_SCORE) {
            System.out.printf("Question: %s\n", game.getQuestion());
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            int gameResult = game.checkAnswer(userAnswer);
            if (gameResult == 1) {
                System.out.println("Correct!");
                scoredPoints += gameResult;
            } else {
                System.out.printf("Let's try again, %s!\n", Cli.userName);
                break;
            }
        }

        if (scoredPoints == TARGET_SCORE) {
            System.out.printf("Congratulations, %s!\n", Cli.userName);
        }
    }
}
