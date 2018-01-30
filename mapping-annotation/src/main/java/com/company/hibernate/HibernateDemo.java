package com.company.hibernate;

import com.company.hibernate.dao.DeveloperDAO;
import com.company.hibernate.dao.hibernate.HibernateDeveloperDAOImpl;

public class HibernateDemo {
    public static void main(String[] args) {
        DeveloperDAO developerDAO = new HibernateDeveloperDAOImpl();

        System.out.println(developerDAO.getAllDeveloperSQL());
    }
}
