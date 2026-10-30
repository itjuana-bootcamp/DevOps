package yagni_kiss_dry.solved;

public class User {

    private String name;
    private String email;
    private UserType type;

    public User(String name, String email, UserType type) {
        this.name = name;
        this.email = email;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public UserType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "----- User -----\n" + name + "\n" + email + "\n---------------";
    }
}