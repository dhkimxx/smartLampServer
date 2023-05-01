package smartLamp.smartLampspring.repository;

import smartLamp.smartLampspring.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface UserRepository {
    void save(User user);

    User findById(String userId);

    boolean containUserId(String userId);

    Map<String, User> findAll();
}
