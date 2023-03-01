package ru.belanov.newapp.web.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(description ="Request for login" )
public class JwtRequest {
    @Schema(description = "email", example = "johnwick@mail.com")
    @NotNull(message = "Username must be not null")
    private String username;

    @Schema(description = "password", example = "12345")
    @NotNull(message = "Password must be not empty")
    private String password;
}
