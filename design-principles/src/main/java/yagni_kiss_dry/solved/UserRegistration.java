package yagni_kiss_dry.solved;

import java.util.ArrayList;
import java.util.List;

public class UserRegistration {

    private final ArrayList<User> users = new ArrayList<>();

    public List<User> get(UserType type) {
        return users.stream()
                .filter(user -> user.getType() == type )
                .toList();
    }

    public void register(String name, String email, UserType type) {
        User user = new User(name, email, type);
        users.add(user);
    }
}