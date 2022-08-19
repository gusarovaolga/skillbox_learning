import java.util.Arrays;

public class ArraySplit {

    public static void main(String[] args) {
        String[] strings = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
        int coreCount = 4;
        int divRemind = strings.length % coreCount;
        int subArrayLength = (strings.length - divRemind) / divRemind;

        System.out.println("sub array length = " + subArrayLength);

        int startNextIndex = 0;
        for (int i = 0; i < coreCount; i++) {
            String[] subArray;
            if (i == coreCount - 1) {
                subArray = new String[subArrayLength + divRemind];
                for (int j = 0; j < subArrayLength + divRemind; j++) {
                    subArray[j] = strings[j + startNextIndex];
                }
            } else {
                subArray = new String[subArrayLength];
                for (int j = 0; j < subArrayLength; j++) {
                    subArray[j] = strings[j + startNextIndex];
                }
            }
            startNextIndex += subArrayLength;
            System.out.println(Arrays.toString(subArray));
        }
    }
}
