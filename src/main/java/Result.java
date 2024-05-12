import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
/**
 * This class represents a result of a quiz question.
 * It contains information about the question such as category, difficulty, question text,
 * correct answer, and incorrect answers.
 */
public class Result {
  @SerializedName("type")
  @Expose
  /**
   * The type of the question.Multiple CHoice, True or False.
   */
  private String type;

  @SerializedName("difficulty")
  @Expose/**
   * The difficulty of the question.
   */
  private String difficulty;

  @SerializedName("category")
  @Expose
  /**
   * The category of the question.
   */
  private String category;

  @SerializedName("question")
  @Expose
  /**
   * The text of the question.
   */
  private String question;

  @SerializedName("correct_answer")
  @Expose
  /**
   * The correct answer to the question.
   */

  private String correctAnswer;

  @SerializedName("incorrect_answers")
  @Expose
  /**
   * The list of incorrect answers to the question.
   */
  private List<String> incorrectAnswers;

  // Getters and setters for the fields...

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getDifficulty() {
    return difficulty;
  }

  public void setDifficulty(String difficulty) {
    this.difficulty = difficulty;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public String getCorrectAnswer() {
    return correctAnswer;
  }

  public void setCorrectAnswer(String correctAnswer) {
    this.correctAnswer = correctAnswer;
  }

  public List<String> getIncorrectAnswers() {
    return incorrectAnswers;
  }

  public void setIncorrectAnswers(List<String> incorrectAnswers) {
    this.incorrectAnswers = incorrectAnswers;
  }
}