package hexlet.code;

import java.util.Scanner;
import static hexlet.code.Engine.runGames;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        runGames(scanner);

        scanner.close();
    }
}