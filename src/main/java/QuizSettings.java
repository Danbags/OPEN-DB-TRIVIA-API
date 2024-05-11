import java.util.Scanner;

public class QuizSettings {
  private int category;
  private String difficulty;
  private String questionType;
  private final String[] options1 = { "Any", "General Knowledge", "Entertainment: Books", "Entertainment: Film",
      "Entertainment: Music", "Entertainment: Musicals & Theatres", "Entertainment: Television",
      "Entertainment: Video Games", "Entertainment: Board Games", "Science & Nature", "Science: Computers",
      "Science: Mathematics", "Mythology", "Sports", "Geography", "History", "Politics", "Art", "Celebrities",
      "Animals", "Vehicles", "Entertainment: Comics", "Science: Gadgets", "Entertainment: Japanese Anime & Manga",
      "Entertainment: Cartoon & Animations" };
  private final String[] options2 = { "Any", "easy", "medium", "hard" };
  private final String[] options3 = { "Any", "multiple", "boolean" };
  private Scanner scanner; // Declare the Scanner object at the class level
  private int amount;

  public QuizSettings() {
    // Initialize default values
    this.amount = 1;
    this.category = 0;
    this.difficulty = "";
    this.questionType = "";
    this.scanner = new Scanner(System.in); // Initialize the Scanner object
  }

  public void promptUser() {
    MessagePrinter messagePrinter = new MessagePrinter();
    messagePrinter.printMessage("How many Questions(10 Max): ", true, true);
    this.amount = scanner.nextInt();
    messagePrinter.printMessage("Please select the category of your choice: ", true, true);
    // System.out.println("Please select the category of your choice: ");
    for (int i = 0; i < options1.length; i++) {
      messagePrinter.printMessage(i + ") " + options1[i], true, true);
      // System.out.println(i + ". " + options1[i]);
    }
    this.category = scanner.nextInt();
    messagePrinter.printMessage("Please select the difficulty of your choice", true, true);
    // System.out.println("Please select the difficulty of your choice");
    for (int i = 0; i < options2.length; i++) {
      messagePrinter.printMessage(i + ") " + options2[i], true, true);

      // System.out.println(i + ". " + options2[i]);
    }
    int difficultyChoice = scanner.nextInt();

    if (difficultyChoice >= 1) {
      this.difficulty = options2[difficultyChoice];
    }
    messagePrinter.printMessage("Please select the type of your choice", true, true);
    // System.out.println("Please select the type of questions you prefer");
    for (int i = 0; i < options3.length; i++) {
      messagePrinter.printMessage(i + ") " + options3[i], true, true);

      // System.out.println(i + ". " + options3[i]);
    }
    int questionTypeChoice = scanner.nextInt();
    if (questionTypeChoice >= 1) {
      this.questionType = options3[questionTypeChoice];
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