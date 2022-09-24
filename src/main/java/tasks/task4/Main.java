package tasks.task4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

import static tasks.task4.Point.*;

public class Main {
    public static List<Ship> ships = new ArrayList<>();

    public static void main(String[] args) {
        Port port1 = new Port("FirstPort", 50, 2, 10);
        int jettyCount = port1.getJettyCount();

        Semaphore s = new Semaphore(jettyCount);
        Ship ship1 = new Ship("Ship 1", 5, 20, LOAD);
        Ship ship2 = new Ship("Ship 2", 2, 15, UNLOAD);
        Ship ship3 = new Ship("Ship 3", 4, 12, LOAD);
        Ship ship4 = new Ship("Ship 4", 1, 9, UNLOAD);
        Ship ship5 = new Ship("Ship 5", 3, 11, LOAD);

        Collections.addAll(ships, ship1, ship2, ship3, ship4, ship5);

        System.out.println("Текущая загруженность порта = " + port1.getCurrentPortCapacity());
        System.out.println("Количество причалов = " + port1.getJettyCount());

        for (Ship ship : ships) {
            if (ship.getPoint().equals(LOAD)) {
                new ShipLoader(s, ship, port1);
            } else new ShipUnloader(s, ship, port1);
        }
    }
}