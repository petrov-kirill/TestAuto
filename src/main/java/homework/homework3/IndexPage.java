package homework.homework3;

import enums.IndexPageTextsEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static literals.Urls.MAIN_PAGE_URL;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IndexPage {

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

    public IndexPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.navigate().to(MAIN_PAGE_URL);
    }

    public void login(String username, String password) {
        profileMenu.click();
        loginField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void checkPageTitle() {
        assertEquals(driver.getTitle(), "Index Page");
    }

    public void checkTextsUnderImages(IndexPageTextsEnum[] arr) {
        for (int i = 0; i < textOnHomePage.size(); i++) {
            assertEquals(textOnHomePage.get(i).getText().replaceAll("\\n", " "), arr[i].text);
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
}
