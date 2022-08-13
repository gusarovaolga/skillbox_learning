import Entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {

    public static void main(String[] args) {

        String configure = "hibernate.cfg.xml";
        ServiceRegistry serviceRegistry = new ServiceRegistry();
        SessionFactory sessionFactory = serviceRegistry.getSessionFactory(configure);
        Session session = sessionFactory.openSession();
        
        Transaction transaction = session.beginTransaction();

        Course course = session.get(Course.class, 1);
        Student student = session.get(Student.class, 2);

        Subscription subscription = session
                .get(Subscription.class, new KeySubscription(student.getId(), course.getId()));
        PurchaseList purchaseList = session.get(PurchaseList.class, new KeyPurchaseList(student.getName(), course.getName()));

        System.out.println("Студент: " + subscription.getStudent().getName() +
                " (название курса - " + purchaseList.getCourseName()
                + "; дата и стоимость подписки: " + purchaseList.getSubscriptionDate() + " " +
                purchaseList.getPrice() + ")");

        transaction.commit();
        sessionFactory.close();
    }
}
