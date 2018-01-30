package net.proselyte.hibernate;

import net.proselyte.hibernate.dao.DeveloperDAO;
import net.proselyte.hibernate.dao.hibernate.HibernateDeveloperDAOImpl;

public class HibernateDemo {
    public static void main(String[] args) {
        DeveloperDAO developerDAO = new HibernateDeveloperDAOImpl();

        System.out.println(developerDAO.getAllDeveloperSQL());
    }
}
