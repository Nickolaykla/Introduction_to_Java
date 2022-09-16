package tasks.task4;

public class Ship {
    private String name;
    private int maxShipCapacity;
    private int currentShipCapacity;

    public Ship(String name, int currentShipCapacity, int maxShipCapacity) {
        if (name != null && currentShipCapacity >= 0 && maxShipCapacity > 0) {
            this.name = name;
            this.currentShipCapacity = currentShipCapacity;
            this.maxShipCapacity = maxShipCapacity;
        } else throw new IllegalArgumentException("Неверно заданы параметры конструктора");
    }

    public int getCurrentShipCapacity() {
        return currentShipCapacity;
    }

    public void setCurrentShipCapacity(int currentShipCapacity) {
        if (currentShipCapacity >= 0) {
            this.currentShipCapacity = currentShipCapacity;
        } else throw new IllegalArgumentException("Неверно задана текущая загруженность судна");
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
}