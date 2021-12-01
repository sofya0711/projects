package education;

import java.util.Scanner;
import java.util.logging.SocketHandler;

public class StudentLessonTest {

    static Scanner scanner = new Scanner(System.in);
    static LessonStorage lessonStorage = new LessonStorage();
    static StudentStorage studentStorage = new StudentStorage();

    private static final String EXIT = "0";
    private static final String ADD_LESSON = "1";
    private static final String ADD_STUDENT = "2";
    private static final String PRINT_STUDENT = "3";
    private static final String PRINT_STUDENT_BY_LESSON = "4";
    private static final String PRINT_LESSON = "5";
    private static final String DELETE_LESSON_BY_NAME = "6";
    private static final String DELETE_STUDENT_BY_EMAIL = "7";

    public static void main(String[] args) {

        boolean isRun = true;
        while (isRun) {
            printCommands();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case ADD_LESSON:
                    addLesson();
                    break;
                case ADD_STUDENT:
                    addStudent();
                    break;
                case PRINT_STUDENT:
                    studentStorage.print();
                    break;
                case PRINT_STUDENT_BY_LESSON:
                    printStudentByLesson();
                    break;
                case PRINT_LESSON:
                    lessonStorage.print();
                    break;
                case DELETE_LESSON_BY_NAME:
                    deleteLessonByName();
                    break;
                case DELETE_STUDENT_BY_EMAIL:
                    deleteStudentByEmail();
                    break;
                default:
                    System.err.println("OOPS SOMETHING WENT WRONG!!! PLEASE TRY AGAIN");
            }
        }
    }


    private static void deleteStudentByEmail() {
        System.out.println("Please input Student's email");
        String email = scanner.nextLine();
        if (email != null) {
            Student student = studentStorage.deleteStudent(email);
            System.out.println("Student was deleted");
        } else {
            System.out.println("Student does not exist");
        }
    }

    private static void deleteLessonByName() {
        System.out.println("Please choose lesson");
        System.out.println("----------");
        lessonStorage.print();
        System.out.println("----------");
        String lessonName = scanner.nextLine();

        if (lessonName != null) {
            lessonStorage.deleteByName(lessonName);
            System.out.println("Lesson was removed");
        } else {
            System.err.println("Lesson does not exist, please try again");
        }
    }

    private static void printStudentByLesson() {
        System.out.println("Please choose lesson");
        System.out.println("----------");
        lessonStorage.print();
        System.out.println("----------");
        String name = scanner.nextLine();
        Lesson lesson = lessonStorage.getByName(name);

        if (lesson != null) {
            studentStorage.printByLesson(name);
        } else {
            System.err.println("Student does not exist");
        }
    }

    private static void addStudent() {
        System.out.println("Please choose lesson");
        System.out.println("----------");
        lessonStorage.print();
        System.out.println("----------");
        String name = scanner.nextLine();
        Lesson lesson = lessonStorage.getByName(name);

        if (lesson != null) {
            System.out.println("Please input Student's Name");
            String studentName = scanner.nextLine();
            System.out.println("Please input Student's Surname");
            String surname = scanner.nextLine();
            System.out.println("Please input Student's age");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.println("Please input Student's email");
            String email = scanner.nextLine();
            System.out.println("Please input Student's phone");
            String phone = scanner.nextLine();

            Student student = new Student(studentName, surname, age, email, phone, lesson);
            studentStorage.add(student);

            System.out.println("Student was Added");
        } else {
            System.err.println("Invalid ?");
            addLesson();
        }
    }


    private static void addLesson() {
        System.out.println("Please input Lesson's name,duration , Lecturer Name, price ");
        String lessonDataStr = scanner.nextLine();
        String[] lessonData = lessonDataStr.split(",");
        if (lessonData.length == 4) {
            int duration = Integer.parseInt(lessonData[1]);
            double price = Double.parseDouble(lessonData[3]);
            Lesson lesson = new Lesson(lessonData[0], duration, lessonData[1], price);

            if (lessonStorage.getByName(lesson.getName()) != null) {
                System.err.println("Lesson with this name is exist, Please try Again");
            } else {
                lessonStorage.add(lesson);
                System.out.println("Thank you!!! Lesson was added");
            }
        } else {
            System.out.println("Invalid data");
        }

//        String name = scanner.nextLine();
//        System.out.println("Please input Lesson's duration");
//        int duration = Integer.parseInt(scanner.nextLine());
//        System.out.println("Please input Lecturer Name");
//        String lecturerName = scanner.nextLine();
//        System.out.println("Please input price");
//        Double price = Double.parseDouble(scanner.nextLine());
//
//        Lesson lesson = new Lesson(name, duration, lecturerName, price);
//        if (lessonStorage.getByName(lesson.getName()) != null) {
//            System.err.println("Invalid name");
//        } else {
//            lessonStorage.add(lesson);
//            System.out.println("\033[1;30m" + "Thank you, lesson was added" + "\033[1;30m");
//        }
    }

    private static void printCommands() {
        System.out.println("Please input " + EXIT + " for EXIT!");
        System.out.println("Please input " + ADD_LESSON + " for ADD LESSON!");
        System.out.println("Please input " + ADD_STUDENT + " for ADD STUDENT!");
        System.out.println("Please input " + PRINT_STUDENT + " for PRINT STUDENT!");
        System.out.println("Please input " + PRINT_STUDENT_BY_LESSON + " for PRINT STUDENT BY LESSON!");
        System.out.println("Please input " + PRINT_LESSON + " for PRINT LESSON!");
        System.out.println("Please input " + DELETE_LESSON_BY_NAME + " for DELETE LESSON!");
        System.out.println("Please input " + DELETE_STUDENT_BY_EMAIL + " for DELETE STUDENT!");
    }
}
