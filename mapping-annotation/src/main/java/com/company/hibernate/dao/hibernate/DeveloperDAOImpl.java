package com.company.hibernate.dao.hibernate;

import com.company.hibernate.dao.DeveloperDAO;
import com.company.hibernate.model.Developer;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.List;

public class DeveloperDAOImpl implements DeveloperDAO {

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void save(Developer developer) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(developer);
        transaction.commit();
        session.close();
    }

    public Developer getById(Long id) {
        Session session = this.sessionFactory.openSession();
        Developer developer = session.get(Developer.class, id);
        session.close();
        return developer;
    }

    public void remove(Long id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Developer developer = session.get(Developer.class, id);
        session.delete(developer);
        transaction.commit();
        session.close();
    }

    public List<Developer> getAll() {
        Session session = this.sessionFactory.openSession();
        Query query = session.createQuery("SELECT d.lastName FROM Developer d");
        List<Developer> result = query.list();
        session.close();
        return result;
    }

    public List<Developer> getAllBySpecialty(String specialty) {
        Session session = this.sessionFactory.openSession();
        Query query = session.createQuery("FROM Developer d where d.specialty= :specialty");
        query.setParameter("specialty", specialty);
        List<Developer> result = query.list();
        session.close();
        return result;
    }

    public List<Developer> getDeveloperWithSalaryAbove(BigDecimal salary) {
        Session session = this.sessionFactory.openSession();

        Criteria criteria = session.createCriteria(Developer.class);
        criteria.add(Restrictions.gt("salary", salary));

        List<Developer> result = criteria.list();
        session.close();

        return result;
    }

    public List<Developer> getAllDeveloperSQL() {
        Session session = this.sessionFactory.openSession();

        SQLQuery sqlQuery = session.createSQLQuery("SELECT * FROM developers");
        sqlQuery.addEntity(Developer.class);
        List<Developer> result = sqlQuery.list();
        result.forEach(System.out::println);
        session.close();
        return result;
    }
}
