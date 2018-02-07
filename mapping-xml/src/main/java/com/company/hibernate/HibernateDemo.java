package com.company.hibernate;

import com.company.hibernate.dao.DeveloperDAO;
import com.company.hibernate.dao.ProjectDAO;
import com.company.hibernate.dao.SkillDAO;
import com.company.hibernate.dao.impl.DeveloperDAOImpl;
import com.company.hibernate.dao.impl.ProjectDAOImpl;
import com.company.hibernate.dao.impl.SkillDAOImpl;
import com.company.hibernate.model.Developer;
import com.company.hibernate.model.Project;
import com.company.hibernate.model.Skill;

import java.math.BigDecimal;
import java.util.List;

public class HibernateDemo {
    public static void main(String[] args) {
        ProjectDAO projectDAO = new ProjectDAOImpl();
        DeveloperDAO developerDAO = new DeveloperDAOImpl();
        Project cloudPlatform = new Project();
        Developer newcomer = new Developer();

        cloudPlatform.setName("GCP");

        newcomer.setFirstName("Illiia");
        newcomer.setLastName("Illiin");
        newcomer.setSalary(BigDecimal.valueOf(2800.00));
        newcomer.setSpecialty("Java Developer");


        projectDAO.save(cloudPlatform);
        newcomer.setProject(cloudPlatform);
        developerDAO.save(newcomer);

        printer(developerDAO.getAllDeveloperSQL());
        System.exit(0);
    }

    private static void printer(List<Developer> allDeveloperSQL) {
        allDeveloperSQL.forEach(i -> System.out.println(i.toString()));
    }
}
