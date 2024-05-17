import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * This class represents a quiz consisting of a response code and a list of results.
 * It is used for deserializing JSON responses from the Open Trivia Database API.
 */
public class Quiz {
  /**
   * The response code from the API.
   * A value of 0 indicates a successful response.
   */
  @SerializedName("response_code")
  @Expose
  private Integer responseCode;

  /**
   * The list of quiz questions (results) from the API.
   */
  @SerializedName("results")
  @Expose
  private List<Result> results;

  /**
   * Gets the response code from the API.
   * 
   * @return The response code.
   */
  public Integer getResponseCode() {
    return responseCode;
  }

  /**
   * Sets the response code.
   * 
   * @param responseCode The response code to set.
   */
  public void setResponseCode(Integer responseCode) {
    this.responseCode = responseCode;
  }

  /**
   * Gets the list of quiz questions (results).
   * 
   * @return The list of results.
   */
  public List<Result> getResults() {
    return results;
  }

  /**
   * Sets the list of quiz questions (results).
   * 
   * @param results The list of results to set.
   */
  public void setResults(List<Result> results) {
    this.results = results;
  }
}
