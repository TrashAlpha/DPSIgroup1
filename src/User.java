import java.util.HashMap;
import java.util.Map;

public class User {
    private static final Map<String, User> users = new HashMap<>();
    private final String username;
    private final String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static void addUser(String username, String password) {
        if (!users.containsKey(username)) {
            User newUser = new User(username, password);
            users.put(username, newUser);
        }
    }

    public static Map<String, User> getUsers() {
        return users;
    }
}
