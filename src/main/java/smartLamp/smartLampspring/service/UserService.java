package smartLamp.smartLampspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import smartLamp.smartLampspring.dto.UserInfoDto;
import smartLamp.smartLampspring.Entity.User;
import smartLamp.smartLampspring.repository.UserRepository;

import java.util.Objects;
import java.util.Optional;

@Transactional
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean logout(UserInfoDto userInfoDto) {
        Optional<User> storedUser = userRepository.findById(userInfoDto.getUserId());
        if (storedUser.isPresent()) {
            storedUser.get().setAuthenticated(false);
            userRepository.save(storedUser.get());
            return true;
        }
        return false;
    }

    public Optional<UserInfoDto> login(UserInfoDto userInfoDto) {
        Optional<User> storedUser = userRepository.findById(userInfoDto.getUserId());
        if (storedUser.isPresent()) {
            if (Objects.equals(storedUser.get().getUserPw(), userInfoDto.getUserPw())) {
                storedUser.get().setAuthenticated(true);
                userRepository.save(storedUser.get());
                userInfoDto.setUserName(storedUser.get().getUserName());
                return Optional.of(userInfoDto);
            }
            return Optional.empty();
        }
        return Optional.empty();
    }

    public boolean create(UserInfoDto userInfoDto) {
        Optional<User> storedUser = userRepository.findById(userInfoDto.getUserId());
        if (storedUser.isPresent()) {
            return false;
        }
        User newUser = new User();
        newUser.setUserId(userInfoDto.getUserId());
        newUser.setUserPw(userInfoDto.getUserPw());
        newUser.setUserName(userInfoDto.getUserName());
        userRepository.save(newUser);
        return true;
    }

    public Optional<User> read(User user) {
        return userRepository.findById(user.getUserId());
    }

    public boolean update(User user) {
        Optional<User> storedUser = userRepository.findById(user.getUserId());
        if (storedUser.isPresent()) {
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public boolean delete(User user) {
        Optional<User> storedUser = userRepository.findById(user.getUserId());
        if (storedUser.isPresent()) {
            userRepository.delete(user);
            return true;
        }
        return false;
    }
}
