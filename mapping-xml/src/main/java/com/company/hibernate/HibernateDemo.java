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
import com.company.hibernate.services.DeveloperService;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

public class HibernateDemo {
    public static void main(String[] args) {


        DeveloperDAO developerDAO = new DeveloperDAOImpl();

        DeveloperService developerService = new DeveloperService();
        developerService.addJavaDev("Alex", "Nazarchuk", BigDecimal.valueOf(1000.00));
        printer(developerDAO.getAllDeveloperSQL());
        System.exit(0);
    }

    private static void printer(List<Developer> allDeveloperSQL) {
        allDeveloperSQL.forEach(i -> System.out.println(i.toString()));
    }
}
