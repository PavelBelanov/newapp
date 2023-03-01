package ru.belanov.newapp.web.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import ru.belanov.newapp.web.dto.validation.OnCreate;
import ru.belanov.newapp.web.dto.validation.OnUpdate;

@Data
@Builder
@Schema(description = "User DTO")
public class UserDto {

    @Schema(description = "User id", example = "1")
    @NotNull(message = "id must be not empty", groups = OnUpdate.class)
    private Long id;

    @Schema(description = "User name", example = "John Wick")
    @NotNull(message = "Name must be not empty", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Name length must be smaller that 255 symbols", groups = {OnCreate.class, OnUpdate.class})
    private String name;

    @Schema(description = "User email", example = "johnwick@mail.com")
    @NotNull(message = "Username must be not empty", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Username length must be smaller that 255 symbols", groups = {OnCreate.class, OnUpdate.class})
    private String username;

    @Schema(description = "User crypted password", example = "$2a$10$sLPI9zXaYUusmjHHK.5h6O5jT3RYvBwG3fERGwvcWM/4ZLglMlvyS")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Password must be not empty", groups = {OnCreate.class, OnUpdate.class})
    private String password;

    @Schema(description = "User crypted password confirmation", example = "$2a$10$sLPI9zXaYUusmjHHK.5h6O5jT3RYvBwG3fERGwvcWM/4ZLglMlvyS")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Password confirmation must be not empty", groups = OnCreate.class)
    private String passwordConfirmation;

}
