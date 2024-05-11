import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
public class DatabaseService {
    
    private static final String DATABASE_FILE = "src/database.txt";
private MessagePrinter meessagePrinter = new MessagePrinter();

     public void addUser(String username, String password)
      {
        try {
          File file = new File("src/database.txt"); // Path to mock database file
          FileWriter writer = new FileWriter(file, true); // Append mode
          writer.write(username + "\t" + password + "\n");
          writer.close();
            meessagePrinter.printMessage("Registration successful!", true, true);
          // System.out.println("Registration successful!");
        } catch (IOException e) {
          System.out.println("Error writing to database file!");
          e.printStackTrace();
        }
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
                  meessagePrinter.printMessage("Login Sucessful!", true, true);
                // System.out.println("Login successful!");
                fileScanner.close();
                return true;
              } else {
                  meessagePrinter.printMessage("Invalid Password!", true, true);//System.out.println("Incorrect password!");
                fileScanner.close();
                return false;
              }
            }
          }
          fileScanner.close();
          if (usernameFound) {
              meessagePrinter.printMessage("Incorrect Username! ", true, true);
            //System.out.println("Incorrect password!"); // Username found, but password is incorrect
          } else {
              meessagePrinter.printMessage("INVALID PASSWORD AND USERNAME", true, true);
            //System.out.println("Username not found!"); // Username not found in the database
          }
        } catch (FileNotFoundException e) {
          System.out.println("Database file not found!");
          e.printStackTrace();
        }
        return false; // Return false if there's an error or if username/password are incorrect
      }

}