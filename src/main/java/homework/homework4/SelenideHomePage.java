package homework.homework4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.testng.Assert.assertTrue;

public class SelenideHomePage {

    private SelenideElement profileMenu = $(".uui-profile-menu");
    private SelenideElement loginField = $("#Login");
    private SelenideElement passwordField = $("#Password");
    private SelenideElement loginButton = $(".btn-login");
    private SelenideElement profileName = $(".profile-photo");
    private ElementsCollection imagesOnHomePage = $$(".benefit-icon");
    private ElementsCollection textsOnHomePage = $$(".benefit-txt");
    private SelenideElement mainContent = $(".main-content");
    private SelenideElement serviceHeaderCaret = $("a[class='dropdown-toggle'][href='page1.htm'] .caret");
    private ElementsCollection serviceHeaderOptions = $$("ul[class='dropdown-menu']");
    private SelenideElement serviceLeftCaret = $(".sub-menu a div");
    private ElementsCollection serviceLeftOptions = $$(".sub-menu .sub");


    public void performLogin(String username, String password) {
        profileMenu.click();
        loginField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void checkIfUserLoggedIn(String text) {
        profileName.shouldBe(visible);
        profileName.shouldHave(text("PITER CHAILOVSKII"));
    }

    public void checkIfPageContainsAllNeededElements(String... strings) {
        for (SelenideElement se : imagesOnHomePage) {
            se.shouldBe(visible);
        }
        imagesOnHomePage.shouldHaveSize(4);
        for (SelenideElement se : textsOnHomePage) {
            se.shouldBe(visible);
        }
        textsOnHomePage.shouldHaveSize(4);
        for (String s : strings) {
            mainContent.shouldHave(text(s));
        }
    }

    public void checkHeaderServiceMenu(String[] options) {
        serviceHeaderCaret.click();
        for (String option : options) {
            serviceHeaderOptions.get(0).should(exist);
            assertTrue(serviceHeaderOptions.get(0).getText().contains(option));
            //todo ...is it possible to write this assertion only with help of should? think!
        }
    }

    public void checkLeftServiceMenu(String[] options) {
        serviceLeftCaret.click();
        for (String option : options) {
            serviceLeftOptions.get(0).should(exist);
            assertTrue(serviceLeftOptions.get(0).getText().contains(option));
            //todo ...is it possible to write this assertion only with help of should? think!
        }
    }

    public void openDifferentElementPage() {
        serviceHeaderCaret.click();
        $(".dropdown-menu [href='page8.htm']").click();
    }
}

