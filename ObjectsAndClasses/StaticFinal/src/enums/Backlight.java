package enums;

public enum Backlight {
    YES ("есть"),
    NO("нет");

    private String title;

    private Backlight(String title) {
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
