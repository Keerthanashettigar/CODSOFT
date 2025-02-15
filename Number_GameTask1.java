import java.util.Random;
import java.util.Scanner;

public class Number_GameTask1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minimumRange = 1;
        int maximumRange = 100;
        int maxAttempts = 10;
        int score = 0;

        System.out.println("********Welcome to the Number Guessing Game********\n");
        boolean playGameAgain = true;

        while (playGameAgain) {
            int targetNum = random.nextInt(maximumRange - minimumRange + 1) + minimumRange;
            System.out.printf("Round - Range: %d to %d\n", minimumRange, maximumRange);
            System.out.println(" You have " + maxAttempts + " attempts only\n");

            int attempts = 0;
            boolean correctGuess = false;

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guessByUser = scanner.nextInt();
                attempts++;
                if (guessByUser == targetNum) {
                    System.out.printf("Correct! You guessed the number in %d attempts.\n", attempts);
                    score += attempts;
                    correctGuess = true;
                    break;
                } else if (guessByUser < targetNum) {
                    System.out.println(" The guess was too low! Try again.\n");
                } else {
                    System.out.println("the guess was too high! Try again.\n");
                }
            }

            if (!correctGuess) {
                System.out.println("Sorry, all your attempts are over. The correct number was " + targetNum);
            }

            System.out.println("Your score: " + score + "\n");

            System.out.print("Do you want to play one more time? (yes/no): ");
            String playAgainDecision = scanner.next().toLowerCase();
            if (!playAgainDecision.equals("yes")) {
                playGameAgain = false;
            }
        }

        System.out.println("Thank you for playing! Your final score: " + score);

        scanner.close();
    }
}