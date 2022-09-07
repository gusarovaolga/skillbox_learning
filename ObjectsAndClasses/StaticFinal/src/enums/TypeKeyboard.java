package enums;

public enum TypeKeyboard {
    ANALOG_OPTICAL("аналоговая оптическая"),
    MEMBRANE("мембранная"),
    MECHANICAL("механическая"),
    SCISSOR("ножничная"),
    OPTOMECHANICAL("оптомеханическая"),
    PLUNGER("плунжерная"),
    WIRELESS("беспроводная");

    private String title;

    private TypeKeyboard(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}
