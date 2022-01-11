package education.storage;

import education.model.Student;
import education.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class StudentStorage {

    private List<Student> students = new ArrayList<>();

    public void add(Student student) {
        students.add(student);
        serialize();
    }

    private void serialize() {
        FileUtil.deserializeStudents(students);
    }


    public void print() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void printByLesson(String name) {
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                if (students[i].getLesson().equals(name)) ;
//                System.out.println(students[i]);
//            }
//
//        }
    }


    public Student deleteStudentByEmail(String email) {
        for (Student student : students) {
            if (student.getEmail().equals(email)) {
                students.remove(student);
            }
        }
        serialize();
        return null;
    }

//    public void deleteStudentByLesson(Lesson name) {
//        for (int i = 0; i < size; i++) {
//            if (students[i].getLesson().equals(name)) {
//                deleteByIndex(i);
//            }
//        }
//    }
}
