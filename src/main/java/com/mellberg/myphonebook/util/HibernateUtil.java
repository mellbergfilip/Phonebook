package com.mellberg.myphonebook.util;

import com.mellberg.myphonebook.contact.Contact;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {

        SessionFactory sessionFactory = null;

        try {

            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(Contact.class);
            sessionFactory = configuration.buildSessionFactory();

        } catch (Exception e) {
            System.out.println("Failed to build SessionFactory");
            e.printStackTrace();
        }

        return sessionFactory;

    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
