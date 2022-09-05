package programming_with_classes.agregation_and_composition.task3;

/*
Создать объект класса Государство, используя классы Область, Район, Город.
Методы: вывести на консоль столицу, количество областей, площадь, областные центры;
* */
public class State {
    private String name;
    private City capitalName;
    private Region[] regions;
    private double area;
    private int regionCount;

    public State(String name, City capitalName, double area, Region[] regions, int regionCount) {
        this.name = name;
        this.capitalName = capitalName;
        this.regions = regions;
        this.area = area;
        this.regionCount = regionCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        }
    }

    public City getCapitalName() {
        return capitalName;
    }

    public void setCapitalName(City capitalName) {
        if (capitalName != null) {
            this.capitalName = capitalName;
        }
    }

    public Region[] getRegions() {
        return regions;
    }

    public void setRegions(Region[] regions) {
        if (regions != null) {
            this.regions = regions;
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

    public int getRegionCount() {
        return regionCount;
    }

    public void setRegionCount(int regionCount) {
        if (regionCount > 0) {
            this.regionCount = regionCount;
        }
    }

    @Override
    public String toString() {
        return "State{" +
                "name='" + name + '\'' +
                ", capitalName=" + capitalName +
                ", area=" + area +
                ", regionCount=" + regionCount +
                '}';
    }
}