package hexlet.code;

import java.util.Scanner;

public final class Cli {
    private Cli() {
        // Приватный конструктор
    }

    private static String userName;

    public static void welcomeUser(Scanner scanner) {

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        Cli.userName = scanner.nextLine();
        System.out.printf("Hello, %s!%n", Cli.userName);
    }

    public static String getUserName() {
        return Cli.userName;
    }
}
