import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class represents a service for interacting with the database.
 * It provides methods for adding users and checking login credentials.
 */
public class DatabaseService {

  /**
   * The path to the database file.
   */
  private static final String DATABASE_FILE = "src/database.txt";

  /**
   * The message printer instance used for printing messages.
   */
  private MessagePrinter messagePrinter = new MessagePrinter();

  /**
   * Adds a new user to the database with the provided username and password.
   * 
   * @param username The username of the user to add.
   * @param password The password of the user to add.
   */
  public void addUser(String username, String password) {
    try (FileWriter writer = new FileWriter(new File(DATABASE_FILE), true)) {
      writer.write(username + "\t" + password + "\n");
      messagePrinter.printMessage("Registration successful!", true, true);
    } catch (IOException e) {
      System.out.println("Error writing to database file!");
      e.printStackTrace();
    }
  }

  /**
   * Checks if the provided username and password match any records in the
   * database.
   * 
   * @param username The username to check.
   * @param password The password to check.
   * @return True if the login credentials are valid, otherwise false.
   */
  public boolean checkLogin(String username, String password) {
    try (Scanner fileScanner = new Scanner(new File(DATABASE_FILE))) {
      boolean usernameFound = false;
      while (fileScanner.hasNextLine()) {
        String line = fileScanner.nextLine();
        String[] parts = line.split("\\t");
        if (parts[0].equals(username)) {
          usernameFound = true;
          if (parts[1].equals(password)) {
            messagePrinter.printMessage("Login successful!", true, true);
            return true;
          } else {
            messagePrinter.printMessage("Invalid password!", true, true);
            return false;
          }
        }
      }
      if (usernameFound) {
        messagePrinter.printMessage("Incorrect password!", true, true);
      } else {
        messagePrinter.printMessage("Invalid username and password!", true, true);
      }
    } catch (FileNotFoundException e) {
      System.out.println("Database file not found!");
      e.printStackTrace();
    }
    return false;
  }
}
