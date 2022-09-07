import enums.*;

public class Main {

    public static void main(String[] args) {
        Computer computer = new Computer("Lenovo", "Z50-70");
        computer.setProcessor(new Processor(1.7, 2, "Intel", 50));
        computer.setRam(new RAM(TypeRAM.DDR3, 6, 17));
        computer.setStorage(new StorageOfInformation(TypeStorage.HDD, 1, 50));
        computer.setScreen( new Screen(15.6, TypeScreen.TN, 50));
        computer.setKeyboard(new Keyboard(TypeKeyboard.MEMBRANE, Backlight.NO, 100));

        System.out.println(computer);

        System.out.println("общий вес комплектующих: " + computer.getAllWeight());
    }
}
