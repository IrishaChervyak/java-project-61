package hexlet.code;

import java.util.Scanner;
import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GreatestCommonDivisor;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        runGames(scanner);
        scanner.close();
    }

    private static void runGames(Scanner scanner) {
        displayGameMenu();
        String selectedGameNumber = scanner.nextLine();

        System.out.println();
        switch (selectedGameNumber) {
            case "0" -> System.out.println("Good Bye!");
            case "1" -> Cli.welcomeUser(scanner);
            case "2", "3", "4", "5", "6" -> {
                Cli.welcomeUser(scanner);
                GameGenerator game = createGame(selectedGameNumber);
                assert game != null;
                Engine.gameOutput(scanner, game);
            }
            default -> System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void displayGameMenu() {
        final String[] games = {
            "1 - Greet",
            "2 - Even",
            "3 - Calc",
            "4 - GCD",
            "5 - Progression",
            "6 - Prime",
            "0 - Exit"
        };
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
            case "4" -> {
                return new GreatestCommonDivisor();
            }
            case "5" -> {
                return new Progression();
            }
            case "6" -> {
                return new Prime();
            }
            default -> {
                System.out.println("Invalid choice. Please try again.");
                return null;
            }
        }
    }
}
