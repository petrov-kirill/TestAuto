package enums;

public enum CheckBoxes {
    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    public String label;

    CheckBoxes(String label) {
        this.label = label;
    }
}
