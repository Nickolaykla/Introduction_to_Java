package basics_of_oop.task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
Дракон и его сокровища. Создать программу, позволяющую обрабатывать сведения о 100 сокровищах в пещере дракона.
Реализовать возможность просмотра сокровищ, выбора самого дорогого по стоимость сокровища и выбора сокровищ на
заданную сумму.
*/

public class DragonCave {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static BufferedReader getReader() {
        return READER;
    }

    // добавляем сокровище
    public void addTreasure(List<Treasure> list, Treasure treasure) {
        list.add(treasure);
    }

    // удаляем сокровище
    public void deleteTreasure(List<Treasure> list, int index) {
        list.remove(index - 1);
    }

    // Выводим список всех сокровищ
    public void viewAllTreasures(List<Treasure> list) {
        list.forEach(System.out::println);
    }

    //Получаем самое дорогое сокровище
    public Optional<Treasure> getMostExpensiveTreasure(List<Treasure> list) {
        return list.stream()
                .max(Comparator.comparingDouble(Treasure::getPrice));
    }

    // Получаем список случайных сокровищ на заданную сумму(или меньшую сумму)
    public Set<Treasure> getTreasuresByPrice(List<Treasure> list, double price) {
        Set<Treasure> treasures = new HashSet<>();
        double sum = 0;
        while (sum < price) {
            int i = (int) (Math.random() * list.size());
            sum += list.get(i).getPrice();
            if (sum > price) {
                sum -= list.get(i).getPrice();
            } else {
                treasures.add(list.get(i));
            }
        }
        return treasures;
    }

    // выбор сокровищ на указанную сумму
    public Set<Treasure> makeYourChoice(List<Treasure> list, double sum) throws IOException {
        Set<Treasure> set = new HashSet<>();
        int id;
        while (sum > 0) {
            System.out.println("Введите id сокровищ, для выхода введите '0'.");
            id = Integer.parseInt(getReader().readLine());
            if(id == 0) {
                break;
            }

            if(sum >= list.get(id-1).getPrice()) {
                if(set.add(list.get(id - 1))) {
                    sum -= list.get(id - 1).getPrice();
                    System.out.println("Остаток на счёте " + sum);
                } else System.out.println("Сокровище уже выбрано, выберите другое");
            } else System.out.println("Недостаточно средств, выберите другое сокровище.");
        }
        return set;
    }
}