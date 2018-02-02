package com.company.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="projects")
public class Project {
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name="developer_id")
    private Long developer_id;

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

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", developer_id=" + developer_id +
                '}';
    }
}
