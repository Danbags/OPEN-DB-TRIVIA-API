import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class User extends MessagePrinter {

  private String username;
  private String password;

  public void getLogin() {
    Scanner scanner = new Scanner(System.in);
    printMessage("Enter your Username: ", true, true);
   // System.out.println("Enter your username: ");
    username = scanner.nextLine();
    printMessage("Enter your Password: ", true, true);
   // System.out.println("Enter your password: ");
    password = scanner.nextLine();
   // checkLogin(username, password);
  }

  public String getUsername() {
    return username;
  }
  public String getPassword() {
    return password;
  }

  public boolean checkLogin(String username, String password) {
    try {
      File file = new File("src/database.txt"); // Path to mock database file
      Scanner fileScanner = new Scanner(file);
      boolean usernameFound = false; // Flag to track if username is found
      while (fileScanner.hasNextLine()) {
        String line = fileScanner.nextLine();
        String[] parts = line.split("\\t");
        if (parts[0].equals(username)) {
          usernameFound = true; // Username found in the database
          if (parts[1].equals(password)) {
            printMessage("Login Sucessful!", true, true);
            // System.out.println("Login successful!");
            fileScanner.close();
            return true;
          } else {
            printMessage("Invalid Password!", true, true);//System.out.println("Incorrect password!");
            fileScanner.close();
            return false;
          }
        }
      }
      fileScanner.close();
      if (usernameFound) {
        printMessage("Incorrect Username! ", true, true);
        //System.out.println("Incorrect password!"); // Username found, but password is incorrect
      } else {
        printMessage("INVALID PASSWORD AND USERNAME", true, true);
        //System.out.println("Username not found!"); // Username not found in the database
      }
    } catch (FileNotFoundException e) {
      System.out.println("Database file not found!");
      e.printStackTrace();
    }
    return false; // Return false if there's an error or if username/password are incorrect
  }

}
