package com.ust.bugtracker.bugservice.service;

import com.ust.bugtracker.bugservice.model.Bug;
import com.ust.bugtracker.bugservice.repository.BugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class BugServiceImpl implements BugService{

    @Autowired
    private BugRepository bugRepository;
    @Override
    public List<Bug> getAll() {
        return bugRepository.findAll();
    }

    @Override
    public Optional<Bug> getById(Long id) {
        return bugRepository.findById(id);
    }

    @Override
    public Bug create(Bug bug) {
        return bugRepository.save(bug);
    }

    @Override
    public Bug updateById(Long id, Bug bug) {


        return bugRepository.save(bug);
    }

    @Override
    public String deleteById(Long id) {
        bugRepository.deleteById(id);
        return "Deleted";
    }

    @Override
    public List<Bug> getBugbyNAme(String name) {
        return bugRepository.findByName(name);
    }

    @Override
    public List<Bug> getBugbyStatus(String status) {
        return bugRepository.findByStatus(status);
    }

    @Override
    public List<Bug> getBugByName(String projectName) {
        return bugRepository.findByProjectName(projectName);
    }
}
