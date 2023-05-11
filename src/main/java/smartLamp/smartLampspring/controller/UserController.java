package smartLamp.smartLampspring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smartLamp.smartLampspring.model.User;
import smartLamp.smartLampspring.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    private UserController(UserService userService){
        this.userService = userService;
    }

    // 사용자 정보 등록 API
    @PostMapping("/user")
    public ResponseEntity<Void> createUser(@RequestBody User user) {
        if(userService.create(user)){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    // 사용자 정보 수정 API
    @PutMapping("/user")
    public ResponseEntity<Void> updateUser(@RequestBody User user) {
        if(userService.update(user)){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // 사용자 인증 API
    @PostMapping("/authenticate")
    public ResponseEntity<User> authenticateUser(@RequestBody User user) {
        if (userService.login(user).isPresent()){
                return ResponseEntity.ok(userService.login(user).get());
            }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    // 사용자 로그아웃 API
    @DeleteMapping("/authenticate")
    public ResponseEntity<Void> logoutUser(@RequestBody User user) {
        if(userService.logout(user)){
                return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}