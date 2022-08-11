import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class ServiceRegistry {

    SessionFactory sessionFactory = null;

    public SessionFactory getSessionFactory(String configure) {

        try {
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure(configure).build();
            Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
            sessionFactory = metadata.getSessionFactoryBuilder().build();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return sessionFactory;
    }
}
