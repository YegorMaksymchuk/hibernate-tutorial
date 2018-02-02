package com.company.hibernate;

import com.company.hibernate.dao.DeveloperDAO;
import com.company.hibernate.dao.hibernate.DeveloperDAOImpl;
import com.company.hibernate.model.Developer;

import java.util.List;

public class HibernateDemo {
    public static void main(String[] args) {
        DeveloperDAO developerDAO = new DeveloperDAOImpl();

        printer(developerDAO.getAllDeveloperSQL());

        System.exit(0);
    }

    private static void printer(List<Developer> allDeveloperSQL) {
        allDeveloperSQL.forEach(i -> System.out.println(i));
    }
}
