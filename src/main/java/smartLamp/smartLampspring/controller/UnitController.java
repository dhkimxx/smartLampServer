package smartLamp.smartLampspring.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smartLamp.smartLampspring.model.Unit;
import smartLamp.smartLampspring.repository.MemoryUnitRepository;
import smartLamp.smartLampspring.repository.UnitRepository;

@RestController
@RequestMapping("/api")
public class UnitController {

    UnitRepository unitRepository = new MemoryUnitRepository();


    // 디바이스 정보 등록 API
    @PostMapping("/unit")
    public ResponseEntity<Void> createUnit(@RequestBody Unit unit){
        if (unitRepository.containUnitCode(unit.getUnitCode())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        unitRepository.save(unit);
        System.out.println("디바이스 정보 등록");
        System.out.println("unit.toString() = " + unit.toString());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // 디바이스 정보 반환 API
    @GetMapping("/unit/{unitCode}")
    public ResponseEntity<Unit> getUnit(@PathVariable String unitCode) {
        if (unitRepository.containUnitCode(unitCode)) {
            Unit storedUnit = unitRepository.findByCode(unitCode);
            System.out.println("디바이스 정보 요청 응답");
            System.out.println("storedUnit.toString() = " + storedUnit.toString());
            return ResponseEntity.ok(storedUnit);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/unit")
    // 디바이스 삭제 API
    public ResponseEntity<Void> deleteUnit(@RequestBody Unit unit){
        if(unitRepository.containUnitCode(unit.getUnitCode())){
            unitRepository.delete(unit);
            System.out.println("디바이스 정보 삭제 응답");
            System.out.println("storedUnit.toString() = " + unit.toString());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
