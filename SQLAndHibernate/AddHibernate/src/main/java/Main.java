import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {

    public static void main(String[] args) {

            String configure = "hibernate.cfg.xml";
            ServiceRegistry serviceRegistry = new ServiceRegistry();
            SessionFactory sessionFactory = serviceRegistry.getSessionFactory(configure);
            Session session = sessionFactory.openSession();

            Course course = session.get(Course.class, 1);
            System.out.println("Название курса: " + course.getName() + System.lineSeparator() +
                    "количество студентов на курсе: " + course.getStudentsCount() + " человек");

            Students student = session.get(Students.class, 10);
            System.out.println("Имя студента: " + student.getName() +
                    " (дата регистрации - " + student.getRegistrationDate() + ")");

            sessionFactory.close();
    }
}
