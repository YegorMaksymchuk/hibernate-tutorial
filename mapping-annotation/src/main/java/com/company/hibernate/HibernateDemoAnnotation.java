package com.company.hibernate;

import com.company.hibernate.dao.DeveloperDAO;
import com.company.hibernate.dao.hibernate.DeveloperDAOImpl;

public class HibernateDemoAnnotation {
    public static void main(String[] args) {
        DeveloperDAO developerDAO = new DeveloperDAOImpl();

        System.out.println(developerDAO.getById(1L));
    }
}
/*
 *
 * 1. fetch-“join” = Disable the lazy loading, always load all the collections and entities.
 * 2. fetch-“select” (default) = Lazy load all the collections and entities.
 * 3. batch-size=”N” = Fetching up to ‘N’ collections or entities, *Not record*.
 * 4. fetch-“subselect” = Group its collection into a sub select statement.
 *
 * */