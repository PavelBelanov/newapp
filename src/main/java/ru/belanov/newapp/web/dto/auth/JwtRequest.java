package ru.belanov.newapp.web.dto.auth;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JwtRequest {
    @NotNull(message = "Username must be not null")
    private String username;
    @NotNull(message = "Password must be not empty")
    private String password;
}
