package homework.homework4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;
import static enums.Colors.YELLOW;
import static enums.RadioButtons.SELEN;

public class DifferentElementsPage {

    @FindBy(css = ".support-title + .checkbox-row label")
    private ElementsCollection checkboxes;

    @FindBy(css = ".checkbox-row ~.checkbox-row label")
    private ElementsCollection radioButtons;

    @FindBy(css = ".colors .uui-form-element option")
    private ElementsCollection colorsDropDown;

    @FindBy(css = "button[class='uui-button']")
    private SelenideElement defaultButton;

    @FindBy(css = "input[class='uui-button']")
    private SelenideElement button;

    @FindBy(css = "#mCSB_1")
    private SelenideElement leftSection;

    @FindBy(css = "#mCSB_2")
    private SelenideElement rightSection;

    @FindBy(css = ".logs")
    private ElementsCollection logsSection;

    @Step("Check if interface contains all needed elements")
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

    @Step("Select and assert specific checkboxes")
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

    @Step("Select specific radio button")
    public void selectRadioButton() {
        for (SelenideElement se : radioButtons) {
            if (se.getText().equals(SELEN.label)) {
                se.$("input").setSelected(true);
                se.$("input").shouldBe(checked);
            }
        }
    }

    @Step("Select color in dropdown menu")
    public void selectInDropdown() {
        for (SelenideElement se : colorsDropDown) {
            if (se.getText().equals(YELLOW.color)) {
                se.setSelected(true);
                se.shouldBe(selected);
            }
        }
    }

    @Step("Check logs for selected values and their condition")
    public void checkLogsForSelectedValues(String condition, String... values) {
        for (SelenideElement se : logsSection) {
            for (String s : values) {
                se.shouldHave(text(s), text(condition));
            }
        }
    }

    @Step("Check unselected checkboxes")
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

    @Step("Check logs for unselected values and their condition")
    public void checkLogsForUnselectedValues(String condition, String... values) {
        for (SelenideElement se : logsSection) {
            for (String s : values) {
                se.shouldHave(text(s), text(condition));
            }
        }
    }
}
