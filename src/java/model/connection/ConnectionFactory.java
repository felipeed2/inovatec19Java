package model.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

public class ConnectionFactory {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            sessionFactory = new AnnotationConfiguration().configure("model/connection/hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static Session getSessionFactory() {
        return sessionFactory.openSession();
    }
    
    public static Connection getConnection() {
        Connection conn = null;
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/inovatec19", "root", "");           
        } catch (SQLException e) {
            System.out.println("Erro de conexão com o banco: "+e.getMessage());
        }
        return conn;
    }
}
