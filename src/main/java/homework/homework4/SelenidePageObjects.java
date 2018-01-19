package homework.homework4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SelenidePageObjects {

    private WebDriver driver;
    private SelenideElement profileMenu = $(".uui-profile-menu");
    private SelenideElement loginField = $("#Login");
    private SelenideElement passwordField = $("#Password");
    private SelenideElement loginButton = $(".btn-login");
    private SelenideElement profileName = $(".profile-photo");
    private ElementsCollection imagesOnHomePage = $$(".benefit-icon");
    private ElementsCollection textsOnHomePage = $$(".benefit-txt");
    private SelenideElement mainContent = $(".main-content");

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
}
