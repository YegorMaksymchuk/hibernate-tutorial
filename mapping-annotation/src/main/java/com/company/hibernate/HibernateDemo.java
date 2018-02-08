package com.company.hibernate;

import com.company.hibernate.dao.DeveloperDAO;
import com.company.hibernate.dao.hibernate.DeveloperDAOImpl;

public class HibernateDemo {
    public static void main(String[] args) {
        DeveloperDAO developerDAO = new DeveloperDAOImpl();

        System.out.println(developerDAO.getById(1L));
    }
}
