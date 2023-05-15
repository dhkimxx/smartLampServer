package smartLamp.smartLampspring.repository;

import smartLamp.smartLampspring.model.Unit;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaUnitRepository implements UnitRepository{

    private final EntityManager em;

    public JpaUnitRepository(EntityManager em){
        this.em = em;
    }
    @Override
    public Unit save(Unit unit) {
        return null;
    }

    @Override
    public void delete(Unit unit) {

    }

    @Override
    public Optional<Unit> findByCode(String unitCode) {
        return Optional.empty();
    }

    @Override
    public List<Unit> findAll() {
        return null;
    }
}
