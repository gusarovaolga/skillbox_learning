public class Cargo {

    private final double weight;
    private final String deliveryAddress;
    private final boolean ableToFlip;
    private final String serialNumber;
    private final boolean fragile;
    private final Dimensions dimensions;


    public Cargo(double weight, String deliveryAddress, boolean ableToFlip,
                 String serialNumber, boolean fragile, Dimensions dimensions) {
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.ableToFlip = ableToFlip;
        this.serialNumber = serialNumber;
        this.fragile = fragile;
        this.dimensions = dimensions;
    }

    public double getWeight() {
        return weight;
    }

    public Cargo setWeight(double weight) {
        return new Cargo(weight, deliveryAddress, ableToFlip,
                serialNumber, fragile, dimensions);
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public Cargo setDeliveryAddress(String deliveryAddress) {
        return new Cargo(weight, deliveryAddress, ableToFlip,
                serialNumber, fragile, dimensions);
    }

    public boolean isAbleToFlip() {
        return ableToFlip;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public boolean isFragile() {
        return fragile;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public Cargo setDimensions(Dimensions dimensions) {
        return new Cargo(weight, deliveryAddress, ableToFlip,
                serialNumber, fragile, dimensions);
    }

    @Override
    public String toString() {
        return "Груз: " +
                "вес = " + weight +
                "\n Адрес доставки: " + deliveryAddress +
                "\n можно ли переворачивать: " + ableToFlip +
                "\n регистрационный номер: " + serialNumber +
                "\n хрупкое: " + fragile +
                "\n " + dimensions;
    }
}
