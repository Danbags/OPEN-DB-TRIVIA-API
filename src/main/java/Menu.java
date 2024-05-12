import java.util.Scanner;

/**
 * This class represents the main menu of the application.
 * It provides methods for displaying the menu and handling user input.
 */
public class Menu extends User {
  /**
   * The message printer instance used for printing messages.
   */
  private MessagePrinter messagePrinter;
  /**
   * The user service instance used for user authentication and signup.
   */
  private UserService userService;
  /**
   * The scanner instance used for user input.
   */
  private Scanner scanner;
  /**
   * The database service instance used for database operations.
   */
  private DatabaseService databaseService;
  /**
   * The leaderboard instance used for accessing leaderboard functionalities.
   */
  private Leaderboard leaderboard;
  /**
   * Flag indicating whether a user is logged in or not.
   */
  private boolean loggedIn;

  /**
   * Constructs a new Menu object.
   * that initializes the message printer, user service, scanner, database
   * service, and leaderboard.
   */
  public Menu() {

    messagePrinter = new MessagePrinter();
    scanner = new Scanner(System.in);
    databaseService = new DatabaseService();
    userService = new UserService(databaseService);
    loggedIn = false;
    leaderboard = new Leaderboard();

  }

  /**
   * Displays the main menu of the application.
   */
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
    String username = "", password = "";
    boolean validUsername = false;
    boolean validPassword = false;

    // Loop until a valid username is entered
    while (!validUsername) {
      messagePrinter.printMessage("Enter your desired username (minimum 4 characters, no spaces): ", true, true);
      username = scanner.nextLine();

      // Check if username meets length and character requirements
      if (username.length() >= 4 && !username.contains(" ")) {
        validUsername = true;
      } else {
        messagePrinter.printMessage(
            "Invalid username. Username must be at least 4 characters long and contain no spaces.", true, true);
      }
    }

    // Loop until a valid password is entered
    while (!validPassword) {
      messagePrinter.printMessage("Enter your desired password (minimum 6 characters): ", true, true);
      password = scanner.nextLine();

      // Check if password meets length requirement
      if (password.length() >= 6) {
        validPassword = true;
      } else {
        messagePrinter.printMessage("Invalid password. Password must be at least 6 characters long.No Spaces", true,
            true);
      }
    }

    // Once both username and password are valid, proceed with signup
    userService.signup(username, password);
  }

  private void login() {
    String username, password;
    messagePrinter.printMessage("Enter your username: ", true, true);
    username = scanner.nextLine();
    messagePrinter.printMessage("Enter your password: ", true, true);
    password = scanner.nextLine();
    if (userService.login(username, password)) {
      // TO SET THE PASSWORD AND USERNAME FOR THE ACTIVE PLAYER AND SET THEM AS LOGGED
      // IN
      setUsername(username);
      setPassword(password);
      loggedIn = true;
    } // else {
    // messagePrinter.printMessage("Invalid username or password. Please try
    // again.", true, true);
    // }
  }

  public void displayGameMenu() {
    messagePrinter.printMessage("Welcome to the Quiz Game! 😄 " + getLoginUsername(), true, false);
    messagePrinter.printMessage("1) Begin Game", true, false);
    messagePrinter.printMessage("2) Display LeaderBoard", true, false);
    messagePrinter.printMessage("3) Sign out", true, false);
    messagePrinter.printMessage("4)QUIT GAME", true, true);

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
        messagePrinter.printMessage("Thank you for playing. Goodbye " + getLoginUsername() + " !", true, true);
        loggedIn = false; // Log out the user
        break;

      case 4:
        System.exit(0);
        break;
      default:
        messagePrinter.printMessage("Invalid choice. Please select a valid option from the menu.", true, true);
        break;
    }

    if (loggedIn) {
      displayGameMenu(); // Show the game menu again
    } else {
      displayMenu(); // Go back to the main menu
    }
  }

  private void startGame() {
    QuizGame quizGame = new QuizGame("https://opentdb.com/api.php?");
    quizGame.startGame();
  }
}
