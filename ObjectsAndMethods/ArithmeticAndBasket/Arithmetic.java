public class Arithmetic {

    private int number1;
    private int number2;
    private int result;

    public Arithmetic(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    public static void main(String[] args) {
        Arithmetic arithmetic = new Arithmetic(2, 3);

        System.out.print("Минимальное число из двух чисел: ");
        arithmetic.min();
        arithmetic.print();

        System.out.print("Максимальное число из двух чисел: ");
        arithmetic.max();
        arithmetic.print();

        System.out.print("Сумма двух чисел: ");
        arithmetic.addition();
        arithmetic.print();

        System.out.print("Произведение двух чисел: ");
        arithmetic.multiplication();
        arithmetic.print();
    }

    public void addition() {
        result = number1 + number2;
    }

    public void multiplication() {
        result = number1 * number2;
    }

    public void max() {

        if (number1 >= number2) {
            result = number1;
        } else {
            result = number2;
        }
    }

    public void min() {

        if (number1 <= number2) {
            result = number1;
        } else {
            result = number2;
        }
    }

    public void print() {
        System.out.println(result);
    }

}
