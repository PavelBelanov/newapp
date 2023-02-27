package ru.belanov.newapp.service.impl;

import org.springframework.stereotype.Service;
import ru.belanov.newapp.service.AuthService;
import ru.belanov.newapp.web.dto.auth.JwtRequest;
import ru.belanov.newapp.web.dto.auth.JwtResponse;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public JwtResponse login(JwtRequest loginRequest) {
        return null;
    }

    @Override
    public JwtResponse refresh(String refreshToken) {
        return null;
    }
}
