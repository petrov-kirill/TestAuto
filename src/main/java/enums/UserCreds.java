package enums;

public enum UserCreds {
    LOGIN("epam"),
    PASSWORD("1234"),
    FULL_NAME("PITER CHAILOVSKII");

    public String text;

    UserCreds(String text) {
        this.text = text;
    }
}
