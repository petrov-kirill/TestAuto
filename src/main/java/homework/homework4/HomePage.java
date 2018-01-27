package homework.homework4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import enums.ServiceOptions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static enums.UserCreds.FULL_NAME;
import static literals.Constants.MAIN_HEADER;
import static literals.Constants.MAIN_PAGE_TEXT_BELOW_HEADER;
import static literals.Urls.MAIN_PAGE_URL;

public class HomePage {

    @FindBy(css = ".uui-profile-menu")
    public SelenideElement profileMenu;

    @FindBy(css = "#Login")
    private SelenideElement loginField;

    @FindBy(css = "#Password")
    private SelenideElement passwordField;

    @FindBy(css = ".btn-login")
    private SelenideElement loginButton;

    @FindBy(css = ".profile-photo")
    private SelenideElement profileName;

    @FindBy(css = ".benefit-icon")
    private ElementsCollection imagesOnHomePage;

    @FindBy(css = ".benefit-txt")
    private ElementsCollection textsOnHomePage;

    @FindBy(css = ".main-content")
    private SelenideElement mainContent;

    @FindBy(css = ".dropdown [href*='1'] .caret")
    private SelenideElement serviceHeaderCaret;

    @FindBy(css = ".dropdown-menu a")
    private ElementsCollection serviceHeaderOptions;

    @FindBy(css = ".sub-menu a div")
    private SelenideElement serviceLeftCaret;

    @FindBy(css = ".sub p")
    private ElementsCollection serviceLeftOptions;

    @FindBy(css = ".dropdown-menu [href*='8']")
    private SelenideElement differentElementsPage;

    @FindBy(css = ".dropdown-menu a[href*=4]")
    private SelenideElement datesPage;

    public void openPage() {
        Selenide.open(MAIN_PAGE_URL);
    }

    public void performLogin(String login, String password) {
        if (!profileName.getText().contains(FULL_NAME.text)) {
            profileMenu.click();
            loginField.sendKeys(login);
            passwordField.sendKeys(password);
            loginButton.click();
        }
    }

    public void checkIfUserLoggedIn(String fullName) {
        profileName.shouldBe(visible);
        profileName.shouldHave(text(fullName));
    }

    public void checkIfPageContainsAllNeededElements() {
        for (SelenideElement se : imagesOnHomePage) {
            se.shouldBe(visible);
        }
        imagesOnHomePage.shouldHaveSize(4);
        for (SelenideElement se : textsOnHomePage) {
            se.shouldBe(visible);
        }
        textsOnHomePage.shouldHaveSize(4);
        mainContent.shouldHave(text(MAIN_HEADER));
        mainContent.shouldHave(text(MAIN_PAGE_TEXT_BELOW_HEADER));
    }

    public void checkHeaderServiceMenu() {
        serviceHeaderCaret.click();
        ServiceOptions[] options = ServiceOptions.values();
        for (int i = 0; i < serviceHeaderOptions.size(); i++) {
            serviceHeaderOptions.get(i).shouldHave(text(options[i].option));
        }
    }

    public void checkLeftServiceMenu() {
        serviceLeftCaret.click();
        ServiceOptions[] options = ServiceOptions.values();
        for (int i = 0; i < serviceLeftOptions.size(); i++) {
            serviceLeftOptions.get(i).shouldHave(text(options[i].option));
        }
    }

    public void openDifferentElementPage() {
        serviceHeaderCaret.click();
        differentElementsPage.click();
    }
}

