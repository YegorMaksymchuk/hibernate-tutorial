package com.company.hibernate.dao.hibernate;

import com.company.hibernate.dao.DeveloperDAO;
import com.company.hibernate.model.Developer;
import com.company.hibernate.model.Project;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
        session.getTransaction().begin();
        Developer developer = session.get(Developer.class, id);
        session.getTransaction().commit();
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

    private List<Developer> getAllDevelopersByProject(Project project) {
        Session session = this.sessionFactory.openSession();

        Query query = session.createQuery("FROM Developer d " +
                "RIGHT JOIN Project p " +
                "ON d.project=p.id " +
                "WHERE p.name= :name").setParameter("name", project.getName());

        List<Object[]> devsAndProjects = query.list();
        Developer developer = null;
        List<Developer> result = null;
        for (Object[] variable : devsAndProjects) {
            developer = (Developer) devsAndProjects.get(0)[0];
            result.add(developer);
        }

        return result;
    }

    public void printAllDevelopersByProject(Project project) {
        Session session = this.sessionFactory.openSession();

        Query query = session.createQuery("FROM Developer d " +
                "RIGHT JOIN Project p " +
                "ON d.project=p.id " +
                "WHERE p.name= :name").setParameter("name", project.getName());

        List<Object[]> result = query.list();

        for (Object[] t : result) {
            Developer developer = (Developer) result.get(0)[0];
            System.out.println(developer);
            System.out.println("-------------------------------------------------------------");
            Project projects = (Project) result.get(1)[1];
            System.out.println(projects);
            System.out.println("-------------------------------------------------------------");
        }
    }

    public List<Developer> getAllBySalary(BigDecimal salary) {
        Session session = this.sessionFactory.openSession();
        Query query = session.createQuery("FROM Developer WHERE salary= :salary").setParameter("salary", salary);
        List<Developer> result = query.getResultList();
        return result;
    }

    public Developer getOneDeveloperByName(String name) {
        Session session = this.sessionFactory.openSession();
        CriteriaBuilder cb = session.getEntityManagerFactory().getCriteriaBuilder();
        CriteriaQuery criteriaQuery = cb.createQuery(Developer.class);
        Root<Developer> i = criteriaQuery.from(Developer.class);

        Query query = session.createQuery(
                criteriaQuery.select(i).where(
                        cb.equal(
                                i.get("firstName"),
                                cb.parameter(String.class, "firstName")
                        )
                )
        ).setParameter("firstName", "Ivan");

        Developer developer = (Developer) query.getSingleResult();
        return developer;
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
        session.close();
        return result;
    }
}
