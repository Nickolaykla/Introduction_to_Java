package programming_with_classes.agregation_and_composition.task3;

public class District {
    private String name;
    private City[] cities;
    private double area;
    private int cityCount;

    public District(String name, double area, int cityCount) {
        this.name = name;
        this.area = area;
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
    public int getCityCount() {
        return cityCount;
    }

    public City[] getCities() {
        return cities;
    }

    public void setCities(City[] cities) {
        if (cities != null) {
            this.cities = cities;
        }
    }
    public void setCityCount(int cityCount) {
        this.cityCount = cityCount;
    }
}
