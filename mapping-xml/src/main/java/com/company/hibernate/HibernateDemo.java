package com.company.hibernate;

import com.company.hibernate.dao.DeveloperDAO;
import com.company.hibernate.dao.ProjectDAO;
import com.company.hibernate.dao.impl.DeveloperDAOImpl;
import com.company.hibernate.dao.impl.ProjectDAOImpl;
import com.company.hibernate.model.Developer;
import com.company.hibernate.model.Project;

import java.math.BigDecimal;
import java.util.List;

public class HibernateDemo {
    public static void main(String[] args) {
        ProjectDAO projectDAOImpl = new ProjectDAOImpl();
        DeveloperDAO developerDAO = new DeveloperDAOImpl();
        Project hibernate = projectDAOImpl.getById(1L);
        Developer newcomer = new Developer();
        newcomer.setFirstName("Illia");
        newcomer.setLastName("Aphonasyev");
        newcomer.setSalary(BigDecimal.valueOf(8000.00));
        newcomer.setSpecialty("Assembler");
        newcomer.setProject(hibernate);
        printer(developerDAO.getAllDeveloperSQL());

        System.exit(0);
    }

    private static void printer(List<Developer> allDeveloperSQL) {
        allDeveloperSQL.forEach(i -> System.out.println(i));
    }
}
