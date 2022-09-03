public class Main {

    public static void main(String[] args) {

        Cargo cargo = new Cargo(9.5, "New York", false, "a1335", true,
                new Dimensions(5, 7, 6));

        System.out.println("Груз № 1: \n" + cargo + "\n");

        cargo = cargo.setDeliveryAddress("Moscow");
        cargo = cargo.setDimensions(cargo.getDimensions().setHeight(10));

        System.out.println("Груз № 1 (с измененным адресом доставки): \n" + cargo + "\n");

        int cargoVolume = cargo.getDimensions().volume();

        System.out.println("объем груза = " + cargoVolume);
        System.out.println();

        Cargo cargo1 = cargo.setWeight(10);

        System.out.println("Груз № 2: \n" + cargo1 + "\n");
        System.out.println("Груз № 1: \n" + cargo);
    }
}
