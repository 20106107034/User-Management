package com.System.UserManagement.Repository;



import com.System.UserManagement.Model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepository {

    private final ConcurrentHashMap<Long, User> userStore = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(0);

    public User save(User user) {
        Long id = idGenerator.incrementAndGet();
        user.setId(id);
        userStore.put(id, user);
        return user;
    }

    public List<User> findAll() {
        return new ArrayList<>(userStore.values());
    }

    public Optional<User> findById(Long id) {
        return Optional.ofNullable(userStore.get(id));
    }

    public User update(User user) {
        userStore.put(user.getId(), user);
        return user;
    }

    public void deleteById(Long id) {
        userStore.remove(id);
    }

    public boolean existsById(Long id) {
        return userStore.containsKey(id);
    }
}
