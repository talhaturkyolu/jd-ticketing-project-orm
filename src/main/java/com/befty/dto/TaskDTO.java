package com.befty.dto;

import com.befty.enums.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class TaskDTO {

    private Long id;
    private ProjectDTO project;
    private UserDTO assignedEmployee;
    private String taskSubject;
    private String taskDetail;
    private Status taskStatus;
    private LocalDate assignedDate;

    public TaskDTO(ProjectDTO project, UserDTO assignedEmployee, String taskSubject, String taskDetail, Status taskStatus, LocalDate assignedDate) {
        this.project = project;
        this.assignedEmployee = assignedEmployee;
        this.taskSubject = taskSubject;
        this.taskDetail = taskDetail;
        this.taskStatus = taskStatus;
        this.assignedDate = assignedDate;
        this.id= UUID.randomUUID().getMostSignificantBits();
    }
}
