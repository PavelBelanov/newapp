package ru.belanov.newapp.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import ru.belanov.newapp.domain.user.Role;
import ru.belanov.newapp.domain.user.User;

import java.util.Optional;
@Mapper
public interface UserRepository {

    Optional<User> findById(Long id);

    Optional<User> findByUserName(String username);

    void update(User user);

    void create(User user);

    void insertUserRole(@Param("id") Long id,@Param("role") Role role);

    boolean isTaskOwner(@Param("userId") Long userId,@Param("taskId") Long taskId);

    void delete(Long id);
}
