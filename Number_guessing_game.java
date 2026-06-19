
import java.util.Random;
import java.util.Scanner;
public class Number_guessing_game{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int totalRounds = 0;
        int totalAttempts = 0;
        int roundsWon = 0;
        
        System.out.println("=========================================");
        System.out.println("     WELCOME TO THE NUMBER LOGIC ENGINE  ");
        System.out.println("=========================================");
        System.out.println("Step into your role as a Java Developer.");
        System.out.println("Let's test your programmatic logic.\n");

        boolean playAgain = true;
        while (playAgain) {
            totalRounds++;
            int targetNumber = random.nextInt(100) + 1; 
            int attemptsInRound = 0;
            final int MAX_ATTEMPTS = 10; 
            boolean isCorrect = false;

            System.out.println("--- ROUND " + totalRounds + " ---");
            System.out.println("System state: Stochastic number generated between 1 and 100.");
            System.out.println("You have a maximum of " + MAX_ATTEMPTS + " attempts to deduce it.");
            System.out.println("-----------------------------------------");
            while (attemptsInRound < MAX_ATTEMPTS && !isCorrect) {
                System.out.print("Enter your guess (Attempt " + (attemptsInRound + 1) + "/" + MAX_ATTEMPTS + "): ");
                

                while (!scanner.hasNextInt()) {
                    System.out.println("Error: Type-safe stream exception. Please enter a valid integer.");
                    System.out.print("Enter your guess: ");
                    scanner.next(); // Clear the invalid token
                }
                
                int userGuess = scanner.nextInt();
                attemptsInRound++;
                totalAttempts++;
                if (userGuess == targetNumber) {
                    System.out.println("\n>>> SUCCESS! Correct sequence identified. Target was: " + targetNumber);
                    System.out.println("Deduction completed in " + attemptsInRound + " attempts.\n");
                    isCorrect = true;
                    roundsWon++;
                } else if (userGuess > targetNumber) {
                    System.out.println("Feedback loop status: [ TOO HIGH ]");
                } else {
                    System.out.println("Feedback loop status: [ TOO LOW ]");
                }
            }
            if (!isCorrect) {
                System.out.println("\n>>> Round Capacity Reached! You run out of attempts.");
                System.out.println("The hidden memory state value was: " + targetNumber + "\n");
            }
            System.out.print("Would you like to initiate another execution cycle? (yes/no): ");
            String userChoice = scanner.next().trim().toLowerCase();
            if (!userChoice.equals("yes") && !userChoice.equals("y")) {
                playAgain = false;
            }
            System.out.println();
        }

        System.out.println("=========================================");
        System.out.println("       FINAL SCORE & METRICS SUMMARY     ");
        System.out.println("=========================================");
        System.out.println("Total Round Logs Executed : " + totalRounds);
        System.out.println("Successful Terminations   : " + roundsWon);
        System.out.println("Total Program Attempts    : " + totalAttempts);
        if (roundsWon > 0) {
            double averageAttempts = (double) totalAttempts / totalRounds;
            System.out.printf("Deduction Efficiency Rate : %.2f attempts/round\n", averageAttempts);
        }
        System.out.println("=========================================");
        System.out.println("Milestone verified. Logic Phase complete.");
        System.out.println("=========================================");

        scanner.close();
    }
}