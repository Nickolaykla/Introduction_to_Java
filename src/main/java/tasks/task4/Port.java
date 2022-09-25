package tasks.task4;

import java.util.concurrent.atomic.AtomicInteger;

/*
Порт. Корабли заходят в порт для разгрузки/загрузки контейнеров. Число контейнеров, находящихся в текущий момент в
порту и на корабле, должно быть неотрицательным и превышающим заданную грузоподъемность судна и вместимость порта.
В порту работает несколько причалов. У одного причала может стоять один корабль. Корабль может загружаться у
причала или разгружаться.
*/
public class Port {
    private String portName;
    private int maxPortCapacity; // максимальное количество контейнеров в порту
    private int jettyCount; // количество причалов
    private AtomicInteger currentPortCapacity; // текущая загруженность порта

    public Port(String portName, int maxPortCapacity, int jettyCount, int currentPortCapacity) {
        if (portName != null && maxPortCapacity > 0 && jettyCount > 0 && currentPortCapacity >= 0) {
            this.portName = portName;
            this.maxPortCapacity = maxPortCapacity;
            this.jettyCount = jettyCount;
            this.currentPortCapacity = new AtomicInteger(currentPortCapacity);
        } else throw new IllegalArgumentException("Заданы некорректные данные.");
    }

    public int getCurrentPortCapacity() {
        return this.currentPortCapacity.get();
    }

    public void setCurrentPortCapacity(int currentPortCapacity) {
        this.currentPortCapacity.set(currentPortCapacity);
    }

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        if (portName != null) {
            this.portName = portName;
        }
    }

    public int getMaxPortCapacity() {
        return maxPortCapacity;
    }

    public void setMaxPortCapacity(int maxPortCapacity) {
        if (maxPortCapacity > 0) {
            this.maxPortCapacity = maxPortCapacity;
        }
    }

    public int getJettyCount() {
        return jettyCount;
    }

    public void setJettyCount(int jettyCount) {
        if (jettyCount > 0) {
            this.jettyCount = jettyCount;
        }
    }

    @Override
    public String toString() {
        return "Port{" +
                "portName='" + portName + '\'' +
                ", maxPortCapacity=" + maxPortCapacity +
                ", jettyCount=" + jettyCount +
                ", currentPortCapacity=" + currentPortCapacity +
                '}';
    }
}