package smartLamp.smartLampspring.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="user")
public class User {
    @Id
    @Column(name = "user_id")
    public String userId;
    @Column(name = "user_pw")
    public String userPw;
    @Column(name = "user_name")
    public String userName;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    public List<Unit> unitList;

    private boolean authenticated;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Unit> getUnitList() {
        return unitList;
    }

    public void setUnitList(ArrayList<Unit> unitList) {
        this.unitList = unitList;
    }

    public void addUnit(Unit unit){
        if(!this.unitList.contains(unit)) this.unitList.add(unit);
        if(unit.getUser() != this){
            unit.setUser(this);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userPw='" + userPw + '\'' +
                ", userName='" + userName + '\'' +
                ", unitList=" + unitList +
                ", authenticated=" + authenticated +
                '}';
    }
}
