package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdkatatest"
                    , "root", "root");
        } catch (SQLException e) {
            throw new RuntimeException("no connection", e);
        }
        return connection;
    }

    public static SessionFactory getSessionFactory () {
        SessionFactory factory = new Configuration().configure()
                .addAnnotatedClass(User.class).buildSessionFactory();
        return factory;
    }
}
