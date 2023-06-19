package com.ust.bugtracker.bugservice.controller;

import com.ust.bugtracker.bugservice.dto.ErrorResponse;
import com.ust.bugtracker.bugservice.model.Bug;
import com.ust.bugtracker.bugservice.service.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bugs")
public class BugController {

    @Autowired
    private BugService bugService;


    @GetMapping("/getAllBugs")
    public ResponseEntity<?> getAllBugs() {
        List<Bug> bugs = bugService.getAll();
        if (bugs.isEmpty()) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), "No bugs found.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
        return ResponseEntity.ok(bugs);
    }


    @GetMapping("/getBybyid/{id}")
    public ResponseEntity<?> getBugById(@PathVariable Long id) {
        Optional<Bug> bug = bugService.getById(id);
        if (bug.isPresent()) {
            return ResponseEntity.ok(bug);
        } else {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), "Bug not found with id " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @PostMapping("/postBug")
    public ResponseEntity<?> createBug(@RequestBody Bug bug) {
        Bug createdBug = bugService.create(bug);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBug);
    }

    @PutMapping("/updateBug/{id}")
    public ResponseEntity<?> updateBug(@PathVariable Long id, @RequestBody Bug bug) {
        Bug updatedBug = bugService.updateById(id, bug);
        if (updatedBug != null) {
            return ResponseEntity.ok(updatedBug);
        } else {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), "Bug not found with id " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @GetMapping("/getBugbyName/{name}")
    public ResponseEntity<?> getBugByName(@PathVariable String name) {
        List<Bug> bugs = bugService.getBugByName(name);
        if (!bugs.isEmpty()) {
            return ResponseEntity.ok(bugs);
        } else {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), "No bugs found with name " + name);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @GetMapping("/getBugByProjectName/{projectName}")
    public ResponseEntity<?> getBugsByProjectName(@PathVariable String projectName) {
        List<Bug> bugs = bugService.getBugByName(projectName);
        if (!bugs.isEmpty()) {
            return ResponseEntity.ok(bugs);
        } else {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), "No bugs found for project " + projectName);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @GetMapping("/getBugbyStatus/{status}")
    public ResponseEntity<?> getBugByStatus(@PathVariable String status) {
        List<Bug> bugs = bugService.getBugbyStatus(status);
        if (!bugs.isEmpty()) {
            return ResponseEntity.ok(bugs);
        } else {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), "No bugs found with status " + status);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @DeleteMapping("/deleteBug/{id}")
    public ResponseEntity<String> deleteBug(@PathVariable Long id) {
        try {
            boolean deleted = Boolean.parseBoolean(bugService.deleteById(id));
            if (deleted) {
                return ResponseEntity.ok("Deleted");
            } else {
                ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), "Bug not found with id " + id);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse.toString());
            }
        } catch (EmptyResultDataAccessException e) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), "Bug not found with id " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse.toString());
        }
    }


}


