package tasks.task4;

/*
Порт. Корабли заходят в порт для разгрузки/загрузки контейнеров. Число контейнеров, находящихся в текущий момент в
порту и на корабле, должно быть неотрицательным и превышающим заданную грузоподъемность судна и вместимость порта.
В порту работает несколько причалов. У одного причала может стоять один корабль. Корабль может загружаться у
причала или разгружаться.
*/
public class Port {
    private static final int MAX_PORT_CAPACITY = 5000; // максимальное количество контейнеров в порту
    private static final int jettyCount = 2; // количество причалов
    private static int currentPortCapacity = 1000; // текущая загруженность порта

    public static int getJettyCount() {
        return jettyCount;
    }

    public static int getCurrentPortCapacity() {
        return currentPortCapacity;
    }

    public static int getMaxPortCapacity() {
        return MAX_PORT_CAPACITY;
    }

    public static void setCurrentPortCapacity(int currentPortCapacity) {
        Port.currentPortCapacity = currentPortCapacity;
    }
}