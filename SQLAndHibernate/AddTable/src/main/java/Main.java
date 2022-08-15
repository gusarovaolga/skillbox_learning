import Entity.KeyLinkedPurchaseList;
import Entity.LinkedPurchaseList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        String configure = "hibernate.cfg.xml";
        ServiceRegistry serviceRegistry = new ServiceRegistry();
        SessionFactory sessionFactory = serviceRegistry.getSessionFactory(configure);

        Session session = sessionFactory.openSession();

        String sql = "SELECT new Entity.LinkedPurchaseList (st.id, c.id) " +
                " FROM PurchaseList pl " +
                " join Student st ON st.name = pl.studentName" +
                " join Course c ON c.name = pl.courseName";

        List<LinkedPurchaseList> linkedList = session.createQuery(sql).getResultList();
        for (LinkedPurchaseList linked : linkedList) {
            System.out.println(linked.getCourseId() + " " + linked.getStudentId());
        }

        try {
            Transaction transaction = session.beginTransaction();
            for (LinkedPurchaseList list : linkedList) {
                LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();
                linkedPurchaseList.setId(new KeyLinkedPurchaseList(list.getStudentId(), list.getCourseId()));
                linkedPurchaseList.setStudentId(list.getStudentId());
                linkedPurchaseList.setCourseId(list.getCourseId());
                session.save(linkedPurchaseList);
            }
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        sessionFactory.close();
    }
}
