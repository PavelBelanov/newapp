package ru.belanov.newapp.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.belanov.newapp.domain.task.Task;
import ru.belanov.newapp.domain.user.User;
import ru.belanov.newapp.service.TaskService;
import ru.belanov.newapp.service.UserService;
import ru.belanov.newapp.web.dto.task.TaskDto;
import ru.belanov.newapp.web.dto.user.UserDto;
import ru.belanov.newapp.web.dto.validation.OnCreate;
import ru.belanov.newapp.web.dto.validation.OnUpdate;
import ru.belanov.newapp.web.mappers.TaskMapper;
import ru.belanov.newapp.web.mappers.UserMapper;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final TaskService taskService;

    private final UserMapper userMapper;
    private final TaskMapper taskMapper;

    @PutMapping
    public UserDto updateUser(@Validated(OnUpdate.class)@RequestBody UserDto dto){
        User user = userMapper.toEntity(dto);
        User updatedUser = userService.update(user);
        return userMapper.toDto(updatedUser);
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id){
        User user = userService.getById(id);
        return userMapper.toDto(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id){
        userService.delete(id);
    }

    @GetMapping("/{id}/tasks")
    public List<TaskDto> getTasksByUserId(@PathVariable Long id){
        List<Task> tasks = taskService.getAllByUserId(id);
        return taskMapper.toDto(tasks);
    }
    @PostMapping("/{id}/tasks")
    public TaskDto createTask(@PathVariable Long id, @Validated(OnCreate.class) @RequestBody TaskDto dto){
        Task task = taskMapper.toEntity(dto);
        Task createdTask = taskService.create(task,id);
        return taskMapper.toDto(createdTask);
    }
}
