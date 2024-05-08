import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.URI;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import java.util.List;
import java.util.Scanner;

public class QuizGame {
  private static final String API_BASE_URL = "https://opentdb.com/api.php?amount=1";
  private String apiUrl;
  private int score = 0;

  public QuizGame(String apiUrl) {
    this.apiUrl = apiUrl;
  }

  public void startGame() {
    QuizSettings settings = new QuizSettings();
    settings.promptUser();

    String apiUrl = constructApiUrl(settings);

    try {
      // Retrieve quiz question from the API
      HttpResponse<String> response = sendGetRequest(apiUrl);

      // Deserialize the JSON response into a Quiz object
      Quiz quiz = deserializeQuiz(response.body());

      // Display the quiz question to the player
      //displayQuestion(quiz);

      // Quiz the user
      Quizzer quizzer = new Quizzer();
      quizzer.quizUser(quiz.getResults(), this);

      // Display final score
      System.out.println("Final Score: " + score);
    } catch (Exception e) {
      System.out.println("An error occurred while fetching quiz question: " + e.getMessage());
    }
  }

  private String constructApiUrl(QuizSettings settings) {
    StringBuilder apiUrlBuilder = new StringBuilder(API_BASE_URL);

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

  private HttpResponse<String> sendGetRequest(String url) throws Exception {
    HttpRequest getRequest = HttpRequest.newBuilder()
        .uri(new URI(url))
        .GET()
        .build();

    return HttpClient.newHttpClient().send(getRequest, HttpResponse.BodyHandlers.ofString());
  }

  private Quiz deserializeQuiz(String json) {
    Gson gson = new Gson();
    return gson.fromJson(json, Quiz.class);
  }

  private void displayQuestion(Quiz quiz) {
    List<Result> results = quiz.getResults();
    if (!results.isEmpty()) {
      Result result = results.get(0);
      System.out.println("Category: " + result.getCategory());
      System.out.println("Question: " + result.getQuestion());
      System.out.println("Type: " + result.getType());
      System.out.println("Difficulty: " + result.getDifficulty());
      System.out.println("Incorrect Answer: " + result.getIncorrectAnswers());
      System.out.println("Correct Answer: " + result.getCorrectAnswer());

    } else {
      System.out.println("No quiz questions found in the response.");
    }
  }

  public void addToScore(int points) {
    score += points;
  }

  public int getScore() {
    return score;
  }
}