import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
public class TodoList {

    private List<String> todoListArray = new ArrayList<>();

    public void add(String todo) {
        todo = todo.replace(Operation.ADD.getTitle(), "").trim();
        todoListArray.add(todo);
        System.out.println("Добавлено дело " + "\"" + todo + "\"");
    }

    public void add(int index, String todo) {
        todo = todo.replace(Operation.ADD.getTitle(), "").trim();
        if (index < 0 || index > todoListArray.size() - 1) {
            todoListArray.add(todo);
        } else {
            todoListArray.add(index, todo);
            todo = todoListArray.get(index);
        }
        System.out.println("Добавлено дело " + "\"" + todo + "\"");
    }

    public void edit(int index, String todo) {
        todo = todo.replace(Operation.EDIT.getTitle(), "").trim();
        if (index < 0 || index > todoListArray.size() - 1) {
            System.out.println("Дело с таким номером не существует");
        } else {
            String todoOld = todoListArray.get(index);
            todoListArray.set(index, todo);
            System.out.println("Дело " + "\"" + todoOld + "\"" + " заменено на дело " + "\"" + todo + "\"");
        }
    }

    public void delete(int index) {
        if (index < 0 || index > todoListArray.size() - 1) {
            System.out.println("Дело с таким номером не существует");
        } else {
            String todo = todoListArray.get(index);
            todoListArray.remove(index);
            System.out.println("Дело " + "\"" + todo + "\"" + " удалено");
        }
    }

    public List<String> getTodos() {
        return todoListArray;
    }

}