package ru.belanov.newapp.web.dto.task;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import ru.belanov.newapp.domain.task.Status;
import ru.belanov.newapp.web.dto.validation.OnCreate;
import ru.belanov.newapp.web.dto.validation.OnUpdate;

import java.time.LocalDateTime;
@Data
public class TaskDto {
    @NotNull(message = "id must be not empty", groups = OnUpdate.class)
    private Long id;
    @NotNull(message = "Title must be not empty", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Title length must be smaller that 255 symbols", groups = {OnCreate.class, OnUpdate.class})
    private String title;
    @Length(max = 255, message = "Description length must be smaller that 255 symbols", groups = {OnCreate.class, OnUpdate.class})
    private String description;

    private Status status;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime expirationDate;
}
