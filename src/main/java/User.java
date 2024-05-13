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

    // Getters and setters for the fields...
    public String getLoginUsername() {
        return username;
    }

    public String getLoginPassword() {
        return password;
    }

    public void setUsername(String user) {
        username = user;
    }

    public void setPassword(String userpass) {
        password = userpass;
    }

}
