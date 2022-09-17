package programming_with_classes.agregation_and_composition.task2;

/*
Создать объект класса Автомобиль, использую классы Колесо, Двигатель.
Методы: ехать, заправляться, менять колесо, вывести на консоль марку автомобиля.
*/

public class Car {
    private String name;
    private Wheel wheel;
    private Engine engine;

    public Car(String name, Engine engine, Wheel wheel) {
        if (name != null && engine != null && wheel != null) {
            this.name = name;
            this.engine = engine;
            this.wheel = wheel;
        } else throw new IllegalArgumentException("Неверно заданы параметры");
    }
    public Car() {
    }

    public void move(Car car) {
        if (car != null) {
            System.out.println(car.getName() + " " + car.getEngine() + " начинает движение!");
        }
    }
    public void fill(Car car) {
        if (car != null) {
            System.out.println(car.getName() + " " + car.getEngine() + " заправляется.");
        }
    }
    public void changeWheel(Car car) {
        if (car != null) {
            System.out.println("В " + car.getName() + " " + car.getEngine() + " меняется колесо.");
        }
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    public Wheel getWheel() {
        return wheel;
    }

    public void setWheel(Wheel wheel) {
        if (wheel != null) {
            this.wheel = wheel;
        }
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        if (engine != null) {
            this.engine = engine;
        }
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