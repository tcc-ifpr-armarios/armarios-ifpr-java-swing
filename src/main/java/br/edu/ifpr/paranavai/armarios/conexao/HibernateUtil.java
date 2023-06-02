package br.edu.ifpr.paranavai.armarios.conexao;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import br.edu.ifpr.paranavai.armarios.utils.MensagemUtil;

public class HibernateUtil {

    private static SessionFactory SESSION_FACTORY;

    static {
        try {
            // Cria um registro de serviço com o arquivo de configuração específico
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml")
                    .build();
            
            SESSION_FACTORY = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory();
            getSession();
        } catch (Throwable ex) {
            JOptionPane.showMessageDialog(null, MensagemUtil.ERRO_CONFIGURACAO_BANCO, MensagemUtil.TITULO_ERRO_FATAL , JOptionPane.ERROR_MESSAGE);
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
