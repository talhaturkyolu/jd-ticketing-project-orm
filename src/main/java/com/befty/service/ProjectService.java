package com.befty.service;

import com.befty.dto.ProjectDTO;
import com.befty.entity.Project;

import java.util.List;

public interface ProjectService {

    ProjectDTO getByProjectCode(String code);
    List<ProjectDTO> listAllProjects();
    Project save(ProjectDTO dto);
    ProjectDTO update(ProjectDTO dto);
    void delete(String code);
}