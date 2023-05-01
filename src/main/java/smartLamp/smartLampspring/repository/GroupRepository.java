package smartLamp.smartLampspring.repository;

import smartLamp.smartLampspring.model.Group;

public interface GroupRepository {
    void save(Group group);

    Group findByCode(String groupCode);
}
