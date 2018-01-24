package enums;

public enum RadioButtons {
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    public String label;

    RadioButtons(String label) {
        this.label = label;
    }
}
