package tasks.task4;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class ShipLoader implements Runnable {
    private Ship ship;
    private Semaphore sem;
    private Port port;

    public ShipLoader(Semaphore sem, Ship ship, Port port) {
        if (sem != null && ship != null && port != null) {
            this.sem = sem;
            this.ship = ship;
            this.port = port;
            new Thread(this).start();
        } else throw new IllegalArgumentException("Некорректные данные");
    }

    @Override
    public void run() {
        loadShip();
    }

    public void loadShip() {
        try {
            sem.acquire();
            System.out.println(ship.getName() + " прибыл в порт для загрузки.");
            Thread.sleep(2000);
            AtomicInteger canLoad = new AtomicInteger(ship.getMaxShipCapacity() - ship.getCurrentShipCapacity());
            if (canLoad.get() > 0 && port.getCurrentPortCapacity() > 0) {

                // если текущее количество контейнеров в порту меньше, чем может загрузить корабль
                // загружаем сколько можно загрузить
                if (canLoad.get() > port.getCurrentPortCapacity()) {
                    AtomicInteger load = new AtomicInteger(port.getCurrentPortCapacity());
                    port.setCurrentPortCapacity(0);
                    ship.setCurrentShipCapacity(ship.getCurrentShipCapacity() + load.get());
                    System.out.println(ship.getName() + " загрузил " + load +
                            " контейнеров и покинул " + port.getPortName());
                    Thread.sleep(1000);
                } else {
                    // если текущее количество контейнеров превышает вместимость корабля, то загружаем корабль полностью
                    port.setCurrentPortCapacity(port.getCurrentPortCapacity() - canLoad.get());
                    ship.setCurrentShipCapacity(ship.getMaxShipCapacity());
                    System.out.println(ship.getName() + " загрузил " + canLoad +
                            " контейнеров и покинул " + port.getPortName());
                    Thread.sleep(1000);
                }
            } else {
                System.out.println(ship.getName() + " ожидайте, склад пуст");
            }
            sem.release();
            System.out.println("Текущая загруженность порта = " + port.getCurrentPortCapacity());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}