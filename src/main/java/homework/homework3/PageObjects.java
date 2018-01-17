package homework.homework3;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PageObjects {
    @FindBy(css = ".uui-profile-menu")
    private WebElement profileMenu;

    @FindBy(css = "#Login")
    private WebElement loginField;

    @FindBy(css = "#Password")
    private WebElement passwordField;

    @FindBy(css = ".uui-button.dark-blue.btn-login") // think about it later!
    private WebElement loginButton;

    @FindBy(css = ".profile-photo")
    WebElement profileName;

    @FindBy(css = ".benefit-icon")
    List<WebElement> imagesOnHomePage;

    @FindBy(css = ".benefit-txt")
    List<WebElement> textOnHomePage;

    public void login(String username, String password) {
        profileMenu.click();
        loginField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}
