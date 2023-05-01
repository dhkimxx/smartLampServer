package smartLamp.smartLampspring.repository;

import smartLamp.smartLampspring.model.Group;
import smartLamp.smartLampspring.model.Unit;

import java.util.HashMap;
import java.util.Map;

public class MemoryGroupRepository implements GroupRepository {

    private static Map<String, Unit> store = new HashMap<>();
    @Override
    public void save(Group group) {

    }

    @Override
    public Group findByCode(String groupCode) {
        return null;
    }
}
