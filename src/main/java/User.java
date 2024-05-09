import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class User {

  private String username;
  private String password;

  public void getLogin() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter your username: ");
    username = scanner.nextLine();
    System.out.println("Enter your password: ");
    password = scanner.nextLine();
    checkLogin(username, password);
  }

  public void checkLogin(String username, String password) {
    try {
      File file = new File("src/database.txt"); // Path to mock database file
      Scanner fileScanner = new Scanner(file);
      boolean found = false;
      while (fileScanner.hasNextLine()) {
        String line = fileScanner.nextLine();
        String[] parts = line.split("\\t");
        if (parts[0].equals(username) && parts[1].equals(password)) {
          found = true;
          break;
        }
      }
      if (found) {
        System.out.println("Login successful!");
      } else {
        System.out.println("Invalid username or password!");
      }
      fileScanner.close();
    } catch (FileNotFoundException e) {
      System.out.println("Database file not found!");
      e.printStackTrace();
    }
  }

}
