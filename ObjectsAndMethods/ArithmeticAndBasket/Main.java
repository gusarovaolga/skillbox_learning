public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Milk", 40);
        basket.add("beer", 50, 2);
        basket.print("basket");

        Basket basket1 = new Basket("tea", 10, 0.3, 2);
        basket1.add("bread", 5);
        basket1.print("\nbasket1");

        Basket basket2 = new Basket("butter", 10, 0.5, 2);

        Basket basket3 = new Basket(50);
        basket3.add("water", 100);

        System.out.println("\ntotalCount basket = " + basket.getTotalCount() + " totalPrice = " + basket.getTotalPrice());
        System.out.println("totalCount basket1 = " + basket1.getTotalCount() + " totalPrice = " + basket1.getTotalPrice());
        System.out.println("totalCount basket2 = " + basket2.getTotalCount() + " totalPrice = " + basket2.getTotalPrice());
        System.out.println("totalCount basket3 = " + basket3.getTotalCount() + " totalPrice = " + basket3.getTotalPrice());
        System.out.println("");
        System.out.println("всего товаров к корзинах = " + Basket.getAllCount());
        System.out.println("стоимость всех  товаров в корзинах = " + Basket.getAllPrice());
        System.out.println("количество корзин = " + Basket.getCount());
        System.out.println("средняя цена товаров во всех корзинах = " + Basket.getAveragePrice());
        System.out.println("стредняя цена товаров в корзине = " + Basket.getAveragePriceBasket());
    }
}
