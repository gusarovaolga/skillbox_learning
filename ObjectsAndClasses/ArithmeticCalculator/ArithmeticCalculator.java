public class ArithmeticCalculator {
    private final int number1;
    private final int number2;

    public ArithmeticCalculator(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    public int calculate(Operation operation) {
        switch (operation) {
            case ADD:
                return add();
            case SUBTRACT:
                return subtract();
            case MULTIPLY:
                return multiply();
            default:
                System.out.println("незнакомая операция");
                return 0;
        }
    }

    public int add() {
        return number1 + number2;
    }

    public int subtract() {
        return number1 - number2;
    }

    public int multiply() {
        return number1 * number2;
    }

    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }

    public enum Operation {
        ADD,
        SUBTRACT,
        MULTIPLY
    }
}


