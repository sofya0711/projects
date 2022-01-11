package education.model;

import education.util.DateUtil;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Student implements Serializable {

    private String name;
    private String surname;
    private int age;
    private String email;
    private String phone;
    private Lesson lesson;
    private Date registeredDate;

    public Student(String name, String surname, int age, String email, String phone, Lesson lesson, Date registeredDate) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.lesson = lesson;
        this.registeredDate = registeredDate;
    }

    public Student() {
    }

    public Student(String poxos, String poxosyan, int age, String email, String phone, Lesson lesson, String s) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name) && Objects.equals(surname, student.surname) && Objects.equals(email, student.email) && Objects.equals(phone, student.phone) && Objects.equals(lesson, student.lesson) && Objects.equals(registeredDate, student.registeredDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, email, phone, lesson, registeredDate);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", lesson=" + lesson +
                ", registeredDate=" + DateUtil.dateToString(registeredDate) +
                '}';
    }
}
