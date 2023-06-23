package hexlet.code;

import java.util.Scanner;

public final class Even {
    private Even() {
        // Приватный конструктор
    }

    public static void game(Scanner scanner) {
        final int targetScore = 3;

        Cli.welcomeUser(scanner);
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'");

        int scoredPoints = 0;
        while (scoredPoints < targetScore) {
            int randomNumber = (int) (Math.random() * 100) + 1;
            System.out.printf("Question: %d\n", randomNumber);

            int remainderOfDivision = randomNumber % 2;
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();
            if ((remainderOfDivision == 0 && userAnswer.equals("yes"))
                    || (remainderOfDivision != 0 && userAnswer.equals("no"))) {
                System.out.println("Correct!");
                scoredPoints++;
            } else {
                System.out.println("'yes' is wrong answer ;(. Correct answer was 'no'");
                System.out.printf("Let's try again, %s!\n", Cli.userName);
                break;
            }
        }

        if (scoredPoints == targetScore) {
            System.out.printf("Congratulations, %s!\n", Cli.userName);
        }
    }
}
