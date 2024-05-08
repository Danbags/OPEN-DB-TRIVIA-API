import java.util.Scanner;



/*public class Main {
  public static void main(String[] args) {
     Menu menu = new Menu();
      while (true) {
          menu.displayMenu();
          int choice = menu.getUserChoice();
          menu.processChoice(choice);
      }
  }
}*/
 

public class Main {
    public static void main(String[] args) throws Exception {
      
        QuizGame quizGame = new QuizGame("https://opentdb.com/api.php?amount=1");
        quizGame.startGame();
    }
}