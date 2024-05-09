import java.io.FileWriter;
import java.io.IOException;

public class Leaderboard {

    public void writeScoreToFile(String username, int score) {
        try {
            FileWriter writer = new FileWriter("src/leaderboard.txt", true); // Append mode
            writer.write("Username: " + username + ", Score: " + score + "\n");
            writer.close();
            System.out.println("Score written to file successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while writing the score to file.");
            e.printStackTrace();
        }
    }

   
}
