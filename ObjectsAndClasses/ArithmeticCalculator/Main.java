public class Main {

    public static void main(String[] args) {
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator(8, 43);
        int number1 = arithmeticCalculator.getNumber1();
        int number2 = arithmeticCalculator.getNumber2();
        System.out.println(number1 + " + " + number2 + " = " + arithmeticCalculator.calculate(ArithmeticCalculator.Operation.ADD));
        System.out.println(number1 + " - " + number2 + " = " + arithmeticCalculator.calculate(ArithmeticCalculator.Operation.SUBTRACT));
        System.out.println(number1 + " * " + number2 + " = " + arithmeticCalculator.calculate(ArithmeticCalculator.Operation.MULTIPLY));
    }
}
