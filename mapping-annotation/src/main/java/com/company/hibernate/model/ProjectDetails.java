package com.company.hibernate.model;

import javax.persistence.*;

@Entity
@Table(name = "projects_details")
public class ProjectDetails {
    @Id
    @Column(name = "project_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "projectDetails", cascade = CascadeType.ALL)
    private Project project;

    @Override
    public String toString() {
        return "ProjectDetails{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
