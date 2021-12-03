package education.storage;

import education.model.Student;
import education.util.ArrayUtil;

public class StudentStorage {

    private Student[] students = new Student[20];
    private int size;


    public void add(Student student) {
        if (students.length == size) {
            extend();
        }
        students[size++] = student;
    }

    private void extend() {
        Student[] tmp = new Student[students.length + 20];
        System.arraycopy(students, 0, tmp, 0, students.length);
        students = tmp;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(students[i]);
        }
    }

    public void printByLesson(String name) {
        for (int i = 0; i < size; i++) {
            if (students[i].getLesson().equals(name)) ;
            System.out.println(students[i]);
        }
    }


    public Student deleteStudent(String email) {
        for (int i = 0; i < size; i++) {
            if (students[i].getEmail().equals(email)) {
                ArrayUtil.deleteByIndex(students, i, size);
                size--;
            }
        }
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
