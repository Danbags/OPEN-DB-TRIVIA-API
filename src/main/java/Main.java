import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    
                MessagePrinter messagePrinter = new MessagePrinter();
        DatabaseService databaseService = new DatabaseService();
                UserService userService = new UserService(databaseService); 
        // Initialize UserService as needed
                // Menu menu = new Menu(messagePrinter, userService);
Menu menu = new Menu();
                menu.displayMenu();
            }
        }
