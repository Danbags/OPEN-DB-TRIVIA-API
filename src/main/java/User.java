import java.util.Scanner;

/**
 * This class represents a user of the application.
 * It contains information about the user such as username and password.
 */
public class User {
    /**
     * The username of the user.
     */
    private String username;

    /**
     * The password of the user.
     */
    private String password;

    /**
     * Gets the username of the user.
     * 
     * @return The username.
     */
    public String getLoginUsername() {
        return username;
    }

    /**
     * Gets the password of the user.
     * 
     * @return The password.
     */
    public String getLoginPassword() {
        return password;
    }

    /**
     * Sets the username of the user.
     * 
     * @param username The username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Sets the password of the user.
     * 
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
