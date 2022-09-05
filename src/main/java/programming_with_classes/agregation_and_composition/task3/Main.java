package programming_with_classes.agregation_and_composition.task3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        City capital = new City("Minsk", 348.8);
        Region brest = new Region("Брестская область", "Брест", 32_787, 16);
        Region minsk = new Region("Минская область", "Минск", 39_912, 22);
        Region grodno = new Region("Гродненская область", "Гродно", 25_127, 17);
        Region vitebsk = new Region("Витебская область", "Витебск", 40_051, 21);
        Region gomel = new Region("Гомельская область", "Гомель", 40_372, 21);
        Region mogilev = new Region("Могилевская область", "Могилев", 29_068, 21);

        Region[] regions = {brest, minsk, grodno, vitebsk, gomel, mogilev};

        State belarus = new State("Республика Беларусь", capital, 207_600, regions, regions.length);
        System.out.println(belarus);
        System.out.println("Столица:");
        System.out.println(belarus.getCapitalName() + "\n");

        System.out.println("Количество областей:");
        System.out.println(belarus.getRegions().length + "\n");

        System.out.println("Площадь " + belarus.getName() + " = " + belarus.getArea() + "км^2" + "\n");

        System.out.println("Областные центры:");
        Arrays.stream(regions).map(Region::getCenterName).forEach(System.out::println);

    }
}
