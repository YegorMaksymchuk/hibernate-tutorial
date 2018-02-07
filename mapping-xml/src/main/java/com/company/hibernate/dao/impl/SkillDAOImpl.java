package com.company.hibernate.dao.impl;

import com.company.hibernate.dao.SkillDAO;
import com.company.hibernate.model.Skill;
import com.company.hibernate.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class SkillDAOImpl implements SkillDAO {
    @Override
    public void save(Skill skill) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(skill);

        transaction.commit();
        session.close();
    }

    @Override
    public Skill getById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Skill skill = session.get(Skill.class, id);
        session.close();
        return skill;
    }

    @Override
    public void remove(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Skill skill = session.get(Skill.class, id);
        session.delete(skill);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Skill> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT s.skill FROM Skills s");
        List<Skill> result = query.list();
        session.close();
        return result;
    }
}
