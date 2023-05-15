package smartLamp.smartLampspring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity(name="unit")
public class Unit {
    @Id
    @Column(name = "unit_code")
    public String unitCode;
    @Column(name = "unit_name")
    public String unitName;
    public Integer distance;
    public Integer time;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    public User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        if(!user.getUnitList().contains(this)){
            user.addUnit(this);
        }
    }

//    @Override
//    public String toString() {
//        return "Unit{" +
//                "unitCode='" + unitCode + '\'' +
//                ", unitName='" + unitName + '\'' +
//                ", distance=" + distance +
//                ", time=" + time +
//                ", user=" + user +
//                '}';
//    }
}
