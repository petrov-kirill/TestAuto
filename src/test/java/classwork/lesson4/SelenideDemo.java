package classwork.lesson4;

import base.BaseSelenide;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class SelenideDemo extends BaseSelenide {

    @AfterMethod
    public void tearDown() {
        close();
    }

    @Ignore
    @Test
    public void test1() {
        open("https://www.epam.com");
        assertEquals(getWebDriver().getTitle(), "EPAM | Software Product Development Services");

        $(".header-search__button").click();

        SelenideElement menuButton = $(".hamburger-menu__button");
        menuButton.click();
        menuButton.should(Condition.visible);
    }

    @Ignore
    @Test
    public void test2() {
        open("https://www.epam.com");
        assertEquals(getWebDriver().getTitle(), "EPAM | Software Product Development Services");

        $(".header-search__buttn").click();

        SelenideElement menuButton = $(".hamburger-menu__button");
        menuButton.click();
        menuButton.should(Condition.visible);
    }

    @Ignore
    @Test
    public void test3() {
        open("https://www.epam.com");
        assertEquals(getWebDriver().getTitle(), "EPAM | Software Product Development Services");

        $(".header-search__buttn").click();

        SelenideElement menuButton = $(".hamburger-menu__button");
        menuButton.click();
        menuButton.should(Condition.visible);
    }
}
