package com.ust.bugtracker.bugservice.model;
import org.hibernate.annotations.GenericGenerator;
import java.util.UUID;
import javax.persistence.*;


    @Entity
    @Table(name = "bugs")
    public class Bug {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
//        @GeneratedValue(strategy = GenerationType.AUTO)
//        @Column(name = "id", columnDefinition = "BINARY(16)")
        private Long id;
        @Column(nullable = false)
        private String name;

        private String description;

        private String assigner;
        private String assignee;

        private String status;

        private String projectName;

        public Bug(Long id, String name, String description, String assigner, String assignee, String status, String projectName) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.assigner = assigner;
            this.assignee = assignee;
            this.status = status;
            this.projectName = projectName;
        }

        public Bug() {
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

        public String getAssigner() {
            return assigner;
        }

        public void setAssigner(String assigner) {
            this.assigner = assigner;
        }

        public String getAssignee() {
            return assignee;
        }

        public void setAssignee(String assignee) {
            this.assignee = assignee;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getProjectName() {
            return projectName;
        }

        public void setProjectName(String projectName) {
            this.projectName = projectName;
        }
    }