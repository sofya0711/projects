package AuthorBook;

import java.util.Scanner;

public class AuthorBookTest {

    static Scanner scanner = new Scanner(System.in);
    static AuthorStorage authorStorage = new AuthorStorage();
    static BookStorage bookStorage = new BookStorage();

    private static final String EXIT = "0";
    private static final String ADD_AUTHOR = "1";
    private static final String ADD_BOOK = "2";
    private static final String SEARCH_AUTHORS = "3";
    private static final String SEARCH_AUTHORS_BY_AGE = "4";
    private static final String SEARCH_BOOKS_BY_TITLE = "5";
    private static final String SEARCH_BOOKS_BY_AUTHOR = "6";
    private static final String PRINT_AUTHORS = "7";
    private static final String PRINT_BOOKS = "8";
    private static final String COUNT_BOOKS_BY_AUTHOR = "9";
    private static final String CHANGE_AUTHOR = "10";
    private static final String CHANGE_BOOK_AUTHOR = "11";
    private static final String DELETE_BY_AUTHOR = "12";
    private static final String DELETE_AUTHOR = "13";
    private static final String DELETE_BOOK = "14";

    public static void main(String[] args) {

        authorStorage.add(new Author("poxos", "poxosyan", 20, "poxos@mail.ru", "male"));
        authorStorage.add(new Author("petros", "petrosyan", 35, "petros@mail.ru", "male"));
        authorStorage.add(new Author("ani", "poxosyan", 24, "ani@mail.ru", "female"));

        boolean isRun = true;
        while (isRun) {
            printCommands();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case ADD_AUTHOR:
                    addAuthor();
                    break;
                case ADD_BOOK:
                    addBook();
                    break;
                case SEARCH_AUTHORS:
                    System.out.println("Please input Authors Name or Surname");
                    String keyword = scanner.nextLine();
                    authorStorage.searchByName(keyword);
                    break;
                case SEARCH_AUTHORS_BY_AGE:
                    searchByAge();
                    break;
                case SEARCH_BOOKS_BY_TITLE:
                    searchBooksByTitle();
                    break;
                case SEARCH_BOOKS_BY_AUTHOR:
                    searchBookByAuthor();
                    break;
                case PRINT_AUTHORS:
                    authorStorage.print();
                    break;
                case PRINT_BOOKS:
                    bookStorage.print();
                    break;
                case COUNT_BOOKS_BY_AUTHOR: //-
                    countBooksByAuthor();
                    break;
                case CHANGE_AUTHOR:
                    changeAuthor();
                    break;
                case CHANGE_BOOK_AUTHOR:
                    changeBookAuthor();
                    break;
                case DELETE_BY_AUTHOR:
                    deleteByAuthor();
                    break;
                case DELETE_AUTHOR:
                    deleteAuthor();
                    break;
                case DELETE_BOOK:
                    deleteBook();
                    break;
                default:
                    System.err.println("INVALID COMMAND!!!");
            }
        }
    }


    private static void deleteBook() {
        System.out.println("\033[1;30m" + "Please input Book's Title for removing the book");
        String title = scanner.nextLine();

        if (title != null) {
            Book book = bookStorage.deleteBookByTitle(title);
            System.out.println("Book was deleted");
        } else {
            System.err.println("Book does not exist");
        }
    }

    private static void deleteAuthor() {
        System.out.println("\033[1;30m" + "Please input Book's Author's email for removing Author");
        String email = scanner.nextLine();

        if (email != null) {
            Author author = authorStorage.deleteAuthorByEmail(email);
            System.out.println("Author was deleted");
        } else {
            System.err.println("Author does not exist");
        }
    }

    private static void deleteByAuthor() {
        System.out.println("\033[1;30m" + "Please input Book's Author's email for delete All Books ");
        String authorEmail = scanner.nextLine();
        Author email = authorStorage.getByEmail(authorEmail);
        if (email != null) {
            bookStorage.deleteBookByAuthor(email);
            System.out.println("Books were deleted");
        } else {
            System.err.println("Author's email does not exist");
        }
    }

    private static void changeBookAuthor() {
        System.out.println("\033[1;30m" + "Please input Book's Title");
        String title = scanner.nextLine();
        Book book = bookStorage.getByTitle(title);
        if (title != null) {
            System.out.println("Please choose new Authors email");
            authorStorage.print();
            String email = scanner.nextLine();
            Author newAuthor = authorStorage.getByEmail(email);
            if (newAuthor != null) {
                book.setAuthor(authorStorage.getByEmail(email));
                System.out.println("Books author was changed" + "\033[1;30m");
            } else {
                System.err.println("Email was wrong, please try again");
            }
        } else {
            System.err.println("Title was wrong");
        }
    }

    private static void changeAuthor() {
        System.out.println("\033[1;30m" + "Please input Author's email");
        String email = scanner.nextLine();
        Author author = authorStorage.getByEmail(email);
        if (author != null) {
            System.out.println("Please input Author Name ");
            String name = scanner.nextLine();
            System.out.println("Please input Author Surname ");
            String surname = scanner.nextLine();
            System.out.println("Please input Author age ");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.println("Please input Author Gender");
            String gender = scanner.nextLine();
            Author newAuthor = authorStorage.getByEmail(email);
            if (author != null) {
                author.setName(name);
                author.setSurname(surname);
                author.setAge(age);
                author.setGender(gender);
                System.out.println("Author was changed" + "\033[1;30m");
            } else {
                System.err.println("Something goes wrong, Please try again!!");
            }
        } else {
            System.err.println("Author doesn't exist, please try again");
        }
    }

    private static void countBooksByAuthor() {
        System.out.println("\033[1;30m" + "Please input Book's Author's email");
        String authorEmail = scanner.nextLine();
        Author email = authorStorage.getByEmail(authorEmail);
        if (email != null) {
            bookStorage.countBooksByAuthor(email);
        } else {
            System.err.println("Author does not exist!Pleas try again");
        }
    }

    private static void searchBookByAuthor() {
        System.out.println("Please input Book's Author's email");
        String authorEmail = scanner.nextLine();
        Author email = authorStorage.getByEmail(authorEmail);
        if (email != null) {
            bookStorage.searchByAuthorEmail(email);
        } else {
            System.err.println("Author does not exist");
        }
    }

    private static void searchBooksByTitle() {
        System.out.println("Please input Book's title");
        String keyword = scanner.nextLine();
        bookStorage.searchByTitle(keyword);
    }

    private static void searchByAge() {
        System.out.println("\033[1;30m" + "Please input min age");
        int minAge = Integer.parseInt(scanner.nextLine());
        System.out.println("Please input max age" + "\033[1;30m");
        int maxAge = Integer.parseInt(scanner.nextLine());
        authorStorage.searchByAge(minAge, maxAge);
    }

    private static void addBook() {
        System.out.println("Please choose author's email");
        System.out.println("------");
        authorStorage.print();
        System.out.println("------");
        String email = scanner.nextLine();
        Author author = authorStorage.getByEmail(email);

        if (author != null) {
            System.out.println("\033[1;30m" + "Please input book's title");
            String title = scanner.nextLine();
            System.out.println("Please input book's description");
            String desc = scanner.nextLine();
            System.out.println("Please input book's price");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.println("please input book's count" + "\033[1;30m");
            int count = Integer.parseInt(scanner.nextLine());

            Book book = new Book(title, desc, price, count, author);

            bookStorage.add(book);

            System.out.println("\033[1;30m" + "Thank you, Book was added" + "\033[1;30m");
        } else {
            System.err.println("Invalid email!! Please try again");
            addBook();
        }
    }

    private static void addAuthor() {
        System.out.println("\033[1;30m" + "Please input Author's Name" + "\033[1;30m");
        String name = scanner.nextLine();
        System.out.println("\033[1;30m" + "Please input Author's Surname" + "\033[1;30m");
        String surname = scanner.nextLine();
        System.out.println("\033[1;30m" + "Please input Author's Age" + "\033[1;30m");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("\033[1;30m" + "Please input Author's email" + "\033[1;30m");
        String email = scanner.nextLine();
        System.out.println("\033[1;30m" + "Please input Author's Gender" + "\033[1;30m");
        String gender = scanner.nextLine();

        Author author = new Author(name, surname, age, email, gender);
        if (authorStorage.getByEmail(author.getEmail()) != null) {
            System.err.println("Invalid email, Author with this email already exist, please try again!");
        } else {
            authorStorage.add(author);
            System.out.println("\033[1;30m" + "Thank you, author was added" + "\033[1;30m");
        }
    }

    private static void printCommands() {
        System.out.println("\033[0;34m" + "Please Input " + EXIT + " for exit!");
        System.out.println("Please Input " + ADD_AUTHOR + " for add author!");
        System.out.println("Please Input " + ADD_BOOK + " for add book!");
        System.out.println("Please Input " + SEARCH_AUTHORS + " for search authors!");
        System.out.println("Please Input " + SEARCH_AUTHORS_BY_AGE + " for search authors by age!");
        System.out.println("Please Input " + SEARCH_BOOKS_BY_TITLE + " for search book by title!");
        System.out.println("Please Input " + SEARCH_BOOKS_BY_AUTHOR + " for search books by author!");
        System.out.println("Please Input " + PRINT_AUTHORS + " for print authors!");
        System.out.println("Please Input " + PRINT_BOOKS + " for print books!");
        System.out.println("Please Input " + COUNT_BOOKS_BY_AUTHOR + " for count books by author!");
        System.out.println("Please Input " + CHANGE_AUTHOR + " for change author!");
        System.out.println("Please Input " + CHANGE_BOOK_AUTHOR + " for change book by author!");
        System.out.println("Please Input " + DELETE_BY_AUTHOR + " for delete by author!");
        System.out.println("Please Input " + DELETE_AUTHOR + " for delete author!");
        System.out.println("Please Input " + DELETE_BOOK + " for delete book!" + "\033[0;34m");
    }
}
