import java.util.Scanner;

public class Main {

    private static final int maxAmount = 400;
    private static final double fuel92price = 60.2;
    private static final double fuel95price = 67.33;
    private static final double discount = 0.1;

    public static void main(String[] args) {
        System.out.println("Система расчета стоимости топлива");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите тип бензина (92 или 95):");
        int fuelType = scanner.nextInt();
        System.out.println("Введите нужное количество бензина:");
        int amount = scanner.nextInt();

        boolean hasDiscount = amount > 10;

        String errorMessage = "";

        // проверка на тип выбранного бензина
        double fuelPrice = 0;
        if (fuelType == 92) {
            fuelPrice = fuel92price;
        } else if (fuelType == 95) {
            fuelPrice = fuel95price;
        } else {
            errorMessage = "Указан неверный тип топлива";
        }

        // проверка на скидку
        if (hasDiscount) {
            fuelPrice = (1 - discount) * fuelPrice;
        }

        // проверка на количество указанного бензина
        if (amount < 1) {
            errorMessage = "Указано слишком малое количество топлива";
            amount = 0;
        } else if (amount > maxAmount) {
            errorMessage = "Указанное количество топлива превышает максимально допустимые " + maxAmount + " литров";
            amount = maxAmount;
        }

        if (!errorMessage.matches("")) {
            System.out.println(errorMessage);
        } else {
            String price = String.format("%.2f", fuelPrice);
            String fuelPriceMessage = "Цена выбранного топлива: " + price + " руб.";
            System.out.println(fuelPriceMessage);
        }

        double totalPrice = fuelPrice * amount;
        String priceAll = String.format("%.2f", totalPrice);
        System.out.println("Общая стоимость заправки: " + priceAll + " руб.");
    }
}
