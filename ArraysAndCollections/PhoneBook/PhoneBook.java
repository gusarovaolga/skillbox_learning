import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class PhoneBook {

    private final String REGEX_NAME = "[А-Яа-яЁё]+";
    private final String REGEX_PHONE = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";
    private Map<String, Set<String>> namesAndPhones = new TreeMap<>();

    public Map<String, Set<String>> getNamesAndPhones() {
        return namesAndPhones;
    }

    public void addContact(String phone, String name) {
        if (isName(name) && isPhone(phone)) {
            Set<String> numbers;
            if (namesAndPhones.containsKey(name)) {
                numbers = namesAndPhones.get(name);
            } else {
                numbers = new TreeSet<>();
            }

            for (Map.Entry<String, Set<String>> entry : namesAndPhones.entrySet()) {

                if (entry.getValue().contains(phone)) {
                    namesAndPhones.remove(entry.getKey());
                }
            }

            numbers.add(phone);
            namesAndPhones.put(name, numbers);
            System.out.println(Main.SAVE_CONTACT_MESSAGE);

        } else {
            System.out.println(Main.ERROR_MESSAGE);
        }
    }

    public boolean isName(String input) {
        return input.matches(REGEX_NAME);
    }

    public boolean isPhone(String input) {
        return input.matches(REGEX_PHONE);
    }

    public String getContactByPhone(String phone) {

        for (Map.Entry<String, Set<String>> entry : namesAndPhones.entrySet()) {
            String name = entry.getKey();
            if (entry.getValue().contains(phone)) {
                return name + " - " + namesAndPhones.get(name).stream().collect(Collectors.joining(", "));
            }
        }
        return "";
    }

    public Set<String> getContactByName(String name) {

        if (namesAndPhones.containsKey(name)) {
            Set<String> contact = namesAndPhones.get(name);
            String phones = name + " - " + contact.stream().collect(Collectors.joining(", "));
            return Set.of(phones);
        } else {
            return new TreeSet<>();
        }
    }

    public Set<String> getAllContacts() {
        Set<String> contacts = new TreeSet<>();
        if (!namesAndPhones.isEmpty()) {
            for (Map.Entry<String, Set<String>> entry : namesAndPhones.entrySet()) {
                String name = entry.getKey();
                Set<String> value = entry.getValue();
                String phones = value.stream().collect(Collectors.joining(", "));
                String contact = name + " - " + phones;
                contacts.add(contact);
            }
        } else {
            System.out.println(Main.MESSAGE_FOR_EMPTY_LIST);
        }
        return contacts;
    }
}