package ru.belanov.newapp.web.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import ru.belanov.newapp.web.dto.validation.OnCreate;
import ru.belanov.newapp.web.dto.validation.OnUpdate;

@Data
@Builder
public class UserDto {
    @NotNull(message = "id must be not empty", groups = OnUpdate.class)
    private Long id;
    @NotNull(message = "Name must be not empty", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Name length must be smaller that 255 symbols", groups = {OnCreate.class, OnUpdate.class})
    private String name;
    @NotNull(message = "Username must be not empty", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Username length must be smaller that 255 symbols", groups = {OnCreate.class, OnUpdate.class})
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Password must be not empty", groups = {OnCreate.class, OnUpdate.class})
    private String password;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Password confirmation must be not empty", groups = OnCreate.class)
    private String passwordConfirmation;

}
