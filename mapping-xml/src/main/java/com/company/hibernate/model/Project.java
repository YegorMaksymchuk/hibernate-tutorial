package com.company.hibernate.model;


import java.util.HashSet;
import java.util.Set;

public class Project {
    private Long id;
    private String name;
    private ProjectDetails projectDetails;
    private Set<Developer> developer = new HashSet<>();

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

    public ProjectDetails getProjectDetails() {
        return projectDetails;
    }

    public void setProjectDetails(ProjectDetails projectDetails) {
        this.projectDetails = projectDetails;
    }

    public Set<Developer> getDeveloper() {
        return developer;
    }

    public void setDeveloper(Set<Developer> developer) {
        this.developer = developer;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", projectDetails=" + projectDetails +
                '}';
    }
}
