package com.ust.bugtracker.bugservice.repository;



import com.ust.bugtracker.bugservice.model.Bug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BugRepository extends JpaRepository<Bug, Long> {

    List<Bug> findByName(String name);

    List<Bug> findByStatus(String status);

    List<Bug> findByProjectName(String projectName);
}
