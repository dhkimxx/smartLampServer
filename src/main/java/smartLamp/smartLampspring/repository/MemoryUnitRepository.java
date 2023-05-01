package smartLamp.smartLampspring.repository;

import smartLamp.smartLampspring.model.Unit;
import smartLamp.smartLampspring.model.User;

import java.util.HashMap;
import java.util.Map;

public class MemoryUnitRepository implements UnitRepository {

    private static Map<String, Unit> store = new HashMap<>();

    @Override
    public void save(Unit unit) {
        store.put(unit.getUnitCode(), unit);
    }

    @Override
    public Unit findByCode(String unitCode) {
        return store.get(unitCode);
    }
}
