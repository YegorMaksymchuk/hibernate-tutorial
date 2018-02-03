package com.company.hibernate.dao.impl;

import com.company.hibernate.dao.DeveloperDAO;
import com.company.hibernate.model.Developer;
import com.company.hibernate.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.List;

public class DeveloperDAOImpl implements DeveloperDAO {

    @Override
    public void save(Developer developer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(developer);

        transaction.commit();
        session.close();
    }

    @Override
    public Developer getById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Developer developer = session.get(Developer.class, id);
        session.close();
        return developer;
    }

    @Override
    public void remove(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Developer developer = session.get(Developer.class, id);
        session.delete(developer);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Developer> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT d.lastName FROM Developer d");
        List<Developer> result = query.list();
        session.close();
        return result;
    }

    @Override
    public List<Developer> getAllBySpecialty(String specialty) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Developer d where d.specialty= :specialty");
        query.setParameter("specialty", specialty);
        List<Developer> result = query.list();
        session.close();
        return result;
    }

    @Override
    public List<Developer> getDeveloperWithSalaryAbove(BigDecimal salary) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Criteria criteria = session.createCriteria(Developer.class);
        criteria.add(Restrictions.gt("salary", salary));

        List<Developer> result = criteria.list();
        session.close();

        return result;
    }

    @Override
    public List<Developer> getAllDeveloperSQL() {
        Session session = HibernateUtil.getSessionFactory().openSession(); //this.sessionFactory.openSession();

        NativeQuery sqlQuery = session.createNativeQuery("SELECT * FROM developers");
        sqlQuery.addEntity(Developer.class);
        List<Developer> result = sqlQuery.list();

        session.close();
        return result;
    }
}
