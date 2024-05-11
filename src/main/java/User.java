import java.util.Scanner;

public class User  {

    private String username;
    private String password;
    private Scanner scan;

    public String getLoginUsername() {
        return username;
    }

    public String getLoginPassword() {
        return password;
    }

    public void setUsername(String user)     {
        username = user;
    }

    public void setPassword(String userpass) {
        password = userpass;
    }

}
