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

    // 사용자 생성 API
    @PostMapping("/users")
    public ResponseEntity<Void> createUser(@RequestBody User user) {
        if (userRepository.containUserId(user.getUserId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // 사용자 수정 API
    @PutMapping("/users")
    public ResponseEntity<Void> updateUser(@RequestBody User user) {
        if (userRepository.containUserId(user.getUserId())) {
            userRepository.save(user);
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
                return ResponseEntity.ok(storedUser);
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    // 사용자 로그아웃
    @DeleteMapping("/authenticate")
    public ResponseEntity<Void> logoutUser(@RequestBody User user) {
        if (userRepository.containUserId(user.getUserId())) {
            User storedUser = userRepository.findById(user.getUserId());
            if (storedUser.isAuthenticated()) {
                storedUser.setAuthenticated(false);
                return ResponseEntity.ok().build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    // 로그인 상태 확인 API
    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId) {
        if (userRepository.containUserId(userId)) {
            User storedUser = userRepository.findById(userId);
            if (storedUser.isAuthenticated()) {
                return ResponseEntity.ok(storedUser);
            }
        }
        return ResponseEntity.notFound().build();
    }
}