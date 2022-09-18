import java.util.Scanner;

public class Main {
    private static EmailList emailList = new EmailList();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            String email = input.replace(Operation.ADD.getTitle(), "").trim();
            if (input.equals("0")) {
                break;
            } else if (input.contains(Operation.ADD.getTitle())) {
                emailList.add(email);
            } else if (input.contains(Operation.LIST.getTitle())) {
                for (int i = 0; i < emailList.getSortedEmails().size(); i++) {
                    System.out.println(emailList.getSortedEmails().hashCode());
                }
            }
        }
    }
}
