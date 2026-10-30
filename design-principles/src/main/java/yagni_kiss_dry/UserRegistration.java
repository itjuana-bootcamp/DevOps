package yagni_kiss_dry;

import java.util.ArrayList;
import java.util.HashMap;

public class UserRegistration {

    private final HashMap<UserType, ArrayList<User>> users = new HashMap<>();

    public UserRegistration() {
        users.put(UserType.STUDENT, new ArrayList<>());
        users.put(UserType.PROFESSOR, new ArrayList<>());
        users.put(UserType.ADMIN, new ArrayList<>());
    }

    public ArrayList<User> getStudents() {
        return users.get(UserType.STUDENT);
    }

    public ArrayList<User> getProfessors() {
        return users.get(UserType.PROFESSOR);
    }

    public ArrayList<User> getAdmins() {
        return users.get(UserType.ADMIN);
    }

    public void registerStudent(String name, String email) {
        User user = new User(name, email, "");
        users.get(UserType.STUDENT).add(user);
    }

    public void registerProfessor(String name, String email) {
        User user = new User(name, email, "");
        users.get(UserType.PROFESSOR).add(user);
    }

    public void registerAdmin(String name, String email) {
        User user = new User(name, email, "");
        users.get(UserType.ADMIN).add(user);
    }
}
