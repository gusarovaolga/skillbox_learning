import java.util.*;

public class CoolNumbers {

    private static List<String> coolNumbersList = new ArrayList<>();
    private static String[] letters = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
    private static String[] coolDigits = {"111", "222", "333", "444", "555", "666", "777", "888", "999"};
    private static String searchName;
    private static String isFind;


    public static List<String> generateCoolNumbers() {

        for (String firstLetter : letters) {
            for (String digit : coolDigits) {
                for (String secondLetter : letters) {
                    for (String thirdLetter : letters) {

                        for (int j = 1; j <= 199; j++) {
                            String region = String.valueOf(j);
                            if (j < 10) {
                                region = "0" + region;
                            }
                            String coolNumber = firstLetter + digit + secondLetter + thirdLetter + region;
                            coolNumbersList.add(coolNumber);

                            if (coolNumbersList.size() >= 2_000_000) {
                                break;
                            }
                        }
                    }
                }
            }
        }
        return coolNumbersList;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        searchName = "Поиск перебором";
        long start = currentTime();

        for (String num : list) {
            if (number.equals(num)) {
                long time = currentTime() - start;
                isFind = "номер найден";
                printSearchMessage(searchName, isFind, time);
                return true;
            }
        }

        isFind = "не найден";
        long time = currentTime() - start;
        printSearchMessage(searchName, isFind, time);
        return false;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        searchName = "Бинарный поиск";
        int index = Collections.binarySearch(sortedList, number);
        long start = currentTime();

        if (index >= 0) {
            long time = currentTime() - start;
            isFind = "номер найден";
            printSearchMessage(searchName, isFind, time);
            return true;
        }

        isFind = "не найден";
        long time = currentTime() - start;
        printSearchMessage(searchName, isFind, time);
        return false;
    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        searchName = "Поиск в HashSet";
        long start = currentTime();

        for (String s : hashSet) {
            if (number.equals(s)) {
                long time = currentTime() - start;
                isFind = "номер найден";
                printSearchMessage(searchName, isFind, time);
                return true;
            }
        }

        isFind = "не найден";
        long time = currentTime() - start;
        printSearchMessage(searchName, isFind, time);
        return false;
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        searchName = "Поиск в TreeSet";
        long start = currentTime();

        for (String s : treeSet) {
            if (number.equals(s)) {
                long time = currentTime() - start;
                isFind = "номер найден";
                printSearchMessage(searchName, isFind, time);
                return true;
            }
        }

        isFind = "не найден";
        long time = currentTime() - start;
        printSearchMessage(searchName, isFind, time);
        return false;
    }

    private static void printSearchMessage(String searchName, String isFind, long time) {
        System.out.println(searchName + ": " + isFind + ", поиск занял " + time + " нс");
    }

    private static long currentTime() {
        return System.nanoTime();
    }
}
