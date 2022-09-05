

public class Book {
    private final String nameBook;
    private final String author;
    private final int pagesCount;
    private final String isbn;

    public Book(String nameBook, String author, int pagesCount, String isbn) {
        this.nameBook = nameBook;
        this.author = author;
        this.pagesCount = pagesCount;
        this.isbn = isbn;
    }

    public String getNameBook() {
        return nameBook;
    }

    public String getAuthor() {
        return author;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public String getIsbn() {
        return isbn;
    }
}
