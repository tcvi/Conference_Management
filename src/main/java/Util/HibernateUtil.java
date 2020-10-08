package Util;

import model.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static{
        try{
            sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                    .addPackage("model")
                    .addAnnotatedClass(DiaDiem.class)
                    .addAnnotatedClass(HoiNghi.class)
                    .addAnnotatedClass(Person.class)
                    .addAnnotatedClass(DSThamGiaHN.class)
                    .buildSessionFactory();

        }catch (Throwable ex) {
            System.err.println("Session Factory could not be created." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}