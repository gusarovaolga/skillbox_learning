import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class EmailList {

    private List<String> emailsList = new LinkedList<>();
    private Set<String> emailSet = new TreeSet<>();

    public void add(String email) {

        String regex = "^([A-Za-z0-9_\\.-]+)@([A-Za-z0-9_\\.-]+)\\.([A-Za-z\\.]{2,6})$";

        if (email.matches(regex)) {
            emailSet.add(email.toLowerCase());
            System.out.println(email.toLowerCase());
        } else {
            System.out.println("Неверный формат email");
        }
    }

    public List<String> getSortedEmails() {
        emailsList.addAll(emailSet);
        return emailsList;
    }
}
