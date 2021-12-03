package authorBook;

public interface AuthorBookCommands {

    String EXIT = "0";
    String ADD_AUTHOR = "1";
    String ADD_BOOK = "2";
    String SEARCH_AUTHORS = "3";
    String SEARCH_AUTHORS_BY_AGE = "4";
    String SEARCH_BOOKS_BY_TITLE = "5";
    String SEARCH_BOOKS_BY_AUTHOR = "6";
    String PRINT_AUTHORS = "7";
    String PRINT_BOOKS = "8";
    String COUNT_BOOKS_BY_AUTHOR = "9";
    String CHANGE_AUTHOR = "10";
    String CHANGE_BOOK_AUTHOR = "11";
    String DELETE_BY_AUTHOR = "12";
    String DELETE_AUTHOR = "13";
    String DELETE_BOOK = "14";

    static void printCommands() {
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
