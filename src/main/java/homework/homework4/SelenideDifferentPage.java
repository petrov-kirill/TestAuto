package homework.homework4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SelenideDifferentPage {

    private ElementsCollection checkBoxes = $$(".support-title + .checkbox-row label");
    private ElementsCollection radioButtons = $$(".checkbox-row ~ .checkbox-row label");
    private ElementsCollection colorsDropDown = $$(".colors .uui-form-element option");
    private SelenideElement defaultButton = $("button[class='uui-button']");
    private SelenideElement button = $("input[class='uui-button']");
    private SelenideElement leftSection = $("#mCSB_1");
    private SelenideElement rightSection = $("#mCSB_2");

    public void checkIfInterfaceContainsAllNeededElements() {
        checkBoxes.shouldHaveSize(4);
        for (SelenideElement se : checkBoxes) {
            se.should(exist);
        }
        radioButtons.shouldHaveSize(4);
        for (SelenideElement se : radioButtons) {
            se.should(exist);
        }
        colorsDropDown.shouldHaveSize(4);
        for (SelenideElement se : colorsDropDown) {
            se.should(exist);
        }
        defaultButton.should(exist);
        button.should(exist);
        leftSection.should(exist);
        rightSection.should(exist);
    }
}
