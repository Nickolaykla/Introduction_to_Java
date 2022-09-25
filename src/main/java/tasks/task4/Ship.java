package tasks.task4;

import java.util.concurrent.atomic.AtomicInteger;

public class Ship {
    private String name;
    private int maxShipCapacity;
    private AtomicInteger currentShipCapacity;
    private Point point;

    public Ship(String name, int currentShipCapacity, int maxShipCapacity, Point point) {
        if (name != null && currentShipCapacity > 0 && maxShipCapacity > 0 && point != null) {
            this.name = name;
            this.currentShipCapacity = new AtomicInteger(currentShipCapacity);
            this.maxShipCapacity = maxShipCapacity;
            this.point = point;
        } else throw new IllegalArgumentException("Неверно заданы параметры конструктора");
    }

    public int getCurrentShipCapacity() {
        return this.currentShipCapacity.get();
    }

    public void setCurrentShipCapacity(int currentShipCapacity) {
        this.currentShipCapacity.set(currentShipCapacity);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        } else throw new IllegalArgumentException("Неверно задано имя");
    }

    public int getMaxShipCapacity() {
        return maxShipCapacity;
    }

    public void setMaxShipCapacity(int maxShipCapacity) {
        if (maxShipCapacity > 0) {
            this.maxShipCapacity = maxShipCapacity;
        } else throw new IllegalArgumentException("Неверно установлена грузоподъемность судна");
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}