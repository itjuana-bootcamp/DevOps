package yagni_kiss_dry;

public class App {

    public static void main(String[] args) {
        UserRegistration registration = new UserRegistration();

        registration.registerStudent("Juan Perez", "juanito@gmail.com");
        registration.registerStudent("Roberto Castillo", "robert_007@gmail.com");
        registration.registerProfessor("Luis Galindo", "lgalindo@school.gov");
        registration.registerProfessor("Amelia Tapia", "amtapia@school.gov");
        registration.registerAdmin("Beatriz Almanza", "balmanza@school.gov");

        System.out.println("========== STUDENTS (" + registration.getStudents().size() + ") ==========");
        for (User user: registration.getStudents()) {
            System.out.println(user);
        }

        System.out.println("========== PROFESSOR (" + registration.getProfessors().size() + ") ==========");
        for (User user: registration.getProfessors()) {
            System.out.println(user);
        }

        System.out.println("========== ADMINS (" + registration.getAdmins().size() + ") ==========");
        for (User user: registration.getAdmins()) {
            System.out.println(user);
        }
    }
}
