package ru.belanov.newapp.web.mappers;

import org.mapstruct.Mapper;
import ru.belanov.newapp.domain.user.User;
import ru.belanov.newapp.web.dto.user.UserDto;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(UserDto userDto);
}
