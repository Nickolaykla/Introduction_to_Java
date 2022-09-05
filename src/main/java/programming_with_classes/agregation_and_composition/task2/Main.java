package programming_with_classes.agregation_and_composition.task2;

public class Main {
    public static void main(String[] args) {
        Engine audi100Engine = new Engine(2.2);
        Wheel wheels = new Wheel("Continental");
        Car audi = new Car("Audi 100", audi100Engine, wheels);

        Engine bmwEngine = new Engine(2.9);
        Wheel bmwwheels = new Wheel("Michelin");
        Car bmw = new Car("BMW E38", bmwEngine, bmwwheels);

        System.out.println(bmw);
        System.out.println(audi);

        audi.move();
        bmw.move();

        audi.fill();
        bmw.fill();

        audi.changeWheel();
        bmw.changeWheel();
        System.out.println(bmw.getName());
        System.out.println(audi.getName());
    }
}
