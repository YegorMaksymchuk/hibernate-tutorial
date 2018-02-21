package com.company.hibernate;

import com.company.hibernate.dao.hibernate.DeveloperDAOImpl;
import com.company.hibernate.model.Project;

import java.math.BigDecimal;

public class HibernateDemoAnnotation {
    public static void main(String[] args) {
        BigDecimal salary = new BigDecimal(3000.00);
        Project project = new Project();
        project.setName("Hibernate");
        DeveloperDAOImpl developerDAO = new DeveloperDAOImpl();
        System.out.println("=======================By Salary==========================================");
        developerDAO.getAllBySalary(salary).forEach(System.out::println);
        System.out.println("=================================================================");
        System.out.println(developerDAO.getOneDeveloperByName("Ivan").toString());
        System.out.println("=================================================================");
        developerDAO.printAllDevelopersByProject(project);
        System.out.println("=================================================================");
    }
}