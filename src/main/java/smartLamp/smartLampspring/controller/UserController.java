package smartLamp.smartLampspring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import smartLamp.smartLampspring.model.User;
import smartLamp.smartLampspring.repository.MemoryUserRepository;
import smartLamp.smartLampspring.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {
    UserRepository userRepository = new MemoryUserRepository();

    // 사용자 정보 등록 API
    @PostMapping("/user")
    public ResponseEntity<Void> createUser(@RequestBody User user) {
        if (userRepository.containUserId(user.getUserId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        userRepository.save(user);
        System.out.println("사용자 정보 등록");
        System.out.println("user.toString() = " + user.toString());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // 사용자 정보 수정 API
    @PutMapping("/user")
    public ResponseEntity<Void> updateUser(@RequestBody User user) {
        if (userRepository.containUserId(user.getUserId())) {
            userRepository.save(user);
            System.out.println("사용자 정보 수정");
            System.out.println("user.toString() = " + user.toString());
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // 사용자 인증 API
    @PostMapping("/authenticate")
    public ResponseEntity<User> authenticateUser(@RequestBody User user) {
        if (userRepository.containUserId(user.getUserId())) {
            User storedUser = userRepository.findById(user.getUserId());
            if (storedUser.getUserPw().equals(user.getUserPw())) {
                storedUser.setAuthenticated(true);
                System.out.println("사용자 로그인 인증");
                System.out.println("storedUser.toString() = " + storedUser.toString());
                return ResponseEntity.ok(storedUser);
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    // 사용자 로그아웃 API
    @DeleteMapping("/authenticate")
    public ResponseEntity<Void> logoutUser(@RequestBody User user) {
        if (userRepository.containUserId(user.getUserId())) {
            User storedUser = userRepository.findById(user.getUserId());
            if (storedUser.isAuthenticated()) {
                storedUser.setAuthenticated(false);
                System.out.println("사용자 로그아웃");
                System.out.println("storedUser.toString() = " + storedUser.toString());
                return ResponseEntity.ok().build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}