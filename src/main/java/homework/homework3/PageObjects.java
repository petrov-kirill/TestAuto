package homework.homework3;

import enums.IndexPageTextsEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PageObjects {

    private WebDriver driver;

    @FindBy(css = ".uui-profile-menu")
    private WebElement profileMenu;

    @FindBy(css = "#Login")
    private WebElement loginField;

    @FindBy(css = "#Password")
    private WebElement passwordField;

    @FindBy(css = ".btn-login")
    private WebElement loginButton;

    @FindBy(css = ".profile-photo")
    private WebElement profileName;

    @FindBy(css = ".benefit-icon")
    private List<WebElement> imagesOnHomePage;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> textOnHomePage;

    @FindBy(css = ".main-content")
    private WebElement mainHeader;

    PageObjects(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void open(String url) {
        driver.navigate().to(url);
    }

    public void login(String username, String password) {
        profileMenu.click();
        loginField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void checkPageTitle(WebDriver driver) {
        assertEquals(driver.getTitle(), "Index Page");
    }

    public void checkTextsUnderImages(IndexPageTextsEnum[] arr) {
        for (int i = 0; i < arr.length; i++) {
            assertEquals(textOnHomePage.get(i).getText().replaceAll("\\r\\n|\\r|\\n", " "), arr[i].text);
        }
    }

    public void checkIfUserLoggedIn(String text) {
        assertTrue(profileName.isDisplayed());
        assertEquals(profileName.getText(), text);
    }

    public void checkAmountOfImagesOnPage() {
        assertEquals(imagesOnHomePage.size(), 4);
        for (WebElement element : imagesOnHomePage) {
            assertTrue(element.isDisplayed());
        }
    }

    public void checkMainHeaderOnPage(String... strings) {
        for (String string : strings) {
            assertTrue(mainHeader.getText().contains(string));
        }
    }

    public void closeDriver() {
        driver.close();
    }
}
