import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static TodoList todoList = new TodoList();
    private static int index;

    public static void main(String[] args) {
        System.out.println("Введите название дела: ");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String todo = scanner.nextLine().trim();
            if (todo.equals("0")) {
                scanner.close();
                System.out.println("Завершение программы");
                break;
            }

            Pattern pattern = Pattern.compile("[0-9]+");
            Matcher matcher = pattern.matcher(todo);
            int end = 0;

            while (matcher.find()) {
                int start = matcher.start();
                end = matcher.end();
                index = Integer.parseInt(todo.substring(start, end));
            }

            if (todo.contains(Operation.ADD.getTitle())) {
                if (matcher.find()) {
                    todoList.add(index, todo.substring(end));
                } else {
                    todoList.add(todo);
                }
            } else if (todo.contains(Operation.DELETE.getTitle())) {
                todoList.delete(index);
            } else if (todo.contains(Operation.EDIT.getTitle())) {
                todoList.edit(index, todo.substring(end));
            } else if (todo.contains(Operation.LIST.getTitle())) {
                for (int i = 0; i < todoList.getTodos().size(); i++) {
                    System.out.println(i + " - " + todoList.getTodos().get(i));
                }
            }
        }
    }
}
