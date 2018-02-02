package com.company.hibernate.model;

public class Skills {
    private Long id;
    private String skills;
    private Long developer_id;

    public Skills() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public Long getDeveloper_id() {
        return developer_id;
    }

    public void setDeveloper_id(Long developer_id) {
        this.developer_id = developer_id;
    }
}
