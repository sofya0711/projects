package education;

import education.model.Lesson;
import education.model.Student;
import education.model.User;
import education.model.UserType;
import education.storage.LessonStorage;
import education.storage.StudentStorage;
import education.storage.UserStorage;
import education.util.DateUtil;

import java.text.ParseException;
import java.util.Scanner;


public class StudentLessonTest implements StudentLessonCommands {

    static Scanner scanner = new Scanner(System.in);
    static LessonStorage lessonStorage = new LessonStorage();
    static StudentStorage studentStorage = new StudentStorage();
    static UserStorage userStorage = new UserStorage();

    Lesson lesson = new Lesson("English", 90, "Ani", 25000);
    Lesson lesson1 = new Lesson("Russian", 90, "Aram", 25000);

    Student student = new Student("poxos", "poxosyan", 22, "poxos@mail.ru", "123666", lesson, "11.12.2021");
    Student student1 = new Student("petros", "petrosyan", 25, "petros@mail.ru", "123666", lesson1, "11.12.2021");
    Student student2 = new Student("gexam", "gexamyan", 28, "gexam@mail.ru", "123666", lesson, "11.12.2021");
    Student student3 = new Student("mary", "poxosyan", 20, "mary@mail.ru", "123666", lesson1, "11.12.2021");

    public static void main(String[] args) throws ParseException {


        boolean isRun = true;

        while (isRun) {
            StudentLessonCommands.printRegistrationCommands();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case LOGIN:
                    login();
                    break;
                case REGISTER:
                    register();
                    break;
                default:
                    System.err.println("OOPS SOMETHING WENT WRONG!!! PLEASE TRY AGAIN");
            }
        }
    }

    private static void register() throws ParseException {
        System.out.println("Please input your name");
        String name = scanner.nextLine();
        System.out.println("Please input your surname");
        String surname = scanner.nextLine();
        System.out.println("Please input your type");
        String type = scanner.nextLine();
        System.out.println("Please input your phone");
        String phone = scanner.nextLine();
        System.out.println("Please input your email");
        String email = scanner.nextLine();
        System.out.println("Please input your password");
        String password = scanner.nextLine();

        if (email != null) {
            User user = new User(name, surname, UserType.valueOf(type.toUpperCase()), phone, email, password);
            userStorage.add(user);
            System.out.println("You have successfully registered!!!");
            login();
        } else {
            System.err.println("User with this email is exists, please try again");
        }
    }

    private static void login() throws ParseException {
        System.out.println("Please input your email");
        String email = scanner.nextLine();
        System.out.println("Please input your password");
        String password = scanner.nextLine();
        System.out.println("Please input your type");
        String type = scanner.nextLine();
        User user = userStorage.getByEmail(email);

        if (user != null) {
            boolean isRun = true;
            if (type.equalsIgnoreCase("user")) {
                while (isRun) {
                    StudentLessonCommands.printCommandsForUsers();
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
                        default:
                            System.err.println("OOPS SOMETHING WENT WRONG!!! PLEASE TRY AGAIN");
                    }
                }
            } else {
                while (isRun) {
                    StudentLessonCommands.printCommandsForAdmins();
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
        } else {
            System.err.println("Wrong email or password, please try again");
        }

    }


    private static void deleteStudentByEmail() {
        System.out.println("Please input Student's email");
        String email = scanner.nextLine();
        if (email != null) {
            Student student = studentStorage.deleteStudentByEmail(email);
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

    private static void addStudent() throws ParseException {
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
            System.out.println("Please input date of registered [12.12.2012]");
            String dateOfRegistered = scanner.nextLine();

            Student student = new Student(studentName, surname, age, email, phone, lesson, DateUtil.stringToDate(dateOfRegistered));
            studentStorage.add(student);

            System.out.println("Student was Added");
        } else {
            System.err.println("Student was not added");
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
    }
}
