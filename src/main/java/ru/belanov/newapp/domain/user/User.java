package ru.belanov.newapp.domain.user;

import lombok.Builder;
import lombok.Data;
import ru.belanov.newapp.domain.task.Task;

import java.util.List;
import java.util.Set;

@Data
@Builder
public class User {

    private Long id;
    private String name;
    private String username;
    private String password;
    private String passwordConfirmation;
    private Set<Role> roles;
    private List<Task> tasks;

}
