import java.util.Scanner;
/**
 * This class represents the settings for configuring the quiz.
 * It provides methods for prompting the user to set quiz settings.
 */
public class QuizSettings {
  /**
   * The category of the quiz questions.
   */
  private int category;
  /**
   * The difficulty level of the quiz questions.
   */
  private String difficulty;
  /**
   * The type of the quiz questions.
   */
  private String questionType;
  /**
   * The number of questions in the quiz.
   */
  private int amount;
  /**
   * The scanner instance used for user input.
   */
  private Scanner scanner; // Declare the Scanner object at the class level
  private final String[] options1 = { "Any", "General Knowledge", "Entertainment: Books", "Entertainment: Film",
      "Entertainment: Music", "Entertainment: Musicals & Theatres", "Entertainment: Television",
      "Entertainment: Video Games", "Entertainment: Board Games", "Science & Nature", "Science: Computers",
      "Science: Mathematics", "Mythology", "Sports", "Geography", "History", "Politics", "Art", "Celebrities",
      "Animals", "Vehicles", "Entertainment: Comics", "Science: Gadgets", "Entertainment: Japanese Anime & Manga",
      "Entertainment: Cartoon & Animations" };
  private final String[] options2 = { "Any", "easy", "medium", "hard" };
  private final String[] options3 = { "Any", "multiple", "boolean" };
  
  boolean validamount = false, validcategory = false, validdifficulty = false, validquestiontype = false;
  /**
   * Constructs a new QuizSettings object with default settings.
   */
  public QuizSettings() {
    // Initialize default values
    this.amount = 1;
    this.category = 0;
    this.difficulty = "";
    this.questionType = "";
    this.scanner = new Scanner(System.in); // Initialize the Scanner object
  }
  /**
   * Prompts the user to set quiz settings.
   We build the api url based on the user inputs
   */
  public void promptUser() {
    MessagePrinter messagePrinter = new MessagePrinter();

    // TO MAKE SURE THE USERS SELECT A VALID AMOUNT OF QUESTION TO BE GENERATED
    messagePrinter.printMessage("How many Questions(10 Max): ", true, true);
    int que_amount = scanner.nextInt();

    while (!validamount) {
      if (que_amount >= 1 && que_amount <= 10) {
        validamount = true;
        this.amount = que_amount;
      } else {
        messagePrinter.printMessage("Invalid Range, Please enter a number between 1 and 10", true, true);
        que_amount = scanner.nextInt();// Added to update the value of amount
      }
    }

    // ADDED A FAILSAFE TO MAKE SURE THE USERS SELECT A VALID CATEGORY
    messagePrinter.printMessage("Please select the category of your choice: ", true, true);

    for (int i = 0; i < options1.length; i++) {
      messagePrinter.printMessage(i + ") " + options1[i], true, true);

    }
    //int categoryChoice = scanner.nextInt();
   this.category = scanner.nextInt();
    

    // TO SELECT DIFFICULTY OF CHOICE FROM EASY TO HARD.A FAILSAFE IS ADDED TO MAKE
    // SURE THE USERS SELECT A VALID DIFFICULTY
    messagePrinter.printMessage("Please select the difficulty of your choice", true, true);

    for (int i = 0; i < options2.length; i++) 
    {
      messagePrinter.printMessage(i + ") " + options2[i], true, true);
    }

    int difficultyChoice = scanner.nextInt();
    while (!validdifficulty) {
        if (difficultyChoice >= 0 && difficultyChoice < options2.length) {
            validdifficulty = true;
            if (difficultyChoice == 0) {
                this.difficulty = "";
            } else {
                this.difficulty = options2[difficultyChoice];
            }
        } else {
            messagePrinter.printMessage("Invalid Range, Please enter a number between 0 and " + (options2.length - 1), true, true);
            difficultyChoice = scanner.nextInt(); // to update the value of difficultyChoice
        }
    }
   

    // TO SELECT FROM MULTIPLE CHOICE OR TRUE OR FALSE.A FAILSAFE IS ADDED TO MAKE
    // SURE THE USERS SELECT A VALID QUESTION TYPE
    messagePrinter.printMessage("Please select the type of your choice", true, true);

    for (int i = 0; i < options3.length; i++) 
    {
      messagePrinter.printMessage(i + ") " + options3[i], true, true);
    }
    
    int questionTypeChoice = scanner.nextInt();
      // if (questionTypeChoice >= 1) {
      //   this.questionType = options3[questionTypeChoice];
      // }
    while (!validquestiontype) {
        if (questionTypeChoice >= 0 && questionTypeChoice < options3.length) {
            validquestiontype = true;
            if (questionTypeChoice == 0) {
                this.questionType = "";
            } else {
                this.questionType = options3[questionTypeChoice];
            }
        } else {
            messagePrinter.printMessage("Invalid Range, Please enter a number between 0 and " + (options3.length - 1), true, true);
            questionTypeChoice = scanner.nextInt(); // to update the value of questionTypeCHoice
        }
    }
    }

  public int getCategory() {
    return category + 8; // Offset by 8 to match category IDs in the API.EX: id": 21,"name": "Sports"
  }

  public String getDifficulty() {
    return difficulty;
  }

  public String getQuestionType() {
    return questionType;
  }

  public int getAmount() {
    return amount;
  }

  // Add a method to close the Scanner object when no longer needed
  public void closeScanner() {
    scanner.close();
  }
}