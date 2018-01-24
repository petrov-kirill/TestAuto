package homework.homework3;

import enums.IndexPageTextsEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static java.lang.System.setProperty;
import static literals.Constants.*;
import static literals.Paths.CHROME_DRIVER_PATH;
import static literals.Urls.MAIN_PAGE_URL;

public class RefactoredHomework1 {

    private WebDriver driver;
    private PageObjects pageObjects;

    @BeforeClass
    public void setUpPages() {
        setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        pageObjects = new PageObjects(driver);
        driver.manage().window().fullscreen();
    }

    //1 Create a new test
    @Test
    public void userLoginAndContentChecks() {
        //2 Open test site by SITE_UNDER_TEST_URL
        pageObjects.open(MAIN_PAGE_URL);

        //3 Assert Browser title
        pageObjects.checkPageTitle(driver);

        //4 Perform login
        pageObjects.login(USER_LOGIN_NAME, PASSWORD);

        //5 Assert that user is logged in
        pageObjects.checkIfUserLoggedIn(FULL_NAME);

        //6 Assert Browser title
        pageObjects.checkPageTitle(driver);

        //7 Assert that there are 4 images on the Home Page and they are displayed
        pageObjects.checkAmountOfImagesOnPage();

        //8 Assert that there are 4 texts on the Home Page and check them by getting texts
        pageObjects.checkTextsUnderImages(IndexPageTextsEnum.values());

        //9 Assert that there are the main header and the text below it on the Home Page
        pageObjects.checkMainHeaderOnPage(MAIN_HEADER, MAIN_PAGE_TEXT_BELOW_HEADER);

        //10 Close driver
        pageObjects.closeDriver();
    }
}
