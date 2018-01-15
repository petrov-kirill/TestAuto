package lesson3.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage {
    @FindBy(css = ".uui-profile-menu .dropdown-toggle")
    private WebElement loginFormButton;

    @FindBy(css = "Login")
    private WebElement loginInput;

    @FindBy(css = "Password")
    private WebElement passwordInput;

    @FindBy(css = ".form-horizontal [type='submit']")
    private WebElement submitButton;

    public void login(String name, String password) {
        loginFormButton.click();

        loginInput.sendKeys(name);
        passwordInput.sendKeys(password);
        submitButton.click();

    }
}
