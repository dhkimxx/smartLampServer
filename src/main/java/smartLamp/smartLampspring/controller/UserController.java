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
        System.out.println("user = " + user);

        if (userRepository.containUserId(user.getUserId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        userRepository.save(user);
        System.out.println(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // 사용자 인증 API
    @PostMapping("/authenticate")
    public ResponseEntity<Void> authenticateUser(@RequestBody User user) {
        System.out.println("user = " + user);

        if (userRepository.containUserId(user.getUserId())) {
            User storedUser = userRepository.findById(user.getUserId());
            if (storedUser.getUserPw().equals(user.getUserPw())) {
                storedUser.setAuthenticated(true);
                System.out.println(userRepository.findAll());
                return ResponseEntity.ok().build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

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