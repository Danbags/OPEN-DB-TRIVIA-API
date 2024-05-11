import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
public class Leaderboard extends User {
private MessagePrinter messagePrinter = new MessagePrinter();
    public void SubmitUserToLeaderboard(String username, int score) {
        try {
            FileWriter writer = new FileWriter("src/leaderboard.txt", true); // Append mode
            writer.write(getLoginUsername()+ "/t" + score + "\n");
            writer.close();
                messagePrinter.printMessage("Your score has been submited to the leaderboard", true, true);
        } catch (IOException e) {
                messagePrinter.printMessage("Error submitting score to the leaderboard", true, true);
            e.printStackTrace();
        }
    }

    public void displayLeaderboard()
    {
        try {
            FileReader reader = new FileReader("src/leaderboard.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                    messagePrinter.printMessage(line, true, true);
            }
            bufferedReader.close();
        } catch (IOException e) {
                messagePrinter.printMessage("An error occurred while fetching the leaderboard file.", true, true);
            e.printStackTrace();
        }
    }

   
}
