package education;

public interface StudentLessonCommands {

    String EXIT = "0";
    String ADD_LESSON = "1";
    String ADD_STUDENT = "2";
    String PRINT_STUDENT = "3";
    String PRINT_STUDENT_BY_LESSON = "4";
    String PRINT_LESSON = "5";
    String DELETE_LESSON_BY_NAME = "6";
    String DELETE_STUDENT_BY_EMAIL = "7";
    String LOGIN = "1";
    String REGISTER = "2";
    String LOGOUT = "*";



    static void printCommandsForAdmins() {
        System.out.println("Please input " + EXIT + " for EXIT!");
        System.out.println("Please input " + ADD_LESSON + " for ADD LESSON!");
        System.out.println("Please input " + ADD_STUDENT + " for ADD STUDENT!");
        System.out.println("Please input " + PRINT_STUDENT + " for PRINT STUDENT!");
        System.out.println("Please input " + PRINT_STUDENT_BY_LESSON + " for PRINT STUDENT BY LESSON!");
        System.out.println("Please input " + PRINT_LESSON + " for PRINT LESSON!");
        System.out.println("Please input " + DELETE_LESSON_BY_NAME + " for DELETE LESSON!");
        System.out.println("Please input " + DELETE_STUDENT_BY_EMAIL + " for DELETE STUDENT!");
    }

    static void printCommandsForUsers() {
        System.out.println("Please input " + EXIT + " for EXIT!");
        System.out.println("Please input " + ADD_LESSON + " for ADD LESSON!");
        System.out.println("Please input " + ADD_STUDENT + " for ADD STUDENT!");
        System.out.println("Please input " + PRINT_STUDENT + " for PRINT STUDENT!");
        System.out.println("Please input " + PRINT_STUDENT_BY_LESSON + " for PRINT STUDENT BY LESSON!");
        System.out.println("Please input " + PRINT_LESSON + " for PRINT LESSON!");

    }


    static void printRegistrationCommands() {
        System.out.println("Please input " + EXIT + " for EXIT!");
        System.out.println("Please input " + LOGIN + " for sign in!");
        System.out.println("Please input " + REGISTER + " for registration!");

    }
}
