package education;

import education.model.Lesson;
import education.model.Student;
import education.storage.LessonStorage;
import education.storage.StudentStorage;
import education.util.DateUtil;

import java.text.ParseException;
import java.util.Scanner;

public class StudentLessonTest implements StudentLessonCommands {

    static Scanner scanner = new Scanner(System.in);
    static LessonStorage lessonStorage = new LessonStorage();
    static StudentStorage studentStorage = new StudentStorage();


    public static void main(String[] args) throws ParseException {

        boolean isRun = true;
        while (isRun) {
            StudentLessonCommands.printCommands();
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
}
