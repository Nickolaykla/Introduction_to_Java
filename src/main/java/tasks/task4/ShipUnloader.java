package tasks.task4;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class ShipUnloader implements Runnable {
    private Ship ship;
    private Semaphore sem;
    private Port port;

    public ShipUnloader(Semaphore sem, Ship ship, Port port) {
        if (sem != null && ship != null && port != null) {
            this.sem = sem;
            this.ship = ship;
            this.port = port;
            new Thread(this).start();
        } else throw new IllegalArgumentException("Некорректные данные");
    }

    @Override
    public void run() {
        unloadShip();
    }

    public void unloadShip() {
        // получаем количество свободных мест в порту для разгрузки
        AtomicInteger freeSpace = new AtomicInteger(port.getMaxPortCapacity() - port.getCurrentPortCapacity());

        // если в порту есть свободное место, то выгружаемся
        try {
            sem.acquire();
            System.out.println(ship.getName() + " прибыл в порт для разгрузки.");
            Thread.sleep(2000);
            if (freeSpace.get() > ship.getCurrentShipCapacity()) {
                System.out.println(ship.getName() + " выгрузил " + ship.getCurrentShipCapacity() +
                        " контейнеров и покинул " + port.getPortName());
                port.setCurrentPortCapacity(port.getCurrentPortCapacity() + ship.getCurrentShipCapacity());
                Thread.sleep(1000);

                // если мест в порту меньше, чем может выгрузить корабль, то выгружаем сколько можем
            } else if (freeSpace.get() > 0 && ship.getCurrentShipCapacity() > freeSpace.get()) {
                port.setCurrentPortCapacity(0);
                ship.setCurrentShipCapacity(ship.getCurrentShipCapacity() - freeSpace.get());
                System.out.println(ship.getName() + " выгрузил " + freeSpace + " контейнеров и покинул " +
                        port.getPortName());
                Thread.sleep(1000);

            } else {
                System.out.println(ship.getName() + " ожидайте, склад заполнен");
            }
            sem.release();
            System.out.println("Текущая загруженность порта = " + port.getCurrentPortCapacity());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}