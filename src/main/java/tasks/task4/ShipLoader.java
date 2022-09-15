package tasks.task4;

import java.util.concurrent.Semaphore;

public class ShipLoader implements Runnable {
    Ship ship;
    Semaphore sem;

    public ShipLoader(Semaphore sem, Ship ship) {
        if (sem != null && ship != null) {
            this.sem = sem;
            this.ship = ship;
            new Thread(this).start();
        } else throw new IllegalArgumentException("Некорректные данные");
    }
    @Override
    public void run() {
        loadShip();
    }

    public void loadShip() {
        try {
            int canLoad = ship.getMaxShipCapacity() - ship.getCurrentShipCapacity();
            if (canLoad > 0 && Port.getCurrentPortCapacity() > canLoad) {
                sem.acquire();
                System.out.println(ship.getName() + " корабль прибыл в порт для загрузки.");
                Thread.sleep(2000);
                System.out.println(ship.getName() + " загрузил " + canLoad + " контейнеров и покинул порт");
                Port.setCurrentPortCapacity(Port.getCurrentPortCapacity() - canLoad);
                ship.setCurrentShipCapacity(ship.getMaxShipCapacity());
                System.out.println("Текущая загруженность порта " + Port.getCurrentPortCapacity());
                sem.release();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}