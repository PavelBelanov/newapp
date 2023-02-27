package ru.belanov.newapp.service;

import ru.belanov.newapp.web.dto.auth.JwtRequest;
import ru.belanov.newapp.web.dto.auth.JwtResponse;

public interface AuthService {

    JwtResponse login(JwtRequest loginRequest);

    JwtResponse refresh(String refreshToken);
}
