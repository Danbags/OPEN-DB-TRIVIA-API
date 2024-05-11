public class UserService {
    private DatabaseService databaseService;

    public UserService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public void signup(String username, String password) {
        databaseService.addUser(username, password);
    }

    public boolean login(String username, String password) {
        return databaseService.checkLogin(username, password);
    }
}