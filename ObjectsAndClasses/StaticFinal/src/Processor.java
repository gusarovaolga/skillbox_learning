

public class Processor {
    private final double frequency;
    private final int numberOfCores;
    private final String manufacturer;
    private final int weight;

    public Processor(double frequency, int numberOfCores, String manufacturer, int weight) {
        this.frequency = frequency;
        this.numberOfCores = numberOfCores;
        this.manufacturer = manufacturer;
        this.weight = weight;
    }

    public double getFrequency() {
        return frequency;
    }

    public Processor setFrequency(double frequency) {
        return new Processor(frequency, numberOfCores, manufacturer, weight);
    }

    public int getNumberOfCores() {
        return numberOfCores;
    }

    public Processor setNumberOfCores(int numberOfCores) {
        return new Processor(frequency, numberOfCores, manufacturer, weight);
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Processor setManufacturer(String manufacturer) {
        return new Processor(frequency, numberOfCores, manufacturer, weight);
    }

    public int getWeight() {
        return weight;
    }

    public Processor setWeight(int weight) {
        return new Processor(frequency, numberOfCores, manufacturer, weight);
    }

    @Override
    public String toString() {
        return "Процессор: " +
                "\n * частота процессора: " + frequency + " ГГц" +
                "\n * количество ядер: " + numberOfCores + " ядер" +
                "\n * производитель: " + manufacturer +
                "\n * вес: " + weight + " грамм" +
                "\n";
    }

}
