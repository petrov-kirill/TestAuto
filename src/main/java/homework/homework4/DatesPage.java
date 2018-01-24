package homework.homework4;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DatesPage {

    @FindBy(css = ".uui-slider a:first-child")
    private SelenideElement leftSlider;

    @FindBy(css = ".uui-slider a:last-child")
    private SelenideElement rightSlider;

    @FindBy(css = ".dropdown-menu a[href*='4']")
    private SelenideElement datesOption;

    @FindBy(css = ".dropdown [href*='1'] .caret")
    private SelenideElement serviceHeaderCaret;

    public void openDatesPage() {
        serviceHeaderCaret.click();
        datesOption.click();
    }

    public void sliderManipulations() {
        Actions actions = new Actions(getWebDriver());
        //<-  --
        actions.dragAndDropBy(leftSlider, -60, 0).build().perform();
        leftSlider.$("span").shouldHave(text("0"));
        rightSlider.$("span").shouldHave(text("100"));

        //--  <-
        actions.dragAndDropBy(rightSlider, -300, 0).build().perform();
        leftSlider.$("span").shouldHave(text("0"));
        rightSlider.$("span").shouldHave(text("0"));

        //-> ->
        actions.dragAndDropBy(rightSlider, 300, 0).build().perform();
        actions.dragAndDropBy(leftSlider, 300, 0).build().perform();
        rightSlider.$("span").shouldHave(text("100"));
        leftSlider.$("span").shouldHave(text("100"));

        //<-(30) <-(70)
        actions.dragAndDropBy(leftSlider, -194, 0).build().perform();
        actions.dragAndDropBy(rightSlider, -86, 0).build().perform();
        leftSlider.$("span").shouldHave(text("30"));
        rightSlider.$("span").shouldHave(text("70"));
    }
}
