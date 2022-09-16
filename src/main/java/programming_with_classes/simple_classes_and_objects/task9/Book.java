package programming_with_classes.simple_classes_and_objects.task9;
/*
Создать класс Book, спецификация которого приведена ниже. Определить конструкторы, set и get методы и
метод toString(). Создать второй класс, агрегирующий массив типа Book, с подходящими конструкторами и
методами. Задать критерии выбора данных и вывести эти данные на консоль.
Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
Найти и вывести:
а)список книг заданного автора;
б)список книг, выпущенных заданным издательством
в) список книг, выпущенных после заданного года.
*/
public class Book {
    private int id;
    private String name;
    private String author;
    private String publisher;
    private int yearOfPublish;
    private int pages;
    private double price;
    private String cover;

    public Book(int id, String name, String author, String publisher,
                int yearOfPublish, int pages, double price, String cover) {

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
        } else throw new IllegalArgumentException("Неверно задано ID");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        } else throw new IllegalArgumentException("Неверно задано имя");
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (!author.isEmpty()) {
            this.author = author;
        } else throw new IllegalArgumentException("Неверно задан автор");
    }
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        if (!publisher.isEmpty()) {
            this.publisher = publisher;
        } else throw new IllegalArgumentException("Неверно задано издательство");
    }
    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public void setYearOfPublish(int yearOfPublish) {
        if (yearOfPublish > 0) {
            this.yearOfPublish = yearOfPublish;
        } else throw new IllegalArgumentException("Неверно задан год издания");
    }
    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        if (pages > 0) {
            this.pages = pages;
        } else throw new IllegalArgumentException("Неверно задано количество страниц");
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else throw new IllegalArgumentException("Неверно задана цена");
    }
    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        if (!cover.isEmpty()) {
            this.cover = cover;
        } else throw new IllegalArgumentException("Неверно задан переплёт книги");
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