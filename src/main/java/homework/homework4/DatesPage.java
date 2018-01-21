package homework.homework4;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DatesPage {

    private SelenideElement leftSlider = $(".uui-slider a:first-child");
    private SelenideElement rightSlider = $(".uui-slider a:last-child");

    public void sliderManipulations() {
        Actions actions = new Actions(getWebDriver());
        //<-  --
        actions.moveToElement(leftSlider).dragAndDropBy(leftSlider, -60, 0).build().perform();

        //--  <-
        actions.moveToElement(rightSlider).dragAndDropBy(rightSlider, -300, 0).build().perform();

        //-> ->
        actions.moveToElement(rightSlider).dragAndDropBy(rightSlider, 300, 0).build().perform();
        actions.moveToElement(leftSlider).dragAndDropBy(leftSlider, 300, 0).build().perform();

        //<-(30) <-(70)
        actions.moveToElement(leftSlider).dragAndDropBy(leftSlider, -194, 0).build().perform();
        actions.moveToElement(rightSlider).dragAndDropBy(rightSlider, -86, 0).build().perform();
    }
}
