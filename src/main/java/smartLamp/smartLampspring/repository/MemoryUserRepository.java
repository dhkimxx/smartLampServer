package smartLamp.smartLampspring.repository;

import smartLamp.smartLampspring.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MemoryUserRepository implements UserRepository {
    private static Map<String, User> store = new HashMap<>();


    @Override
    public void save(User user) {
        store.put(user.getUserId(), user);
    }

    @Override
    public User findById(String userId) {
        return store.get(userId);
    }

    @Override
    public boolean containUserId(String userId) {
        return store.containsKey(userId);
    }

    @Override
    public Map<String, User> findAll() {
        return store;
    }


}
