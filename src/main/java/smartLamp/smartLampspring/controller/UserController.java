package smartLamp.smartLampspring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smartLamp.smartLampspring.model.User;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {
    private Map<String, User> users = new HashMap<>();

    // 사용자 생성 API
    @PostMapping("/users")
    public ResponseEntity<Void> createUser(@RequestBody User user) {
        if (users.containsKey(user.getUsername())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        users.put(user.getUsername(), user);
        System.out.println("users = " + users);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // 사용자 인증 API
    @PostMapping("/authenticate")
    public ResponseEntity<Void> authenticateUser(@RequestBody User user) {
        if (users.containsKey(user.getUsername())) {
            User storedUser = users.get(user.getUsername());
            if (storedUser.getPassword().equals(user.getPassword())) {
                storedUser.setAuthenticated(true);
                return ResponseEntity.ok().build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    // 로그인 상태 확인 API
    @GetMapping("/users/{username}")
    public ResponseEntity<User> getUser(@PathVariable String username) {
        if (users.containsKey(username)) {
            User storedUser = users.get(username);
            if (storedUser.isAuthenticated()) {
                return ResponseEntity.ok(storedUser);
            }
        }
        return ResponseEntity.notFound().build();
    }
}