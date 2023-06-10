package smartLamp.smartLampspring.service;

import org.springframework.transaction.annotation.Transactional;
import smartLamp.smartLampspring.dto.UnitInfoDto;
import smartLamp.smartLampspring.dto.UserInfoDto;
import smartLamp.smartLampspring.Entity.Unit;
import smartLamp.smartLampspring.Entity.User;
import smartLamp.smartLampspring.repository.UnitRepository;
import smartLamp.smartLampspring.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
public class UnitService {
    private final UnitRepository unitRepository;
    private final UserRepository userRepository;

    public UnitService(UnitRepository unitRepository, UserRepository userRepository){
        this.unitRepository = unitRepository;
        this.userRepository = userRepository;
    }

    public boolean create(UnitInfoDto unitInfoDto){
        Optional<Unit> storedUnit = unitRepository.findByCode(unitInfoDto.getUnitCode());
        Optional<User> storedUser = userRepository.findById(unitInfoDto.getUserId());
        if (storedUnit.isPresent() | storedUser.isEmpty()) {
            return false;
        }

        Unit newUnit = new Unit();
        newUnit.setUnitCode(unitInfoDto.getUnitCode());
        newUnit.setUnitName(unitInfoDto.getUnitName());
        newUnit.setDistance(unitInfoDto.getDistance());
        newUnit.setTime(unitInfoDto.getTime());
        newUnit.setBrightness(unitInfoDto.getBrightness());
        newUnit.setUser(storedUser.get());
        unitRepository.save(newUnit);
        return true;
    }

    public List<Unit> readUnitList(UserInfoDto userInfoDto){
        Optional<User> storedUser = userRepository.findById(userInfoDto.getUserId());
        if(storedUser.isPresent()){
            return storedUser.get().getUnitList();
        }
        return new ArrayList<>();
    }

    public boolean update(UnitInfoDto unitInfoDto){
        Optional<Unit> storedUnit = unitRepository.findByCode(unitInfoDto.getUnitCode());
        if (storedUnit.isPresent()) {
            storedUnit.get().setDistance(unitInfoDto.getDistance());
            storedUnit.get().setTime(unitInfoDto.getTime());
            storedUnit.get().setBrightness(unitInfoDto.getBrightness());
            unitRepository.save(storedUnit.get());
            return true;
        }
        return false;
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
