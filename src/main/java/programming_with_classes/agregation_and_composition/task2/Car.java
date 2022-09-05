package programming_with_classes.agregation_and_composition.task2;
/*
Создать объект класса Автомобиль, использую классы Колесо, Двигатель.
Методы: ехать, заправляться, менять колесо, вывести на консоль марку автомобиля.
* */
public class Car {
    private String name;
    private Wheel wheel;
    private Engine engine;

    public Car(String name, Engine engine, Wheel wheel) {
        this.name = name;
        this.engine = engine;
        this.wheel = wheel;
    }

    public Car() {
        this.name = "Неизвестная машина";
    }

    public void move(Car car) {
        System.out.println(car.getName() +" " + car.getEngine() + " начинает движение!");
    }

    public void fill(Car car) {
        System.out.println(car.getName() + " " + car.getEngine() + " заправляется.");
    }

    public void changeWheel(Car car) {
        System.out.println("В " + car.getName() + " " + car.getEngine() + " меняется колесо.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Wheel getWheel() {
        return wheel;
    }

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", wheel=" + wheel +
                ", engine=" + engine +
                '}';
    }
}
