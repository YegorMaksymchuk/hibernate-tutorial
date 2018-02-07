package com.company.hibernate.services;

import com.company.hibernate.dao.DeveloperDAO;
import com.company.hibernate.dao.ProjectDAO;
import com.company.hibernate.dao.impl.DeveloperDAOImpl;
import com.company.hibernate.dao.impl.ProjectDAOImpl;
import com.company.hibernate.model.Developer;
import com.company.hibernate.model.Project;

import java.math.BigDecimal;

public class DeveloperService {
    private DeveloperDAO devDao= new DeveloperDAOImpl();
    private Project defaultProject = new Project();
    private ProjectDAO projectDAO = new ProjectDAOImpl();

    public void addJavaDev(String name, String lastName, BigDecimal salary){

        defaultProject.setName("default");
        Developer newJavaDev = new Developer();
        newJavaDev.setProject(defaultProject);
        newJavaDev.setSalary(salary);
        newJavaDev.setSpecialty("Java Developer");
        newJavaDev.setFirstName(name);
        newJavaDev.setLastName(lastName);
        devDao.save(newJavaDev);
    }
}
