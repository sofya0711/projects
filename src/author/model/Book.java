package author.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class Book implements Serializable {

    private String serialID;
    private String title;
    private String description;
    private double price;
    private int count;
    private Set<Author> authors;
    private Set<String> tags;

    public Book(String serialID, String title, String description, double price, int count, Set<Author> authors, Set<String> tags) {
        this.serialID = serialID;
        this.title = title;
        this.description = description;
        this.price = price;
        this.count = count;
        this.authors = authors;
        this.tags = tags;
    }

    public Book() {
    }

    public String getSerialID() {
        return serialID;
    }

    public void setSerialID(String serialID) {
        this.serialID = serialID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Double.compare(book.price, price) == 0 && count == book.count && Objects.equals(serialID, book.serialID) && Objects.equals(title, book.title) && Objects.equals(description, book.description) && Objects.equals(authors, book.authors) && Objects.equals(tags, book.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialID, title, description, price, count, authors, tags);
    }

    @Override
    public String toString() {
        return "Book{" +
                "serialID='" + serialID + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", authors=" + authors +
                ", tags=" + tags +
                '}';
    }
}
