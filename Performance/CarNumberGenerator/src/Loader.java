import java.io.PrintWriter;

public class Loader {

    public static final char[] letters = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};

    public static void main(String[] args) throws Exception {

        //для одного потока
        PrintWriter writer = new PrintWriter("res/numbers.txt");
        long startLoadInOneThread = System.currentTimeMillis();
        for (int regionCode = 1; regionCode < 100; regionCode++) {

            StringBuilder builder = new StringBuilder();
            for (int number = 1; number < 1000; number++) {

                for (char firstLetter : letters) {
                    for (char secondLetter : letters) {
                        for (char thirdLetter : letters) {

                            builder.append(firstLetter)
                                    .append(padNumber(number, 3))
                                    .append(secondLetter)
                                    .append(thirdLetter)
                                    .append(padNumber(regionCode, 2))
                                    .append(System.lineSeparator());
                        }
                    }
                }
            }
            writer.write(builder.toString());
        }
        writer.flush();
        writer.close();

        System.out.println("Время выполнения программы одним потоком: " + (System.currentTimeMillis() - startLoadInOneThread) + " ms");

        //для нескольких потоков
        long startLoadWithThreads = System.currentTimeMillis();
        CarNumberLoader loader = new CarNumberLoader();
        loader.loadCarNumber();

        System.out.println("Время выполнения программы несколькими потоками: "
                + (System.currentTimeMillis() - startLoadWithThreads) + " ms");
    }

    private static StringBuilder padNumber(int number, int numberLength) {
        StringBuilder padNumber = new StringBuilder();
        String numberStr = Integer.toString(number);
        int padSize = numberLength - numberStr.length();
        padNumber.append("0".repeat(Math.max(0, padSize)));
        return padNumber.append(numberStr);
    }
}
