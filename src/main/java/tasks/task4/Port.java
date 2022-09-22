package tasks.task4;

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
    private int currentPortCapacity; // текущая загруженность порта

    public Port(String portName, int maxPortCapacity, int jettyCount, int currentPortCapacity) {
        if (portName != null && maxPortCapacity > 0 && jettyCount > 0 && currentPortCapacity >= 0) {
            this.portName = portName;
            this.maxPortCapacity = maxPortCapacity;
            this.jettyCount = jettyCount;
            this.currentPortCapacity = currentPortCapacity;
        } else throw new IllegalArgumentException("Заданы некорректные данные.");
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

    public int getCurrentPortCapacity() {
        return currentPortCapacity;
    }

    public void setCurrentPortCapacity(int currentPortCapacity) {
        if (currentPortCapacity >= 0) {
            this.currentPortCapacity = currentPortCapacity;
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