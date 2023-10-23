package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GreatestCommonDivisor;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Scanner;

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
            case "2" -> {
                Cli.welcomeUser(scanner);
                Even.runGame();
                Engine.gameOutput(scanner, selectedGameNumber);
            }
            case "3" -> {
                Cli.welcomeUser(scanner);
                Calc.runGame();
                Engine.gameOutput(scanner, selectedGameNumber);
            }
            case "4" -> {
                Cli.welcomeUser(scanner);
                GreatestCommonDivisor.runGame();
                Engine.gameOutput(scanner, selectedGameNumber);
            }
            case "5" -> {
                Cli.welcomeUser(scanner);
                Progression.runGame();
                Engine.gameOutput(scanner, selectedGameNumber);
            }
            case "6" -> {
                Cli.welcomeUser(scanner);
                Prime.runGame();
                Engine.gameOutput(scanner, selectedGameNumber);
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
}
