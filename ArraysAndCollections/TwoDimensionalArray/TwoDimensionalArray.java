import java.util.Arrays;

public class TwoDimensionalArray {

    public static final char SYMBOL = 'X';

    public static char[][] getTwoDimensionalArray(int size) {

        char[][] dimensionalArray = new char[size][size];
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (x == y) {
                    dimensionalArray[size - x - 1][y] = SYMBOL;
                    dimensionalArray[x][size - x - 1] = SYMBOL;
                } else {
                    dimensionalArray[x][y] = ' ';
                    dimensionalArray[size - x - 1][size - x - 1] = SYMBOL;
                }
            }
        }
        return dimensionalArray;
    }

    public static void main(String[] args) {

        int size = 7;
//        System.out.println(Arrays.deepToString(TwoDimensionalArray.getTwoDimensionalArray(size)));

        for (char[] array : TwoDimensionalArray.getTwoDimensionalArray(size)) {
            System.out.println(Arrays.toString(array));
        }
    }
}
