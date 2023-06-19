package com.ust.bugtracker.projectservice.controller;


import com.ust.bugtracker.projectservice.dto.ErrorResponse;
import com.ust.bugtracker.projectservice.model.Project;
import com.ust.bugtracker.projectservice.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/getAllProjects")
    public ResponseEntity<?> getAllProjects() {
        List<Project> projects = projectService.getAll();
        if (projects.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse(HttpStatus.NOT_FOUND.value(), "No projects found."));
        }
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/getProjectById/{id}")
    public ResponseEntity<?> getProjectById(@PathVariable Long id) {
        Optional<Project> project = projectService.getById(id);
        if (project.isPresent()) {
            return ResponseEntity.ok(project.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse(HttpStatus.NOT_FOUND.value(), "Project not found with id: " + id));
        }
    }

    @PostMapping("/createProject")
    public ResponseEntity<?> createProject(@RequestBody Project project) {
        Project createdProject = projectService.create(project);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProject);
    }

    @PutMapping("/updateProject/{id}")
    public ResponseEntity<?> updateProject(@PathVariable Long id, @RequestBody Project project) {
        Project updatedProject = projectService.updateById(id, project);
        if (updatedProject != null) {
            return ResponseEntity.ok(updatedProject);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse(HttpStatus.NOT_FOUND.value(), "Project not found with id: " + id));
        }
    }

    @DeleteMapping("/deleteProjectById/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable Long id) {
        boolean isDeleted = Boolean.parseBoolean(projectService.deleteById(id));
        if (isDeleted) {
            return ResponseEntity.ok("Deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse(HttpStatus.NOT_FOUND.value(), "Project not found with id: " + id));
        }
    }

}
