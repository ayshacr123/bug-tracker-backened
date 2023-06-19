package com.ust.bugtracker.bugservice.service;


import com.ust.bugtracker.bugservice.model.Bug;

import java.util.List;
import java.util.Optional;

public interface BugService {
    List<Bug> getAll();

    Optional<Bug> getById(Long id);

    Bug create(Bug bug);

    Bug updateById(Long id, Bug bug);

    String deleteById(Long id);

    List<Bug> getBugbyNAme(String name);

    List<Bug> getBugbyStatus(String status);

    List<Bug> getBugByName(String projectName);
}
