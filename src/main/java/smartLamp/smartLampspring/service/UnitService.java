package smartLamp.smartLampspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import smartLamp.smartLampspring.model.Unit;
import smartLamp.smartLampspring.repository.UnitRepository;

import java.util.Optional;

@Component
public class UnitService {
    private final UnitRepository unitRepository;

    @Autowired
    public UnitService(UnitRepository unitRepository){
        this.unitRepository = unitRepository;
    }

    public boolean create(Unit unit){
        Optional<Unit> storedUnit = unitRepository.findByCode(unit.getUnitCode());
        if (storedUnit.isPresent()) {
            return false;
        }
        unitRepository.save(unit);
        return true;
    }

    public Optional<Unit> read(String unitCode){
        return unitRepository.findByCode(unitCode);
    }

    public boolean delete(String unitCode){
        Optional<Unit> storedUnit = unitRepository.findByCode(unitCode);
        if(storedUnit.isPresent()){
            unitRepository.delete(storedUnit.get());
            return true;
        }
        return false;
    }
}
