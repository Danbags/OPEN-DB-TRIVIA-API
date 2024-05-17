import java.util.List;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class represents a quiz game player.
 * It provides methods for quizzing the user with questions and handling their responses.
 */
public class Quizzer extends Leaderboard {

  /**
   * Quizzes the user with the provided list of questions.
   * 
   * @param questions The list of questions to ask the user.
   * @param game The QuizGame instance to update the game state.
   */
  public void quizUser(List<Result> questions, QuizGame game) {
    Scanner scanner = new Scanner(System.in);
    MessagePrinter messagePrinter = new MessagePrinter();

    for (Result question : questions) {
      messagePrinter.printMessage("Question: " + question.getQuestion(), true, true);

      List<String> options = question.getIncorrectAnswers();
      options.add(question.getCorrectAnswer());
      Collections.shuffle(options);

      for (int i = 0; i < options.size(); i++) {
        messagePrinter.printMessage((i + 1) + ") " + options.get(i), true, true);
      }

      messagePrinter.printMessage("Your answer: ", true, true);
      int userChoice = -1;
      boolean validInput = false;

      // Ensure the user inputs a valid integer number
      while (!validInput) {
        try {
          if (scanner.hasNextInt()) {
            userChoice = scanner.nextInt();
            validInput = true;
          } else {
            messagePrinter.printMessage("Invalid input. Please enter a number.", true, true);
            scanner.next(); // Clear invalid input
          }
        } catch (InputMismatchException e) {
          messagePrinter.printMessage("Invalid input. Please enter a number.", true, true);
          scanner.next(); // Clear invalid input
        }
      }

      boolean validOption = false;
      String userAnswer = "";
      while (!validOption) {
        if (userChoice >= 1 && userChoice <= options.size()) {
          validOption = true;
          userAnswer = options.get(userChoice - 1);
        } else {
          messagePrinter.printMessage("That was not part of the options listed, have another go: " + options.size(), true, true);
          userChoice = scanner.nextInt();
        }
      }

      if (userAnswer.equals(question.getCorrectAnswer())) {
        messagePrinter.printMessage("Correct", true, true);
        game.addToScore(1);
        messagePrinter.printMessage("New Score: " + game.getScore(), true, true);
      } else {
        messagePrinter.printMessage("Incorrect, The answer is: " + question.getCorrectAnswer(), true, true);
      }
    }

    messagePrinter.printMessage("Game Over!", true, true);
    if (game.checkWin()) {
      messagePrinter.printMessage("Congratulations! You have beaten the game!", true, true);
        submitUserToLeaderboard(getLoginUsername(), game.getScore());
    } else {
      messagePrinter.printMessage("Sorry, you lose!", true, true);
    }
    messagePrinter.printMessage("Final Score: " + game.getScore(), true, true);

    scanner.close();
    System.exit(0);
  }
}
