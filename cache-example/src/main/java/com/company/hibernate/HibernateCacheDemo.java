package com.company.hibernate;


import com.company.hibernate.model.Developer;
import com.company.hibernate.model.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HibernateCacheDemo {
    public static final int BATCH_SIZE = 50;

    private static long time;
    private SessionFactory sessionFactory;

    public HibernateCacheDemo() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    private static void startTimer() {
        time = System.currentTimeMillis();
    }

    private static void stopTimer() {
        long end = System.currentTimeMillis();
        System.out.println("EXECUTE TIME: " + (end - time));
    }

    public static void demonstrateLevelOneCacheWork() {
        HibernateCacheDemo app = new HibernateCacheDemo();

        app.clearAll();
        app.addProjects(1);

        System.out.println();
        System.out.println("Begin level one cache DIFFERENT sessions");
        app.readFirstInsituteInDifferentSessions();
        System.out.println("End level one cache DIFFERENT sessions");

        System.out.println();

        System.out.println("Begin level one cache THE SAME session");
        app.readFirstProjectInTheSameSession();
        System.out.println("End level one cache THE SAME session");
    }

    public static void demonstrateLevelTwoCacheWork() {
        HibernateCacheDemo app = new HibernateCacheDemo();

        app.clearAll();
        app.addProjects(1);

        System.out.println();
        System.out.println("Begin level two cache DIFFERENT sessions");
        app.readFirstInsituteInDifferentSessions();
        System.out.println("End level two cache DIFFERENT sessions");
    }

    public static void demonstrateLevelTwoDependenciesCacheWork() {
        HibernateCacheDemo app = new HibernateCacheDemo();

        app.clearAll();

        Project Project = new Project();
        app.addDevelopers(Project, 1);
        app.addProject(Project);

        System.out.println();
        System.out.println("Begin level two cache DIFFERENT sessions");
        startTimer();
        for (int i = 0; i < 50000; i++) {
            app.readFirstInsituteInDifferentSessions();
        }
        stopTimer();
        System.out.println("End level two cache DIFFERENT sessions");
    }

    public static void demonstrateBatching() {
        HibernateCacheDemo app = new HibernateCacheDemo();
        app.clearAll();

        Session session = app.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        startTimer();

        for (int i = 0; i < 10000; i++) {

            Project Project = new Project();
            app.addDevelopers(Project, 1);
            session.save(Project);

            if (i % BATCH_SIZE == 0) {
                session.flush();
                session.clear();
            }

            if (i % 1000 == 0) {
                System.out.println(i);
            }
        }

        transaction.commit();
        session.close();

        stopTimer();
    }

    public void clearAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.createSQLQuery("DELETE FROM Developer").executeUpdate();
        session.createSQLQuery("DELETE FROM projects").executeUpdate();
        transaction.commit();
        session.close();
    }

    public void addProject(Project project) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(project);
        transaction.commit();
        session.close();
    }

    public Project getProjectById(int id) {
        Session session = sessionFactory.openSession();
        Project result = (Project) session.get(Project.class, id);
        session.close();
        return result;
    }

    public void addProjects(int amount) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        for (int i = 0; i < amount; i++) {
            session.persist(new Project());
        }
        transaction.commit();
        session.close();
    }

    public void addDevelopers(Project Project, int amount) {
        Set<Developer> Developers = new HashSet<Developer>();

        for (int i = 0; i < amount; i++) {
            Developer developer = new Developer();

            Developers.add(developer);
        }

        Project.setDevelopers(Developers);
    }

    public List<Integer> getProjectsIds() {
        Session session = sessionFactory.openSession();
        List<Integer> result = session.createQuery("select id from Project").setCacheable(true).list();
        session.close();
        return result;
    }

    public int getFirstProjectdId() {
        return getProjectsIds().get(0);
    }

    public void readFirstInsituteInDifferentSessions() {
        int id = getFirstProjectdId();

        Session session = sessionFactory.openSession();
        session.get(Project.class, id);
        session.close();

        session = sessionFactory.openSession();
        session.get(Project.class, id);
        session.close();
    }

    public void readFirstProjectInTheSameSession() {
        int id = getFirstProjectdId();

        Session session = sessionFactory.openSession();
        session.get(Project.class, id);
        session.get(Project.class, id);
        session.close();
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