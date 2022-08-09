import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String[] components = data.split("\\s+");
        if (components.length != 4) {

            throw new IllegalArgumentException("Wrong format. Correct format: " +
                    "\nadd Василий Петров vasily.petrov@gmail.com +79215637722");
        }
        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        if (!name.matches("[A-Za-zА-Яа-я\\s]+")) {
            throw new IllegalArgumentException("Wrong format name");
        }
        if (!components[INDEX_PHONE].matches("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$")) {
            throw new IllegalArgumentException("Wrong format phone");
        }
        if (!components[INDEX_EMAIL].matches("^([A-Za-z0-9_\\.-]+)@([A-Za-z0-9_\\.-]+)\\.([A-Za-z\\.]{2,6})$")) {
            throw new IllegalArgumentException("Wrong format email");
        }
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() {
        if (storage.isEmpty()) {
            System.out.println("There are not customers");
        }
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        if (storage.isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("list is empty");
        }
        if (!storage.containsKey(name)) {
            System.out.println("this name is not on the list");
        }
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}