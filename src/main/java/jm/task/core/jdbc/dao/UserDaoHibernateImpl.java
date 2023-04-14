package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

import static jm.task.core.jdbc.util.Util.getSessionFactory;

public class UserDaoHibernateImpl implements UserDao {
    SessionFactory factory = getSessionFactory();
    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        String sql = "create table if not exists users" +
                "(id int not null auto_increment, name varchar(255), " +
                "lastname varchar(255), age tinyint, primary key (id))";
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.createSQLQuery(sql).addEntity(User.class).executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void dropUsersTable() {
        String sql = "drop table if exists users";
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.createSQLQuery(sql).addEntity(User.class).executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.save(new User(name, lastName, age));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void removeUserById(long id) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.remove(session.get(User.class, id));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<User> getAllUsers() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<User> result = session.createQuery("from User").getResultList();
        session.getTransaction().commit();
        session.close();
        return result;
    }
    @Override
    public void cleanUsersTable() {
        String sql = "truncate users";
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.createSQLQuery(sql).addEntity(User.class).executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}