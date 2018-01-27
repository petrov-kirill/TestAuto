package homework.homework4;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

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


    public void sliderDragAndDrop(int leftSliderShift, int rightSliderShift) {
        setPosition(leftSlider, leftSliderShift);
        setPosition(rightSlider, rightSliderShift);

        assertEquals(getPosition(rightSlider), rightSliderShift);
        assertEquals(getPosition(leftSlider), leftSliderShift);
    }

    private static void setPosition(SelenideElement element, int position) {
        int currentPosition = getPosition(element);
        if (position != currentPosition) {
            float step = getStep();
            float horizontalOffset = (position - currentPosition) * step;
            Actions actions = new Actions(getWebDriver());
            actions.dragAndDropBy(element, Math.round(horizontalOffset), 0).perform();

            while(getPosition(element) != position) {
                int delta = 1;
                int stepWithDelta = Math.round(step) + delta;
                actions.dragAndDropBy(element, horizontalOffset > 0 ? stepWithDelta : -stepWithDelta, 0)
                        .perform();
            }
        }
    }

    private static float getStep() {
        return ((float) $(".uui-slider.blue").getSize().width) / 100;
    }

    private static int getPosition(SelenideElement element) {
        return Integer.parseInt(element.$("span").getText());
    }
}
