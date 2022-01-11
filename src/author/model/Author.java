package author.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Author implements Serializable {

    private String name;
    private String surname;
    private int age;
    private String email;
    private Gender gender;
    private Date dateOfBirth;

    public Author(String name, String surname, int age, String email, Gender gender, Date dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }


    public Author() {
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return age == author.age && Objects.equals(name, author.name) && Objects.equals(surname, author.surname) && Objects.equals(email, author.email) && gender == author.gender && Objects.equals(dateOfBirth, author.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, email, gender, dateOfBirth);
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
