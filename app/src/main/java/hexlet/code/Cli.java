package hexlet.code;

import java.util.Scanner;

public final class Cli {
    private Cli() {
        // Приватный конструктор
    }

    public static void welcomeUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.printf("Hello, %s!%n", userName);

        scanner.close();
    }
}
