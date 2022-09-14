package tasks.task4;

import java.util.concurrent.Semaphore;

import static tasks.task4.Main.ships;

public class Ship {
    private String name;
    private int maxShipCapacity;
    private int currentShipCapacity;

    public Ship(String name, int currentShipCapacity, int maxShipCapacity) {
        this.name = name;
        this.currentShipCapacity = currentShipCapacity;
        this.maxShipCapacity = maxShipCapacity;
    }

    public Ship() {
    }

    public int getCurrentShipCapacity() {
        return currentShipCapacity;
    }

    public void setCurrentShipCapacity(int currentShipCapacity) {
        this.currentShipCapacity = currentShipCapacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxShipCapacity() {
        return maxShipCapacity;
    }

    public void setMaxShipCapacity(int maxShipCapacity) {
        this.maxShipCapacity = maxShipCapacity;
    }

}