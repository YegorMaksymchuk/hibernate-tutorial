package com.company.hibernate;

import com.company.hibernate.dao.DeveloperDAO;
import com.company.hibernate.dao.impl.DeveloperDAOImpl;

public class HibernateDemo {
    public static void main(String[] args) {
        DeveloperDAO developerDAO = new DeveloperDAOImpl();
        developerDAO.getAllDeveloperSQL();
        System.exit(0);
    }

}
