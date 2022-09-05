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

    public void move() {
        System.out.println(this.getName() +" " + this.getEngine() + " начинает движение!");
    }

    public void fill() {
        System.out.println(this.getName() + " " + this.getEngine() + " заправляется.");
    }

    public void changeWheel() {
        System.out.println("В " + this.getName() + " " + this.getEngine() + " меняется колесо.");
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
