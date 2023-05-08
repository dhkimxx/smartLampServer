package smartLamp.smartLampspring.repository;

import smartLamp.smartLampspring.model.Unit;

public interface UnitRepository {
    void save(Unit unit);

    void delete(Unit unit);

    Unit findByCode(String unitCode);

    boolean containUnitCode(String unitCode);
}
