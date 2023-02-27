package ru.belanov.newapp.repository.impl;

import org.springframework.stereotype.Repository;
import ru.belanov.newapp.domain.user.Role;
import ru.belanov.newapp.domain.user.User;
import ru.belanov.newapp.repository.UserRepository;

import java.util.Optional;
@Repository
public class UserRepositoryImpl implements UserRepository {
    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        return Optional.empty();
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void create(User user) {

    }

    @Override
    public void insertUserRole(Long id, Role role) {

    }

    @Override
    public boolean isTaskOwner(Long userId, Long taskId) {
        return false;
    }

    @Override
    public void delete(Long id) {

    }
}
