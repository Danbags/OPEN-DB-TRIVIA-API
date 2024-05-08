import java.util.List;
import java.util.*;
import java.util.Scanner;

public class Quizzer {
  public void quizUser(List<Result> questions, QuizGame game) {
    Scanner scanner = new Scanner(System.in);
    MessagePrinter messagePrinter = new MessagePrinter();
    for (Result question : questions) {

      messagePrinter.printMessage("Question: " + question.getQuestion(), true, true);

      // System.out.println("Question: " + question.getQuestion());
      List<String> options = question.getIncorrectAnswers();
      options.add(question.getCorrectAnswer());
      Collections.shuffle(options);

      // System.out.println("Options:");

      for (int i = 0; i < options.size(); i++) {
       // System.out.println((i + 1) + ". " + options.get(i));
        messagePrinter.printMessage(i + 1 + ")" + options.get(i), true, true);

      }

      //System.out.print("Your answer: ");
      messagePrinter.printMessage("Your answer: ", true, true);
      int userChoice = -1;
      boolean validInput = false;

      while (!validInput) {
        try {
          if (scanner.hasNextInt()) {
            userChoice = scanner.nextInt();
            validInput = true;
          } else {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Clear invalid input
          }
        } catch (InputMismatchException e) {
          System.out.println("Invalid input. Please enter a number.");
          scanner.next(); // Clear invalid input
        }
      }

      if (userChoice < 1 || userChoice > options.size()) {
        System.out.println("Invalid choice. Please select an option between 1 and " + options.size());
        continue;
      }

      String userAnswer = options.get(userChoice - 1);

      if (userAnswer.equals(question.getCorrectAnswer())) {
        System.out.println("Correct!");
        game.addToScore(1);
      } else {
        System.out.println("Incorrect!");
      }
    }

    System.out.println("Quiz completed!");
    scanner.close();
  }
}
