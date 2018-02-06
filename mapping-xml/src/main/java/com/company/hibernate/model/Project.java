package com.company.hibernate.model;

import java.util.HashSet;
import java.util.Set;

public class Project {
    private Long id;
    private String name;
    private Set<Developer> developers = new HashSet<>();

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

    public Set<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<Developer> developers) {
        this.developers = developers;
    }

}
