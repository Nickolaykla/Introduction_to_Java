package tasks.task4;

import java.util.concurrent.Semaphore;

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
        int freeSpace = port.getMaxPortCapacity() - port.getCurrentPortCapacity();

        // если в порту есть свободное место, то выгружаемся
        try {
            if (freeSpace > ship.getCurrentShipCapacity()) {

                sem.acquire();
                System.out.println(ship.getName() + " корабль прибыл в порт для разгрузки.");
                Thread.sleep(2000);

                System.out.println(ship.getName() + " корабль выгрузил " + ship.getCurrentShipCapacity() +
                        " контейнеров и покинул порт.");
                port.setCurrentPortCapacity(port.getCurrentPortCapacity() + ship.getCurrentShipCapacity());
                System.out.println("Текущая загрузка порта = " + port.getCurrentPortCapacity());
                sem.release();
            } else {
                System.out.println("Ожидайте освобождения места");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}