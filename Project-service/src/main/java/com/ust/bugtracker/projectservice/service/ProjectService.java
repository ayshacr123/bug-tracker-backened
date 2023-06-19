package com.ust.bugtracker.projectservice.service;


import com.ust.bugtracker.projectservice.model.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    List<Project> getAll();

    Optional<Project> getById(Long id);

    Project create(Project project);

    Project updateById(Long id, Project project);

    String deleteById(Long id);


}
