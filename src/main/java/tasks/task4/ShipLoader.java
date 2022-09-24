package tasks.task4;

import java.util.concurrent.Semaphore;

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
            int canLoad = ship.getMaxShipCapacity() - ship.getCurrentShipCapacity();
            if (canLoad > 0 && port.getCurrentPortCapacity() > 0) {

                System.out.println(ship.getName() + " корабль прибыл в порт для загрузки.");
                Thread.sleep(2000);

                // если текущее количество контейнеров в порту меньше, чем может загрузить корабль
                // загружаем сколько можно загрузить
                if(canLoad > port.getCurrentPortCapacity()) {
                    int load =  port.getCurrentPortCapacity();
                    port.setCurrentPortCapacity(0);
                    ship.setCurrentShipCapacity(ship.getCurrentShipCapacity() + load);
                    System.out.println(ship.getName() + " загрузил " + load + " контейнеров и покинул порт");
                    System.out.println("Текущая загруженность порта " + port.getCurrentPortCapacity());
                } else {
                    // если текущее количество контейнеров превышает вместимость корабля, то загружаем корабль полностью
                    port.setCurrentPortCapacity(port.getCurrentPortCapacity() - canLoad);
                    ship.setCurrentShipCapacity(ship.getMaxShipCapacity());
                    System.out.println(ship.getName() + " загрузил " + canLoad + " контейнеров и покинул порт");
                    System.out.println("Текущая загруженность порта " + port.getCurrentPortCapacity());
                }
                sem.release();
            } else {
                System.out.println(ship.getName() + " ожидайте освобождения места для загрузки");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}