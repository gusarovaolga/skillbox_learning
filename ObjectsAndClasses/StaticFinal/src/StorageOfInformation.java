

import enums.TypeStorage;

public class StorageOfInformation {
    private final TypeStorage type;
    private final int volume;
    private final double weight;

    public StorageOfInformation(TypeStorage type, int volume, double weight) {
        this.type = type;
        this.volume = volume;
        this.weight = weight;
    }

    public TypeStorage getType() {
        return type;
    }

    public StorageOfInformation setType(TypeStorage type) {
        return new StorageOfInformation(type,volume,weight);
    }

    public int getVolume() {
        return volume;
    }

    public StorageOfInformation setVolume(int volume) {
        return new StorageOfInformation(type,volume,weight);
    }

    public double getWeight() {
        return weight;
    }

    public StorageOfInformation setWeight(double weight) {
        return new StorageOfInformation(type,volume,weight);
    }

    @Override
    public String toString() {
        return "Накопитель информации: " +
                "\n * тип: " + type +
                "\n * объем памяти: " + volume + " Тб" +
                "\n * вес: " + weight + " грамм" +
                '\n';
    }
}
