package yagni_kiss_dry.solved;

import java.util.List;

public class App {

    public static void print(List<User> users) {
        System.out.println("========== " + users.getFirst().getType().toString() + "(" + users.size() + ") ==========");
        for (User user: users) {
            System.out.println(user);
        }
    }

    public static void main(String[] args) {
        UserRegistration registration = new UserRegistration();

        registration.register("Juan Perez", "juanito@gmail.com", UserType.STUDENT);
        registration.register("Roberto Castillo", "robert_007@gmail.com", UserType.STUDENT);
        registration.register("Luis Galindo", "lgalindo@school.gov", UserType.PROFESSOR);
        registration.register("Amelia Tapia", "amtapia@school.gov", UserType.PROFESSOR);
        registration.register("Beatriz Almanza", "balmanza@school.gov", UserType.ADMIN);
        registration.register("Veronica Ramirez", "vramirez@school.gov", UserType.STAFF);

        for(UserType type: UserType.values()) {
            App.print(registration.get(type));
        }
    }
}
