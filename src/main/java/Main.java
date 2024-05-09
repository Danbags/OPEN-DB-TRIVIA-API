import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       /* Menu menu = new Menu();
        while (true) {
            menu.displayMenu();
            int choice = menu.getUserChoice();
            menu.processChoice(choice);*/
        
        Scanner scanner = new Scanner(System.in);



        // Instantiate User and perform login
        User user = new User();
        user.getLogin();
        if(user.checkLogin(user.getUsername(), user.getPassword()))
        {
            Menu menu = new Menu();
            while (true) {
                menu.displayMenu();
                int choice = menu.getUserChoice();
                menu.processChoice(choice);
        }
        }

        // Close scanner
        scanner.close();
      
}
}

/*
 * public class Main {
 * public static void main(String[] args) throws Exception {
 * 
 * QuizGame quizGame = new QuizGame("https://opentdb.com/api.php?amount=1");
 * quizGame.startGame();
 * }
 * }
 */