package com.ust.bugtracker.projectservice.service;


import com.ust.bugtracker.projectservice.model.Project;
import com.ust.bugtracker.projectservice.repository.ProjectRepository;
import com.ust.bugtracker.projectservice.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    @Override
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    @Override
    public Optional<Project> getById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public Project create(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project updateById(Long id, Project project) {
        return projectRepository.save(project);
    }

    @Override
    public String deleteById(Long id) {
        projectRepository.deleteById(id);
        return "Deleted";
    }




}
