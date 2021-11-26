package AuthorBook;

public class BookStorage {

    private Book[] books = new Book[10];
    private int size;

    public void add(Book book) {
        if (size == books.length) {
            extend();
        }
        books[size++] = book;
    }

    private void extend() {
        Book[] tmp = new Book[books.length + 10];
        System.arraycopy(books, 0, tmp, 0, size);
        books = tmp;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println("\033[1;37m" + books[i]);
        }
    }

    public void searchByTitle(String keyword) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().contains(keyword)) {
                System.out.println(books[i]);
            }
        }
    }

    public void searchByAuthorEmail(Author email) {
        for (int i = 0; i < size; i++) {
            if (books[i].getAuthor().equals(email)) {
                System.out.println(books[i]);
            }
        }
    }

    public Book getByTitle(String title) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().equals(title)) {
                return books[i];
            }
        }
        return null;
    }

    public void countBooksByAuthor(Author email) {
        for (int i = 0; i < size; i++) {
            if (books[i].getAuthor().equals(email)) {
                System.out.println("Book's count is: " + books[i].getCount());
            }
        }
    }

    public void deleteBook(int index) {
        for (int i = index + 1; i < size; i++) {
            books[i - 1] = books[i];
        }
        size--;
    }

    public Book deleteBookByTitle(String title) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().equals(title)) {
                deleteBook(i);
            }
        }
        return null;
    }


    public void deleteBookByAuthor(Author email) {
        for (int i = 0; i < size; i++) {
            if (books[i].getAuthor().equals(email)) {
                deleteBook(i);
            }
        }
    }
}
