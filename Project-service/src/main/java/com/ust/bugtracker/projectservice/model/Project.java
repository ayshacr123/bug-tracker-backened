package com.ust.bugtracker.projectservice.model;

import javax.persistence.*;

@Entity

@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

//    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
//@OneToMany(targetEntity=Bug.class,
//        cascade= CascadeType.ALL
//)
//@JoinColumn(name="project_id", referencedColumnName = "id")
//    private List<Bug> bugs;

    public Project(Long id, String name, String description/*, List<Bug> bugs*/) {
        this.id = id;
        this.name = name;
        this.description = description;
//        this.bugs = bugs;
    }

    public Project() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public List<Bug> getBugs() {
//        return bugs;
//    }
//
//    public void setBugs(List<Bug> bugs) {
//        this.bugs = bugs;
//    }
}