package tasks.task4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Main {
    public static List<Ship> ships = new ArrayList<>();

    public static void main(String[] args) {
        Semaphore s = new Semaphore(Port.getJettyCount());
        Ship ship1 = new Ship("1", 200, 500);
        Ship ship2 = new Ship("2", 150, 400);
        Ship ship3 = new Ship("3", 300, 450);
        Ship ship4 = new Ship("4", 150, 320);
        Ship ship5 = new Ship("5", 90, 250);

        Collections.addAll(ships, ship1, ship2, ship3, ship4, ship5);
          new ShipLoader(s);
          new ShipUnloader(s);
    }
}