import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.URI;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import java.util.List;

/**
 * This class represents a quiz game.
 * It provides methods for starting the game, fetching quiz questions,
 * and quizzing the user.
 */
public class QuizGame {

  /**
   * The base URL of the quiz API.
   */
  private static final String API_BASE_URL = "https://opentdb.com/api.php?";

  /**
   * The API URL for fetching quiz questions.
   */
  private String apiUrl;

  /**
   * The score of the player.
   */
  private int score = 0;

  /**
   * The amount of questions in the quiz.
   */
  private int questionAmount;

  /**
   * Constructs a new QuizGame object with the specified API URL.
   * 
   * @param apiUrl The URL of the quiz API.
   */
  public QuizGame(String apiUrl) {
    this.apiUrl = apiUrl;
  }

  /**
   * Starts the quiz game.
   */
  public void startGame() {
    QuizSettings settings = new QuizSettings();
    settings.promptUser();

    String apiUrl = constructApiUrl(settings);

    try {
      // Retrieve quiz questions from the API
      HttpResponse<String> response = sendGetRequest(apiUrl);

      // Deserialize the JSON response into a Quiz object
      Quiz quiz = deserializeQuiz(response.body());

      // Quiz the user
      Quizzer quizzer = new Quizzer();
      quizzer.quizUser(quiz.getResults(), this);

      // Display final score
      System.out.println("Final Score: " + score);
    } catch (Exception e) {
      System.out.println("An error occurred while fetching quiz questions: " + e.getMessage());
    }
  }

  /**
   * Constructs the API URL based on the quiz settings.
   * 
   * @param settings The quiz settings.
   * @return The constructed API URL.
   */
  private String constructApiUrl(QuizSettings settings) {
    StringBuilder apiUrlBuilder = new StringBuilder(API_BASE_URL);
    apiUrlBuilder.append("amount=").append(settings.getAmount());
    questionAmount = settings.getAmount();
    if (settings.getCategory() >= 9) {
      apiUrlBuilder.append("&category=").append(settings.getCategory());
    }
    if (!settings.getDifficulty().isEmpty()) {
      apiUrlBuilder.append("&difficulty=").append(settings.getDifficulty());
    }
    if (!settings.getQuestionType().isEmpty()) {
      apiUrlBuilder.append("&type=").append(settings.getQuestionType());
    }
    return apiUrlBuilder.toString();
  }

  /**
   * Sends an HTTP GET request to the specified URL.
   * 
   * @param url The URL to send the request to.
   * @return The HTTP response.
   * @throws Exception If an error occurs during the request.
   */
  private HttpResponse<String> sendGetRequest(String url) throws Exception {
    HttpRequest getRequest = HttpRequest.newBuilder()
        .uri(new URI(url))
        .GET()
        .build();
    return HttpClient.newHttpClient().send(getRequest, HttpResponse.BodyHandlers.ofString());
  }

  /**
   * Deserializes the JSON response into a Quiz object.
   * 
   * @param json The JSON response.
   * @return The deserialized Quiz object.
   */
  private Quiz deserializeQuiz(String json) {
    Gson gson = new Gson();
    return gson.fromJson(json, Quiz.class);
  }

  /**
   * Adds the specified points to the player's score.
   * 
   * @param points The points to add.
   */
  public void addToScore(int points) {
    score += points;
  }

  /**
   * Gets the player's current score.
   * 
   * @return The player's score.
   */
  public int getScore() {
    return score;
  }

  /**
   * Checks if the player has won the quiz game.
   * 
   * @return True if the player has won, otherwise false.
   */
  public boolean checkWin() {
    return score > questionAmount * 0.7;
  }
}
