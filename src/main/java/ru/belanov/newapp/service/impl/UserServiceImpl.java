package ru.belanov.newapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.belanov.newapp.domain.exeption.ResourceNotFoundException;
import ru.belanov.newapp.domain.user.Role;
import ru.belanov.newapp.domain.user.User;
import ru.belanov.newapp.repository.UserRepository;
import ru.belanov.newapp.service.UserService;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    @Transactional(readOnly = true)
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public User getByUserName(String username) {
        return userRepository.findByUserName(username).orElseThrow(()->new ResourceNotFoundException("User not found"));
    }

    @Override
    @Transactional
    public User update(User user) {
       user.setPassword(passwordEncoder.encode(user.getPassword()));
       userRepository.update(user);
       return user;
    }

    @Override
    @Transactional
    public User create(User user) {
       if(userRepository.findByUserName(user.getUsername()).isPresent()){
           throw new IllegalStateException("User already exist");
       }
       if(!user.getPassword().equals(user.getPasswordConfirmation())){
           throw new IllegalStateException("Password and password confirmation do not match");
       }
       user.setPassword(passwordEncoder.encode(user.getPassword()));
       userRepository.create(user);
        Set<Role> roles = Set.of(Role.ROLE_USER);
        userRepository.insertUserRole(user.getId(), Role.ROLE_USER);
        user.setRoles(roles);
        return user;
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isTaskOwner(Long userId, Long taskId) {
        return userRepository.isTaskOwner(userId,taskId);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userRepository.delete(id);
    }
}
