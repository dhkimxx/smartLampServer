package smartLamp.smartLampspring.model;

import java.util.ArrayList;

public class User {
    public String userId;
    public String userPw;
    public String userName;
    public ArrayList<String> unitList;
    public ArrayList<String> getUnitList;
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

    public ArrayList<String> getUnitList() {
        return unitList;
    }

    public void setUnitList(ArrayList<String> unitList) {
        this.unitList = unitList;
    }

    public ArrayList<String> getGetUnitList() {
        return getUnitList;
    }

    public void setGetUnitList(ArrayList<String> getUnitList) {
        this.getUnitList = getUnitList;
    }
}
