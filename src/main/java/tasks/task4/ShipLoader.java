package tasks.task4;

import java.util.concurrent.Semaphore;

import static tasks.task4.Main.ships;

public class ShipLoader implements Runnable {
    //    Ship ship;
    Semaphore sem;

    public ShipLoader(Semaphore sem) {
        this.sem = sem;
//        this.ship = ship;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (Ship ship : ships) {
            int canLoad = ship.getMaxShipCapacity() - ship.getCurrentShipCapacity();
            if (canLoad > 0 && Port.getCurrentPortCapacity() > canLoad) {
                try {
                    sem.acquire();
                    System.out.println(ship.getName() + " прибыл в порт");
                    Thread.sleep(2000);
                    Port.setCurrentPortCapacity(Port.getCurrentPortCapacity() - canLoad);
                    ship.setCurrentShipCapacity(ship.getMaxShipCapacity());
                    System.out.println("Загруженность порта " + Port.getCurrentPortCapacity());
                    sem.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
