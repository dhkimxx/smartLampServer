package smartLamp.smartLampspring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smartLamp.smartLampspring.dto.UserInfoDto;
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
    public ResponseEntity<Void> createUser(@RequestBody UserInfoDto userInfoDto) {
        if(userService.create(userInfoDto)){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    // 사용자 인증 API
    @PostMapping("/authenticate")
    public ResponseEntity<UserInfoDto> authenticateUser(@RequestBody UserInfoDto userInfoDto) {
        if (userService.login(userInfoDto).isPresent()){
                return ResponseEntity.ok(userService.login(userInfoDto).get());
            }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    // 사용자 로그아웃 API
    @DeleteMapping("/authenticate")
    public ResponseEntity<Void> logoutUser(@RequestBody UserInfoDto userInfoDto) {
        if(userService.logout(userInfoDto)){
                return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    // 사용자 정보 수정 API
//    @PutMapping("/user")
//    public ResponseEntity<Void> updateUser(@RequestBody User user) {
//        if(userService.update(user)){
//            return ResponseEntity.status(HttpStatus.CREATED).build();
//        }
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//    }
}