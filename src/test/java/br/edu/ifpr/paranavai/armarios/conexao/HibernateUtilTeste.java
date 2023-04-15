package br.edu.ifpr.paranavai.armarios.conexao;

import br.edu.ifpr.paranavai.armarios.utils.MensagemUtil;
import org.hibernate.SessionFactory;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtilTeste {

    private static SessionFactory SESSION_FACTORY;

    static {
        try {
            // Cria um registro de serviço com o arquivo de configuração específico
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure("hibernate-test.cfg.xml")
                    .build();
            
            SESSION_FACTORY = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory();
            getSession();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() {
        return SESSION_FACTORY.openSession();
    }
    
    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

    public static void encerraSession() {
        SESSION_FACTORY.close();
    }
}
