package ru.belanov.newapp.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.belanov.newapp.domain.user.User;
import ru.belanov.newapp.service.AuthService;
import ru.belanov.newapp.service.UserService;
import ru.belanov.newapp.web.dto.auth.JwtRequest;
import ru.belanov.newapp.web.dto.auth.JwtResponse;
import ru.belanov.newapp.web.dto.user.UserDto;
import ru.belanov.newapp.web.dto.validation.OnCreate;
import ru.belanov.newapp.web.mappers.UserMapper;

@Validated
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    private final UserService userService;

    private final UserMapper userMapper;

    @PostMapping("/login")
    public JwtResponse login(@Validated @RequestBody JwtRequest loginRequest){
        return authService.login(loginRequest);
    }

    @PostMapping("/register")
    public UserDto register(@Validated(OnCreate.class)@RequestBody UserDto userDto){
        User user = userMapper.toEntity(userDto);
        User created = userService.create(user);
        return userMapper.toDto(created);
    }

    @PostMapping("/refresh")
    public JwtResponse refresh(@RequestBody String refreshToken){
        return authService.refresh(refreshToken);
    }
}
