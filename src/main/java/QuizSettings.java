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
  private Scanner scanner; 

  private final String[] options1 = { 
      "Any", "General Knowledge", "Entertainment: Books", "Entertainment: Film",
      "Entertainment: Music", "Entertainment: Musicals & Theatres", "Entertainment: Television",
      "Entertainment: Video Games", "Entertainment: Board Games", "Science & Nature", "Science: Computers",
      "Science: Mathematics", "Mythology", "Sports", "Geography", "History", "Politics", "Art", "Celebrities",
      "Animals", "Vehicles", "Entertainment: Comics", "Science: Gadgets", "Entertainment: Japanese Anime & Manga",
      "Entertainment: Cartoon & Animations" 
  };
  private final String[] options2 = { "Any", "easy", "medium", "hard" };
  private final String[] options3 = { "Any", "multiple", "boolean" };

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
   */
  public void promptUser() {
    MessagePrinter messagePrinter = new MessagePrinter();

    // Set the number of questions
    messagePrinter.printMessage("How many Questions (1-10): ", true, true);
    int queAmount = scanner.nextInt();
    while (queAmount < 1 || queAmount > 10) {
      messagePrinter.printMessage("Invalid range. Please enter a number between 1 and 10: ", true, true);
      queAmount = scanner.nextInt();
    }
    this.amount = queAmount;

    // Set the category
    messagePrinter.printMessage("Please select the category of your choice: ", true, true);
    for (int i = 0; i < options1.length; i++) {
      messagePrinter.printMessage(i + ") " + options1[i], true, true);
    }
    int categoryChoice = scanner.nextInt();
    while (categoryChoice < 0 || categoryChoice >= options1.length) {
      messagePrinter.printMessage("Invalid range. Please enter a number between 0 and " + (options1.length - 1) + ": ", true, true);
      categoryChoice = scanner.nextInt();
    }
    this.category = categoryChoice;

    // Set the difficulty
    messagePrinter.printMessage("Please select the difficulty of your choice: ", true, true);
    for (int i = 0; i < options2.length; i++) {
      messagePrinter.printMessage(i + ") " + options2[i], true, true);
    }
    int difficultyChoice = scanner.nextInt();
    while (difficultyChoice < 0 || difficultyChoice >= options2.length) {
      messagePrinter.printMessage("Invalid range. Please enter a number between 0 and " + (options2.length - 1) + ": ", true, true);
      difficultyChoice = scanner.nextInt();
    }
    this.difficulty = options2[difficultyChoice].equals("Any") ? "" : options2[difficultyChoice];

    // Set the question type
    messagePrinter.printMessage("Please select the type of your choice: ", true, true);
    for (int i = 0; i < options3.length; i++) {
      messagePrinter.printMessage(i + ") " + options3[i], true, true);
    }
    int questionTypeChoice = scanner.nextInt();
    while (questionTypeChoice < 0 || questionTypeChoice >= options3.length) {
      messagePrinter.printMessage("Invalid range. Please enter a number between 0 and " + (options3.length - 1) + ": ", true, true);
      questionTypeChoice = scanner.nextInt();
    }
    this.questionType = options3[questionTypeChoice].equals("Any") ? "" : options3[questionTypeChoice];
  }

  /**
   * Gets the category ID.
   * 
   * @return The category ID offset by 8 to match the API category IDs.
   */
  public int getCategory() {
    return category + 8; // Offset by 8 to match category IDs in the API
  }

  /**
   * Gets the difficulty level.
   * 
   * @return The difficulty level as a string.
   */
  public String getDifficulty() {
    return difficulty;
  }

  /**
   * Gets the question type.
   * 
   * @return The question type as a string.
   */
  public String getQuestionType() {
    return questionType;
  }

  /**
   * Gets the number of questions.
   * 
   * @return The number of questions.
   */
  public int getAmount() {
    return amount;
  }

  /**
   * Closes the Scanner object.
   */
  public void closeScanner() {
    scanner.close();
  }
}
