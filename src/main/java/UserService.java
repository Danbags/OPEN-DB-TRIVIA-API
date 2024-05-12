/**
 * This class represents a service for user-related operations.
 * It provides methods for user signup and login.
 */
public class UserService {
    /**
     * The database service instance used for database operations.
     */
    private DatabaseService databaseService;

    /**
     * Constructs a new UserService object with the specified database service.
     * 
     * @param databaseService The database service instance.
     */
    public UserService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    /**
     * Registers a new user with the provided username and password.
     * 
     * @param username The username of the new user.
     * @param password The password of the new user.
     */
    public void signup(String username, String password) {
        databaseService.addUser(username, password);
    }

    /**
     * Authenticates a user with the provided username and password.
     * 
     * @param username The username of the user.
     * @param password The password of the user.
     * @return True if the user is authenticated, otherwise false.
     */
    public boolean login(String username, String password) {
        return databaseService.checkLogin(username, password);
    }
}