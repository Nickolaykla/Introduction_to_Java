package programming_with_classes.agregation_and_composition.task3;

public class City {
    private String name;
    private double area;

    public City(String name, double area) {
        if (name != null && area > 0) {
            this.name = name;
            this.area = area;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        }
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        if (area > 0) {
            this.area = area;
        }
    }

    @Override
    public String toString() {
        return name;
    }
}