package programming_with_classes.agregation_and_composition.task3;

public class District {
    private String name;
    private double area;

    public District(String name, double area) {
        if (name != null && area > 0) {
            this.name = name;
            this.area = area;
        } else throw new IllegalArgumentException("Некорректные данные");
    }
    public District() {
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
}