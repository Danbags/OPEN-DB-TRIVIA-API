import java.util.Scanner;

public class Menu{
  private Scanner scanner;

  public Menu() {
    scanner = new Scanner(System.in);
  }

  public void displayMenu() {
    MessagePrinter messagePrinter = new MessagePrinter();
    messagePrinter.printMessage("Welcome to the Quiz Game!", true, true);
    // System.out.println("Welcome to the Quiz Game!");
    messagePrinter.printMessage("1)Begin Game", false, true);
    // System.out.println("1. Begin Game");
    messagePrinter.printMessage("2)Quit", false, true);
    // System.out.println("2. Exit");
  }

  public int getUserChoice() {
    int choice = -1;
    while (choice < 1 || choice > 2) {
      try {
        System.out.print("Enter your choice: ");
        choice = Integer.parseInt(scanner.nextLine());
        if (choice < 1 || choice > 2) {
          System.out.println("Invalid choice. Please enter 1 or 2.");
        }
      } catch (NumberFormatException e) {
        System.out.println("Invalid choice. Please enter a number.");
      }
    }
    return choice;
  }

  public void processChoice(int choice) {
    switch (choice) {
      case 1:
        startGame();
        break;
      case 2:
        System.out.println("Exiting...");
        System.exit(0);
        break;
    }
  }

  private void startGame() {
    QuizGame quizGame = new QuizGame("https://opentdb.com/api.php?amount=1");
    quizGame.startGame();
  }

}
