package smartLamp.smartLampspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import smartLamp.smartLampspring.model.User;
import smartLamp.smartLampspring.repository.UserRepository;

import java.util.Objects;
import java.util.Optional;

@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean logout(User user) {
        Optional<User> storedUser = userRepository.findById(user.getUserId());
        if (storedUser.isPresent()) {
            storedUser.get().setAuthenticated(false);
            userRepository.save(storedUser.get());
            return true;
        }
        return false;
    }

    public Optional<User> login(User user) {
        Optional<User> storedUser = userRepository.findById(user.getUserId());
        if (storedUser.isPresent()) {
            if (Objects.equals(storedUser.get().getUserPw(), user.getUserPw())) {
                storedUser.get().setAuthenticated(true);
                userRepository.save(storedUser.get());
                return storedUser;
            }
            return Optional.empty();
        }
        return Optional.empty();
    }

    public boolean create(User user) {
        Optional<User> storedUser = userRepository.findById(user.getUserId());
        if (storedUser.isPresent()) {
            return false;
        }
        userRepository.save(user);
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
