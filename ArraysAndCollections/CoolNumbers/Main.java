import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер для поиска: ");
        String number = scanner.nextLine();


        List<String> list = CoolNumbers.generateCoolNumbers();
        CoolNumbers.bruteForceSearchInList(list, number);

        Collections.sort(list);
        CoolNumbers.binarySearchInList(list, number);

        HashSet<String> hasSet = new HashSet<>(CoolNumbers.generateCoolNumbers());
        CoolNumbers.searchInHashSet(hasSet, number);

        TreeSet<String> treeSet = new TreeSet<>(CoolNumbers.generateCoolNumbers());
        CoolNumbers.searchInTreeSet(treeSet, number);

    }
}
