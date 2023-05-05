package smartLamp.smartLampspring.model;

public class Unit {
    public String unitCode;
    public String unitName;
    public Integer distance;
    public Integer time;

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "unitCode='" + unitCode + '\'' +
                ", unitName='" + unitName + '\'' +
                ", distance=" + distance +
                ", time=" + time +
                '}';
    }
}
