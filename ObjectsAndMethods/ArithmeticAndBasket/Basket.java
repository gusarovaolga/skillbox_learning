public class Basket {

    private static int count;
    private static double allPrice;
    private static int allCount;
    private String items;
    private int totalPrice;
    private int totalCount;
    private double totalWeight;
    private int limit;

    private static final String CURRENCY = " руб.";
    private static final String WEIGHT_UNITS = " кг";

    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice, double totalWeight, int totalCount) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice * totalCount;
        this.totalWeight = totalWeight;
        this.totalCount = totalCount;
        increaseAllCount(totalCount);
        increaseAllPrice(totalPrice * totalCount);
    }

    public static int getCount() {
        return count;
    }

    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }

    public static void increaseAllCount(int totalCount) {
        Basket.allCount = Basket.allCount + totalCount;
    }

    public static int getAllCount() {
        return allCount;
    }

    public static void increaseAllPrice(int totalPrice) {
        allPrice = allPrice + totalPrice;
    }

    public static double getAllPrice() {
        return allPrice;
    }

    public static double getAveragePrice() {
        return allPrice / allCount;
    }

    public static double getAveragePriceBasket() {
        return allPrice / count;
    }

    public void add(String name, int price) {
        add(name, price, 1);
    }

    public void add(String name, int price, int count) {
        add(name, price, count, 0);
    }

    public void add(String name, int price, int count, double weight) {
        boolean error = false;
        if (contains(name) || totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " +
                count + " шт. - " + price + CURRENCY + " (" + weight + WEIGHT_UNITS + ") ";
        totalCount = totalCount + count;
        totalPrice = totalPrice + count * price;
        totalWeight = totalWeight + count * weight;
        increaseAllCount(count);
        increaseAllPrice(price * count);
    }

    public void clear() {
        items = "";
        totalPrice = 0;
        totalCount = 0;
        totalWeight = 0.0;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
    }
}
