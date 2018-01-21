package homework.homework4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HomePage {

    private SelenideElement profileMenu = $(".uui-profile-menu");
    private SelenideElement loginField = $("#Login");
    private SelenideElement passwordField = $("#Password");
    private SelenideElement loginButton = $(".btn-login");
    private SelenideElement profileName = $(".profile-photo");
    private ElementsCollection imagesOnHomePage = $$(".benefit-icon");
    private ElementsCollection textsOnHomePage = $$(".benefit-txt");
    private SelenideElement mainContent = $(".main-content");
    private SelenideElement serviceHeaderCaret = $("a[class^='dropdown'][href^='page1'] .caret");
    private ElementsCollection serviceHeaderOptions = $$(".dropdown-menu a");
    private SelenideElement serviceLeftCaret = $(".sub-menu a div");
    private ElementsCollection serviceLeftOptions = $$(".sub p");
    private SelenideElement differentElementsPage = $(".dropdown-menu [href^='page8']");
    private SelenideElement datesPage = $(".dropdown-menu a[href^=page4]");


    public void performLogin(String username, String password) {
        profileMenu.click();
        loginField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void checkIfUserLoggedIn(String fullName) {
        profileName.shouldBe(visible);
        profileName.shouldHave(text(fullName));
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
        for (int i = 0; i < serviceHeaderOptions.size(); i++) {
            serviceHeaderOptions.get(i).shouldHave(text(options[i]));
        }
    }

    public void checkLeftServiceMenu(String[] options) {
        serviceLeftCaret.click();
        for (int i = 0; i < serviceLeftOptions.size(); i++) {
            serviceLeftOptions.get(i).shouldHave(text(options[i]));
        }
    }

    public void openDifferentElementPage() {
        serviceHeaderCaret.click();
        differentElementsPage.click();
    }
}

