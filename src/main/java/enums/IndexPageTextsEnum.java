package enums;

public enum IndexPageTextsEnum {
    TEXT_1("To include good practices\n and ideas from successful\n EPAM projec"),
    TEXT_2("To be flexible and\n customizable"),
    TEXT_3("To be multiplatform"),
    TEXT_4("Already have good base\n (about 20 internal and\n" +
            "some external projects),\n wish to get more…");

    public String text;

    IndexPageTextsEnum(String text) {
        this.text = text;
    }
}
