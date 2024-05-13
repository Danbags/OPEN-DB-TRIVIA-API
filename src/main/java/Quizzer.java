import java.util.List;
import java.util.*;
import java.util.Scanner;

public class Quizzer extends Leaderboard {
  public void quizUser(List<Result> questions, QuizGame game) {
    Scanner scanner = new Scanner(System.in);
    MessagePrinter messagePrinter = new MessagePrinter();
    for (Result question : questions) {

      messagePrinter.printMessage("Question: " + question.getQuestion(), true, true);

      List<String> options = question.getIncorrectAnswers();
      options.add(question.getCorrectAnswer());
      Collections.shuffle(options);

      for (int i = 0; i < options.size(); i++) {

        messagePrinter.printMessage(i + 1 + ")" + options.get(i), true, true);

      }

      // System.out.print("Your answer: ");
      messagePrinter.printMessage("Your answer: ", true, true);
      int userChoice = -1;
      boolean validInput = false;
//TO MAKE SURE THE USER INPUTS A VALID INTEGER  NUMBER and not 
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
boolean validoption = false;
      String userAnswer= "";
      while (!validoption)
        {
          if(userChoice >=1 && userChoice <= options.size())
          {
            validoption = true;
            userAnswer= options.get(userChoice - 1);
          }else {
            messagePrinter.printMessage("That was not part of the options listed, Have another go " + (options.size() - 1), true, true);
            userChoice = scanner.nextInt();
          }
          
     /* if (userChoice < 1 || userChoice > options.size()) {
        System.out.println("Invalid choice. Please select an option between 1 and " + options.size());
        continue;*/
      }

      // String userAnswer = options.get(userChoice - 1);//we -1 because the user will enter a number between 1 and 4, but the index of the array is 0,1,2,

      if (userAnswer.equals(question.getCorrectAnswer())) {
        messagePrinter.printMessage("Correct", true, true);
        game.addToScore(1);
        messagePrinter.printMessage("New Score: " + game.getScore(), true, true);
      } else {
        messagePrinter.printMessage("Incorrect, The answer is: " + question.getCorrectAnswer(), true, true);
      }

    }

    // System.out.println("Quiz completed!");
    messagePrinter.printMessage("Game Over!", true, true);
    if (game.check_win()) {
      messagePrinter.printMessage("Congratulations! You have beat the game!", true, true);
      // SUBMIT USER TO LEADERBOARD
      SubmitUserToLeaderboard(getLoginUsername(), game.getScore());

    } else {
      messagePrinter.printMessage("Sorry, you lose !", true, true);
    }
    messagePrinter.printMessage("Final Score: " + game.getScore(), true, true);
    System.exit(0);

    // }
    scanner.close();

  }
}
