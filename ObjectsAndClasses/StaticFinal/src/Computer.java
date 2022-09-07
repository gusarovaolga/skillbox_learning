

public class Computer {
    private  Processor processor;
    private  RAM ram;
    private  StorageOfInformation storage;
    private  Screen screen;
    private  Keyboard keyboard;

    private final String vendor;
    private final String name;


    public Computer(String vendor, String name) {
        this.vendor = vendor;
        this.name = name;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public StorageOfInformation getStorage() {
        return storage;
    }

    public void setStorage(StorageOfInformation storage) {
        this.storage = storage;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public String getAllWeight(){
        double allWeight = processor.getWeight() + ram.getWeight() + storage.getWeight() + screen.getWeight() + keyboard.getWeight();
        String unitWeight;
        if(allWeight >= 1000) {
            allWeight = allWeight / 1000;
            unitWeight = " кг";
        } else {
            unitWeight = " грамм";
        }
        return allWeight + unitWeight;
    }

    @Override
    public String toString() {
        return "Компьютер: " +
                "производитель: " + vendor +
                " (модель: " + name + ")\n" +
                processor +
                ram +
                storage +
                screen +
                keyboard;
    }
}
