package smartLamp.smartLampspring.model;

import java.util.ArrayList;

public class Group {
    private String groupCode;
    private String groupName;
    private ArrayList<String> unitList;


    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public ArrayList<String> getUnitList() {
        return unitList;
    }

    public void setUnitList(ArrayList<String> unitList) {
        this.unitList = unitList;
    }
}
