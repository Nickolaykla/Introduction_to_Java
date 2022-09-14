package tasks.task4;

import java.util.concurrent.Semaphore;

public class ShipUnloader implements Runnable {
    Semaphore sem;
    Ship ship;

    public ShipUnloader(Semaphore sem, Ship ship) {
        this.sem = sem;
        this.ship = ship;
        new Thread(this).start();
    }

    @Override
    public void run() {
       int freeSpace = Port.getMaxPortCapacity() - Port.getCurrentPortCapacity();
        if(freeSpace > ship.getCurrentShipCapacity()) {
            try {
                sem.acquire();
                System.out.println(ship.getName() + " корабль прибыл в порт");
                Thread.sleep(2000);
                System.out.println(ship.getName() + " корабль выгрузил " + ship.getCurrentShipCapacity() + " контейнеров");
                Port.setCurrentPortCapacity(Port.getCurrentPortCapacity() + ship.getCurrentShipCapacity());
                System.out.println("Текущая загрузка порта = " + Port.getCurrentPortCapacity());
                sem.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
