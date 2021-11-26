package AuthorBook;

import java.util.Objects;

public class Author {

    private String name;
    private String surname;
    private int age;
    private String email;
    private String gender;

    public Author(String name, String surname, int age, String email, String gende) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.gender = gende;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gende) {
        this.gender = gende;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return age == author.age && Objects.equals(name, author.name) && Objects.equals(surname, author.surname) && Objects.equals(email, author.email) && Objects.equals(gender, author.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, email, gender);
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", gende='" + gender + '\'' +
                '}';
    }
}
