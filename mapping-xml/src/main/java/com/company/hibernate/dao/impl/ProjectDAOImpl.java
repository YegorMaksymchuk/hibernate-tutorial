package com.company.hibernate.dao.impl;

import com.company.hibernate.dao.ProjectDAO;
import com.company.hibernate.model.Project;
import com.company.hibernate.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ProjectDAOImpl implements ProjectDAO {


    @Override
    public void save(Project project) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(project);
        transaction.commit();
        session.close();
    }

    @Override
    public Project getById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Project project = session.get(Project.class, id);
        session.close();
        return project;
    }

    @Override
    public void remove(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Project project = session.get(Project.class, id);
        session.delete(project);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Project> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT p.name FROM Projects p");
        List<Project> result = query.list();
        session.close();
        return result;
    }
}
