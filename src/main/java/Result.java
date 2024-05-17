import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * This class represents a result of a quiz question.
 * It contains information about the question such as category, difficulty,
 * question text, correct answer, and incorrect answers.
 */
public class Result {
    @SerializedName("type")
    @Expose
    /**
     * The type of the question (e.g., Multiple Choice, True or False).
     */
    private String type;

    @SerializedName("difficulty")
    @Expose
    /**
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

    /**
     * Gets the type of the question.
     * 
     * @return The type of the question.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the question.
     * 
     * @param type The type to set.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the difficulty of the question.
     * 
     * @return The difficulty of the question.
     */
    public String getDifficulty() {
        return difficulty;
    }

    /**
     * Sets the difficulty of the question.
     * 
     * @param difficulty The difficulty to set.
     */
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * Gets the category of the question.
     * 
     * @return The category of the question.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category of the question.
     * 
     * @param category The category to set.
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Gets the text of the question.
     * 
     * @return The text of the question.
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Sets the text of the question.
     * 
     * @param question The question text to set.
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * Gets the correct answer to the question.
     * 
     * @return The correct answer.
     */
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    /**
     * Sets the correct answer to the question.
     * 
     * @param correctAnswer The correct answer to set.
     */
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    /**
     * Gets the list of incorrect answers to the question.
     * 
     * @return The list of incorrect answers.
     */
    public List<String> getIncorrectAnswers() {
        return incorrectAnswers;
    }

    /**
     * Sets the list of incorrect answers to the question.
     * 
     * @param incorrectAnswers The incorrect answers to set.
     */
    public void setIncorrectAnswers(List<String> incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }
}
