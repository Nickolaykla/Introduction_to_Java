package tasks.task1.models;

public class Book {
    private static int bookID;
    private int id;
    private BookType type;
    private String author;
    private String bookName;
    private int pages;

    public Book(BookType type, String author, String bookName, int pages) {
        if (type != null && author != null && bookName != null && pages > 0) {
            this.id = bookID++;
            this.type = type;
            this.author = author;
            this.bookName = bookName;
            this.pages = pages;
        } else {
            throw new IllegalArgumentException("Заданы некорректные данные");
        }
    }

    public Book(String author, String bookName) {
        if (author != null && bookName != null) {
            this.author = author;
            this.bookName = bookName;
        } else {
            throw new IllegalArgumentException("Заданы некорректные данные");
        }
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author != null) {
            this.author = author;
        } else {
            throw new IllegalArgumentException("Задано некорректное имя автора");
        }
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        if (bookName != null) {
            this.bookName = bookName;
        } else {
            throw new IllegalArgumentException("Задано неверное название книги.");
        }
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        if (pages > 0) {
            this.pages = pages;
        } else {
            throw new IllegalArgumentException("Задано неверное количество страниц.");
        }
    }

    public BookType getType() {
        return type;
    }

    public void setType(BookType type) {
        if (type != null) {
            this.type = type;
        } else {
            throw new IllegalArgumentException("Задан неверный тип книги.");
        }
    }

    @Override
    public int hashCode() {
        int result = bookName.hashCode();
        result = 31 * result + author.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;

        if(obj == null || getClass() != obj.getClass()) return false;

        Book book = (Book) obj;

        return bookName.equals(book.bookName) && author.equals(book.author);
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ' ' +
                "type=" + type +
                ", author='" + author + '\'' +
                ", bookName='" + bookName + '\'' +
                ", pages=" + pages +
                '}';
    }
}