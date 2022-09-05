package programming_with_classes.task9;
/*
Создать класс Book, спецификация которого приведена ниже. Определить конструкторы, set и get методы и
метод toString(). Создать второй класс, агрегирующий массив типа Book, с подходящими конструкторами и
методами. Задать критерии выбора данных и вывести эти данные на консоль.
Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
Найти и вывести:
а)список книг заданного автора;
б)список книг, выпущенных заданным издательством
в) список книг, выпущенных после заданного года.
* */
public class Book {
    private int id;
    private String name;
    private String author;
    private String publisher;
    private int yearOfPublish;
    private int pages;
    private double price;
    private String cover;

    public Book(int id, String name, String author, String publisher, int yearOfPublish, int pages, double price, String cover) {
        if (id >= 0 && name != null && author != null && publisher != null
            && yearOfPublish > 0 && pages > 0 && price > 0 && cover != null) {
            this.id = id;
            this.name = name;
            this.author = author;
            this.publisher = publisher;
            this.yearOfPublish = yearOfPublish;
            this.pages = pages;
            this.price = price;
            this.cover = cover;
        } else {
            System.out.println("Заданы некорректные данные");
            throw new IllegalArgumentException();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        }
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (!author.isEmpty()) {
            this.author = author;
        }
    }
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        if (!publisher.isEmpty()) {
            this.publisher = publisher;
        }
    }
    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public void setYearOfPublish(int yearOfPublish) {
        this.yearOfPublish = yearOfPublish;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        if (!cover.isEmpty()) {
            this.cover = cover;
        }
    }
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", yearOfPublish=" + yearOfPublish +
                ", pages=" + pages +
                ", price=" + price +
                ", cover='" + cover + '\'' +
                '}';
    }
}
