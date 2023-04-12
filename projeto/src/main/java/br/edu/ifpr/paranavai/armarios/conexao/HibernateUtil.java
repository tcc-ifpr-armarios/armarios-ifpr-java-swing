package br.edu.ifpr.paranavai.armarios.conexao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory SESSION_FACTORY;

    static {
        try {
// Criação da SessionFactory a partir do hibernate.cfg.xml
            SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
            getSession();
        } catch (Throwable ex) {
            System.err.println("Criação oi Inicial da SessionFactory falhou! " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() {
        return SESSION_FACTORY.openSession();
    }

    public static void encerraSession() {
        SESSION_FACTORY.close();
    }
}
