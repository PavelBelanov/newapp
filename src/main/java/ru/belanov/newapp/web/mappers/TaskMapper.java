package ru.belanov.newapp.web.mappers;

import org.mapstruct.Mapper;
import ru.belanov.newapp.domain.task.Task;
import ru.belanov.newapp.web.dto.task.TaskDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDto toDto(Task task);

    List<TaskDto> toDto(List<Task> list);

    Task toEntity(TaskDto taskDto);
}
