package smartLamp.smartLampspring.repository;

import smartLamp.smartLampspring.model.Unit;

public interface UnitRepository {
    void save(Unit unit);

    Unit findByCode(String unitCode);
}
