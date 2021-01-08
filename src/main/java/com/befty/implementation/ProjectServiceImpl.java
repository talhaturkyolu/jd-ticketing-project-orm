package com.befty.implementation;

import com.befty.dto.ProjectDTO;
import com.befty.entity.Project;
import com.befty.enums.Status;
import com.befty.mapper.ProjectMapper;
import com.befty.mapper.UserMapper;
import com.befty.repository.ProjectRepository;
import com.befty.service.ProjectService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectMapper projectMapper;
    private ProjectRepository projectRepository;
    private UserMapper userMapper;

    public ProjectServiceImpl(ProjectMapper projectMapper, ProjectRepository projectRepository, UserMapper userMapper) {
        this.projectMapper = projectMapper;
        this.projectRepository = projectRepository;
        this.userMapper = userMapper;
    }

    @Override
    public ProjectDTO getByProjectCode(String code) {
        return null;
    }

    @Override
    public List<ProjectDTO> listAllProjects() {
        List<Project> list = projectRepository.findAll(Sort.by("projectCode"));
        return list.stream().map(obj -> projectMapper.convertToDto(obj)).collect(Collectors.toList());
    }

    @Override
    public Project save(ProjectDTO dto) {
        dto.setProjectStatus(Status.OPEN);
        Project obj = projectMapper.convertToEntity(dto);
        obj.setAssignedManager(userMapper.convertToEntity(dto.getAssignedManager()));
        Project project = projectRepository.save(obj);
        return project;
    }

    @Override
    public ProjectDTO update(ProjectDTO dto) {
        return null;
    }

    @Override
    public void delete(String code) {

    }
}