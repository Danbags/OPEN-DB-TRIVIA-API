import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * This class represents a leaderboard for tracking user scores.
 * It provides methods for submitting user scores and displaying the
 * leaderboard.
 */
public class Leaderboard extends User {

    /**
     * The message printer instance used for printing messages.
     */
    private MessagePrinter messagePrinter = new MessagePrinter();

    /**
     * Submits the user's score to the leaderboard.
     * 
     * @param username The username of the user.
     * @param score    The score to submit.
     */
    public void submitUserToLeaderboard(String username, int score) {
        try (FileWriter writer = new FileWriter("src/leaderboard.txt", true)) {
            writer.write(getLoginUsername() + "\t" + score + "\n");
            messagePrinter.printMessage("Your score has been submitted to the leaderboard", true, true);
        } catch (IOException e) {
            messagePrinter.printMessage("Error submitting score to the leaderboard", true, true);
            e.printStackTrace();
        }
    }

    /**
     * Displays the leaderboard showing the top scores.
     */
    public void displayLeaderboard() {
        try (Scanner fileScanner = new Scanner(new File("src/leaderboard.txt"))) {
            messagePrinter.printMessage("Leaderboard Top Scores", true, false);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split("\\t");
                if (parts.length >= 2) {
                    String user = parts[0];
                    String score = parts[1];
                    messagePrinter.printMessage(user + "\t" + score, true, true);
                } else {
                    // Handle invalid format or empty lines
                    messagePrinter.printMessage("🔴" + line, true, true);
                }
            }
        } catch (FileNotFoundException e) {
            messagePrinter.printMessage("Leaderboard file not found.", true, true);
        }
    }
}
