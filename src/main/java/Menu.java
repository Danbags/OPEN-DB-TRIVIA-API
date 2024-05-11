import java.util.Scanner;

public class Menu extends User {
  private MessagePrinter messagePrinter;
  private UserService userService;
  private Scanner scanner;
  private DatabaseService databaseService;
  private Leaderboard leaderboard;
  private boolean loggedIn;

  public Menu() {
    messagePrinter = new MessagePrinter();
    scanner = new Scanner(System.in);
    databaseService = new DatabaseService();
    userService = new UserService(databaseService);
    loggedIn = false;
    leaderboard = new Leaderboard();

  }

  public void displayMenu() {
    if (!loggedIn) {
        messagePrinter.printMessage("Please select one of the following options:", true, true);
        messagePrinter.printMessage("1) Sign up", true, true);
        messagePrinter.printMessage("2) Login", true, true);
        messagePrinter.printMessage("3) Exit", true, true);

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                signup();
                break;
            case 2:
                login();
                break;
            case 3:
                messagePrinter.printMessage("Thank you for using our services. Have a good day!", true, true);
                scanner.close();
                return; // Exit the method and the program
            default:
                messagePrinter.printMessage("Invalid choice. Please select a valid option.", true, true);
                break;
        }
    }

    if (loggedIn) {
        displayGameMenu();
    } else {
        displayMenu(); // Go back to the main menu
    }
  }

  private void signup() {
   String username, password;
    messagePrinter.printMessage("Enter your desired username: ", true, true);
    username = scanner.nextLine();
    messagePrinter.printMessage("Enter your desired password: ", true, true);
    password = scanner.nextLine();
    userService.signup(username, password);
    
  }

  private void login() {
    String username, password;
    messagePrinter.printMessage("Enter your username: ", true, true);
    username = scanner.nextLine();
    messagePrinter.printMessage("Enter your password: ", true, true);
    password = scanner.nextLine();
    if (userService.login(username, password)) {
      //TO SET THE PASSWORD AND USERNAME FOR THE ACTIVE PLAYER AND SET THEM AS LOGGED IN
      setUsername(username);
      setPassword(password);
      loggedIn = true;
    } else {
      messagePrinter.printMessage("Invalid username or password. Please try again.", true, true);
    }
  }

  public void displayGameMenu() {
    messagePrinter.printMessage("Welcome to the Quiz Game! " + getLoginUsername(), true, false);
    messagePrinter.printMessage("1) Begin Game", true, false);
    messagePrinter.printMessage("2) Display LeaderBoard", true, false);
    messagePrinter.printMessage("3) Sign out", true, false);

messagePrinter.printMessage("QUIT GAME", true, true);

    int choice = scanner.nextInt();
    scanner.nextLine(); // Consume newline

    switch (choice) {
      case 1:
        startGame();
        break;
     
      case 2:
        leaderboard.displayLeaderboard();
        break;
        
        case 3:
        messagePrinter.printMessage("Thank you for playing. Goodbye" + getLoginUsername()+ " !", true, true);
        loggedIn = false; // Log out the user
        break;
          
      case 4:
        System.exit(0);
        break;
      default:
        messagePrinter.printMessage("Invalid choice. Please select a valid option.", true, true);
        break;
    }

    if (loggedIn) {
      displayGameMenu(); // Show the game menu again
    } else {
      displayMenu(); // Go back to the main menu
    }
  }

  private void startGame() {
    QuizGame quizGame = new QuizGame("https://opentdb.com/api.php?amount=1");
    quizGame.startGame();
  }
}
