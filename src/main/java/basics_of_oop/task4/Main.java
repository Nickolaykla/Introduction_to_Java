package basics_of_oop.task4;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Treasure treasure1 = new Treasure("алмаз", 100);
        Treasure treasure2 = new Treasure("бриллиант", 150);
        Treasure treasure3 = new Treasure("золото", 50);
        Treasure treasure4 = new Treasure("серебро", 30);
        Treasure treasure5 = new Treasure("платина", 100);
        Treasure treasure6 = new Treasure("кольцо", 20);
        Treasure treasure7 = new Treasure("цепь", 25);
        Treasure treasure8 = new Treasure("браслет", 40);
        Treasure treasure9 = new Treasure("колье", 45);
        Treasure treasure10 = new Treasure("ожерелье", 70);
        Treasure treasure11 = new Treasure("бусы", 15);
        Treasure treasure12 = new Treasure("кулон", 60);
        Treasure treasure13 = new Treasure("брошь", 5);
        Treasure treasure14 = new Treasure("булавка", 5);
        Treasure treasure15 = new Treasure("запонка", 10);
        Treasure treasure16 = new Treasure("корона", 120);
        Treasure treasure17 = new Treasure("часы", 200);
        Treasure treasure18 = new Treasure("медаль", 300);
        Treasure treasure19 = new Treasure("медальон", 110);
        Treasure treasure20 = new Treasure("серьги", 90);
        Treasure treasure21 = new Treasure("брелок", 15);

        List<Treasure> treasures = new ArrayList<>();
        Collections.addAll(treasures, treasure1, treasure2, treasure3, treasure4, treasure5, treasure6, treasure7,
                treasure8, treasure9, treasure10, treasure11, treasure12, treasure13, treasure14, treasure15,
                treasure16, treasure17, treasure18, treasure19, treasure20, treasure21);

        DragonCave dragonCave = new DragonCave();
        showMenu();

        int i = -1;
        while ((i = Integer.parseInt(DragonCave.getReader().readLine())) != 0) {
            switch (i) {
                case 1:
                    System.out.println("Все сокровища:");
                    dragonCave.viewAllTreasures(treasures);
                    System.out.println();
                    showMenu();
                    break;
                case 2:
                    System.out.println("Самое дорогое сокровище:");
                    Optional<Treasure> treasure = dragonCave.getMostExpensiveTreasure(treasures);
                    treasure.ifPresent(System.out::println);
                    System.out.println();
                    showMenu();
                    break;
                case 3:
                    System.out.println("Введите сумму:");
                    double sum = Double.parseDouble(DragonCave.getReader().readLine());
                    if (sum < 0) return;
                    Set<Treasure> set = dragonCave.getTreasuresByPrice(treasures, sum);
                    set.forEach(System.out::println);
                    System.out.println();
                    showMenu();
                    break;
                case 4:
                    dragonCave.viewAllTreasures(treasures);
                    System.out.println("Введите сумму");
                    double summ = Double.parseDouble(DragonCave.getReader().readLine());
                    Set<Treasure> result = dragonCave.makeYourChoice(treasures, summ);
                    System.out.println("Выбранные сокровища:");
                    result.forEach(System.out::println);
                    showMenu();
                    break;
                default:
                    showMenu();
            }
        }
        if (DragonCave.getReader() != null) {
            DragonCave.getReader().close();
        }
    }

    public static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("'0' - выход");
        System.out.println("'1' - посмотреть все сокровища");
        System.out.println("'2' - посмотреть самое дорогое сокровище");
        System.out.println("'3' - получить случайный набор сокровищ на заданную сумму");
        System.out.println("'4' - выбрать сокровища на указанную сумму");
    }
}
