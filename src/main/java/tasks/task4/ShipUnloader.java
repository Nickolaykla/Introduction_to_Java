package tasks.task4;

import java.util.concurrent.Semaphore;

public class ShipUnloader implements Runnable {
    Ship ship;
    Semaphore sem;

    public ShipUnloader(Semaphore sem, Ship ship) {
        if (sem != null && ship != null) {
            this.sem = sem;
            this.ship = ship;
            new Thread(this).start();
        } else throw new IllegalArgumentException("Некорректные данные");
    }
    @Override
    public void run() {
        unloadShip();
    }

    public void unloadShip() {
        int freeSpace = Port.getMaxPortCapacity() - Port.getCurrentPortCapacity();
        if (freeSpace > ship.getCurrentShipCapacity()) {
            try {
                sem.acquire();
                System.out.println(ship.getName() + " корабль прибыл в порт для разгрузки.");
                Thread.sleep(2000);
                System.out.println(ship.getName() + " корабль выгрузил " + ship.getCurrentShipCapacity() +
                        " контейнеров и покинул порт.");
                Port.setCurrentPortCapacity(Port.getCurrentPortCapacity() + ship.getCurrentShipCapacity());
                System.out.println("Текущая загрузка порта = " + Port.getCurrentPortCapacity());
                sem.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
