package com.company.hibernate.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name="developer_id")
    private Long developer_id;

    @OneToMany(mappedBy = "project")
    private Set<Developer> developers = new HashSet<>(0);

    public Project() {
    }

    public Project(Long id, String name, Long developer_id) {
        this.id = id;
        this.name = name;
        this.developer_id = developer_id;
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

    public Long getDeveloper_id() {
        return developer_id;
    }

    public void setDeveloper_id(Long developer_id) {
        this.developer_id = developer_id;
    }


    public Set<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<Developer> developers) {
        this.developers = developers;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", developer_id=" + developer_id +
                ", developers=" + developers +
                '}';
    }
}
