import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Leaderboard extends User {
    private MessagePrinter messagePrinter = new MessagePrinter();

    public void SubmitUserToLeaderboard(String username, int score) {
        try {
            FileWriter writer = new FileWriter("src/leaderboard.txt", true); // Append mode
            writer.write(getLoginUsername() + "\\t" + score + "\n");
            writer.close();
            messagePrinter.printMessage("Your score has been submited to the leaderboard", true, true);
        } catch (IOException e) {
            messagePrinter.printMessage("Error submitting score to the leaderboard", true, true);
            e.printStackTrace();
        }
    }

    public void displayLeaderboard() {
        /*
         * try {
         * FileReader reader = new FileReader("src/leaderboard.txt");
         * BufferedReader bufferedReader = new BufferedReader(reader);
         * String line;
         * while ((line = bufferedReader.readLine()) != null) {
         * messagePrinter.printMessage(line, true, true);
         * }
         * bufferedReader.close();
         * } catch (IOException e) {
         * messagePrinter.
         * printMessage("An error occurred while fetching the leaderboard file.", true,
         * true);
         * e.printStackTrace();
         * }
         * }
         */
        try {
            File file = new File("src/leaderboard.txt"); // Path to leaderboard file
            Scanner fileScanner = new Scanner(file);
            messagePrinter.printMessage("Leaderboard Top Scores", true, false);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split("\\t");
                if (parts.length >= 2) { // Ensure there are at least two parts (username and score)
                    String user = parts[0];
                    String score = parts[1];
                    messagePrinter.printMessage(user + "\\t" + score, true, true);
                } else {
                    // Handle invalid format or empty lines
                    messagePrinter.printMessage("Invalid leaderboard entry: " + line, true, true);
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            messagePrinter.printMessage("Leaderboard file not found.", true, true);
        }
    }
}
