package authorBook;

import authorBook.model.Author;
import authorBook.model.Book;
import authorBook.storage.AuthorStorage;
import authorBook.storage.BookStorage;
import authorBook.util.DateUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class AuthorBookTest implements AuthorBookCommands {

    static Scanner scanner = new Scanner(System.in);
    static AuthorStorage authorStorage = new AuthorStorage();
    static BookStorage bookStorage = new BookStorage();

    public static void main(String[] args) throws ParseException {

        authorStorage.add(new Author("poxos", "poxosyan", 20, "poxos@mail.ru", "male", DateUtil.stringToDate("12/10/1996")));
        authorStorage.add(new Author("petros", "petrosyan", 35, "petros@mail.ru", "male", DateUtil.stringToDate("02/11/1993")));
        authorStorage.add(new Author("ani", "poxosyan", 24, "ani@mail.ru", "female", DateUtil.stringToDate("21/05/1999")));

        boolean isRun = true;
        while (isRun) {
            AuthorBookCommands.printCommands();
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
        System.out.println("please choose book by title");
        System.out.println("--------");
        bookStorage.print();
        System.out.println("--------");
        String title = scanner.nextLine();
        Book book = bookStorage.getByTitle(title);
        if (title != null) {
            bookStorage.deleteBookByTitle(book);
        } else {
            System.err.println("Book with this title does not exists");
        }
    }

    private static void deleteAuthor() {
        System.out.println("\033[1;30m" + "Please input Book's Author's email for removing Author");
        String email = scanner.nextLine();
        Author author = authorStorage.getByEmail(email);
        if (email != null) {
            authorStorage.deleteAuthorByEmail(author);
            System.out.println("Author was deleted");
        } else {
            System.err.println("Author does not exist");
        }
    }

    private static void deleteByAuthor() {
        System.out.println("\033[1;30m" + "Please input Book's Author's email for delete All Books ");
        String authorEmail = scanner.nextLine();
        Author author = authorStorage.getByEmail(authorEmail);
        if (author != null) {
            bookStorage.deleteBookByAuthor(author);
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

    private static void addAuthor() throws ParseException {
        System.out.println("please input author's name,surname,email,gender,age,dateOfBirth[12/12/2021]");
        String authorDataStr = scanner.nextLine();
        String[] authorData = authorDataStr.split(",");
        if (authorData.length == 6) {
            int age = Integer.parseInt(authorData[4]);
            Date date = DateUtil.stringToDate(authorData[5]);
            Author author = new Author(authorData[0], authorData[1], age, authorData[2], authorData[3], date);

            if (authorStorage.getByEmail(author.getEmail()) != null) {
                System.err.println("Invalid email. Author with this email already exists");
            } else {
                authorStorage.add(author);
                System.out.println("Thank you, author was added");
            }
        } else {
            System.err.println("invalid data");
        }
    }
}
