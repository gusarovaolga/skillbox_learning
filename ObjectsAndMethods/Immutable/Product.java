public class Product {
    private final String name;
    private final long barCode;
    private int price;

    public Product(String name, long barCode) {
        this.name = name;
        this.barCode = barCode;
    }

    public String getName() {
        return name;
    }

    public long getBarCode() {
        return barCode;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
