package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        final String[] games = {"1 - Greet", "2 - Even", "0 - Exit"};
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        for (String game : games) {
            System.out.println(game);
        }

        System.out.print("Your choice: ");
        String selectedGameNumber = scanner.nextLine();

        System.out.println();
        switch (selectedGameNumber) {
            case "0" -> System.out.println("Good Bye!");
            case "1" -> Cli.welcomeUser(scanner);
            case "2" -> Even.game(scanner);
            default -> System.out.println("Incorrect input");
        }

        scanner.close();
    }
}
