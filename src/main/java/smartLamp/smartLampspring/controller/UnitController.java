package smartLamp.smartLampspring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smartLamp.smartLampspring.model.Unit;
import smartLamp.smartLampspring.service.UnitService;

@RestController
@RequestMapping("/api")
public class UnitController {

    private final UnitService unitService;

    @Autowired
    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    // 디바이스 정보 등록 API
    @PostMapping("/unit")
    public ResponseEntity<Void> createUnit(@RequestBody Unit unit) {
        if (unitService.create(unit)) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    // 디바이스 정보 반환 API
    @GetMapping("/unit/{unitCode}")
    public ResponseEntity<Unit> getUnit(@PathVariable String unitCode) {
        if (unitService.read(unitCode).isPresent()) {
            return ResponseEntity.ok(unitService.read(unitCode).get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/unit")
    // 디바이스 삭제 API
    public ResponseEntity<Void> deleteUnit(@RequestBody Unit unit) {
        if(unitService.delete(unit.getUnitCode())){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
