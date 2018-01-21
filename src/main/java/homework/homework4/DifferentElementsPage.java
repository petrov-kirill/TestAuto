package homework.homework4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DifferentElementsPage {

    private ElementsCollection checkboxes = $$(".support-title + .checkbox-row label ");
    private ElementsCollection radioButtons = $$(".checkbox-row ~ .checkbox-row label");
    private ElementsCollection colorsDropDown = $$(".colors .uui-form-element option");
    private SelenideElement defaultButton = $("button[class='uui-button']");
    private SelenideElement button = $("input[class='uui-button']");
    private SelenideElement leftSection = $("#mCSB_1");
    private SelenideElement rightSection = $("#mCSB_2");
    private ElementsCollection logsSection = $$(".logs");

    public void checkIfInterfaceContainsAllNeededElements() {
        checkboxes.shouldHaveSize(4);
        for (SelenideElement se : checkboxes) {
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

    public void selectAndAssertCheckboxes(String... checkboxNames) {
        for (SelenideElement se : checkboxes) {
            for (String s : checkboxNames) {
                if (s.equals(se.getText())) {
                    se.$("input").setSelected(true);
                    se.$("input").shouldBe(checked);
                }
            }
        }
    }

    public void selectRadioButton(String radioButtonName) {
        for (SelenideElement se : radioButtons) {
            if (se.getText().equals(radioButtonName)) {
                se.$("input").setSelected(true);
                se.$("input").shouldBe(checked);
            }
        }
    }

    public void selectInDropdown(String color) {
        for (SelenideElement se : colorsDropDown) {
            if (se.getText().equals(color)) {
                se.setSelected(true);
                se.shouldBe(selected);
            }
        }
    }

    public void checkLogsForSelectedValues(String... values) {
        for (SelenideElement se : logsSection) {
            for (String s : values) {
                se.shouldHave(text(s));
            }
        }
    }

    public void checkUnselectedCheckboxes(String... checkboxNames) {
        for (SelenideElement se : checkboxes) {
            for (String s : checkboxNames) {
                if (s.equals(se.getText())) {
                    se.$("input").setSelected(false);
                    se.$("input").shouldNotBe(checked);
                }
            }
        }
    }

    public void checkLogsForUnselectedValues(String condition, String... values) {
        for (SelenideElement se : logsSection) {
            for (String s : values) {
                se.shouldHave(text(s), text(condition));
            }
        }
    }
}
