package ru.belanov.newapp.repository;

import ru.belanov.newapp.domain.user.Role;
import ru.belanov.newapp.domain.user.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findById(Long id);

    Optional<User> findByUserName(String username);

    void update(User user);

    void create(User user);

    void insertUserRole(Long id, Role role);

    boolean isTaskOwner(Long userId, Long taskId);

    void delete(Long id);
}
