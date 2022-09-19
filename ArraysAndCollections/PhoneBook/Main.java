import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static final String INPUT_MESSAGE = "Введите номер, имя или команду:";
    public static final String COMMAND_LIST = "LIST";
    public static final String MESSAGE_FOR_NOT_NAME = "Такого имени в телефонной книге нет." +
            "\nВведите номер телефона для абонента ";
    public static final String MESSAGE_FOR_NOT_PHONE = "Такого номера нет в телефонной книге." +
            "\nВведите имя абонента для номера ";
    public static final String ERROR_MESSAGE = "Неверный формат ввода";
    public static final String MESSAGE_FOR_EMPTY_LIST = "Список контактов пуст";
    public static final String SAVE_CONTACT_MESSAGE = "Контакт сохранен!";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();

        while (true) {
            System.out.println(INPUT_MESSAGE);
            String input = scanner.nextLine();
            if (input.equals(COMMAND_LIST)) {

                Set<String> contactList = phoneBook.getAllContacts();
                for(String contact : contactList) {
                    System.out.println(contact);
                }

            } else if (phoneBook.isName(input)) {
                String name = input;
                if (phoneBook.getNamesAndPhones().containsKey(name)) {
                    phoneBook.getContactByName(name);
                } else {
                    System.out.println(MESSAGE_FOR_NOT_NAME + name);
                    input = scanner.nextLine();
                    if (phoneBook.isPhone(input)) {
                        phoneBook.addContact(input, name);
                    }
                }
            } else if (phoneBook.isPhone(input)) {
                String phone = input;
                for (Map.Entry<String, Set<String>> entry : phoneBook.getNamesAndPhones().entrySet()) {
                    if (!entry.getValue().contains(phone)) {
                        System.out.println( MESSAGE_FOR_NOT_PHONE + phone);
                        input = scanner.nextLine();
                        if (phoneBook.isName(input)) {
                            phoneBook.addContact(phone, input);
                        }
                    }
                }
            } else {
                System.out.println(ERROR_MESSAGE);
            }
        }
    }
}
