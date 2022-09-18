public enum Operation {

    ADD("ADD"),
    LIST("LIST");

    private String title;

    Operation(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
