
package br.com.controle.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author Rafael Banderia 
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory ;
    public static  final String HIBERNATE_SESSION = "hibernate_session";
  
        
    static {
        try {
            System.out.println("Tentando abrir uma SF");
        Configuration configuration = new Configuration().configure();
                ServiceRegistry serviceregistry = new 
        ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
    
    sessionFactory = configuration.buildSessionFactory(serviceregistry);
            System.out.println("SF criada com sucsso!");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao abrir uma SF. "+ e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
}
