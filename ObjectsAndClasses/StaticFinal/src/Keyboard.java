

import enums.Backlight;
import enums.TypeKeyboard;

public class Keyboard {
    private final TypeKeyboard type;
    public final Backlight backlight;
    private final double weight;

    public Keyboard(TypeKeyboard type, Backlight backlight, double weight) {
        this.type = type;
        this.backlight = backlight;
        this.weight = weight;
    }

    public TypeKeyboard getType() {
        return type;
    }

    public Keyboard setType(TypeKeyboard type) {
        return new Keyboard(type,backlight,weight);
    }

    public Backlight isBacklight() {
        return backlight;
    }

    public Keyboard setBacklight(Backlight backlight) {
        return new Keyboard(type,backlight,weight);
    }

    public double getWeight() {
        return weight;
    }

    public Keyboard setWeight(double weight) {
        return new Keyboard(type,backlight,weight);
    }

    @Override
    public String toString() {
        return "Клавиатура: " +
                "\n * тип: " + type +
                "\n * подсветка: " + backlight +
                "\n * вес: " + weight + " грамм";
    }
}
