package programming_with_classes.agregation_and_composition.task3;

public class Region {
    private String name;
    private String centerName;
    private District[] districts;
    private double area;
    private int districtsCount;

    public Region(String name, String centerName, double area, District[] districts, int districtsCount) {
        if (name != null && centerName != null && area > 0 && districts != null && districtsCount > 0) {
            this.name = name;
            this.centerName = centerName;
            this.area = area;
            this.districts = districts;
            this.districtsCount = districtsCount;
        } else throw new IllegalArgumentException("Некорректные данные");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        }
    }

    public District[] getDistricts() {
        return districts;
    }

    public void setDistricts(District[] districts) {
        if (districts != null) {
            this.districts = districts;
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

    public int getDistrictsCount() {
        return districtsCount;
    }

    public void setDistrictsCount(int districtsCount) {
        if (districtsCount > 0) {
            this.districtsCount = districtsCount;
        }
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        if (!centerName.isEmpty()) {
            this.centerName = centerName;
        }
    }
}