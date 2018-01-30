package homework.homework3;

import enums.IndexPageTextsEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static enums.UserCreds.*;
import static java.lang.System.setProperty;
import static literals.Constants.MAIN_HEADER;
import static literals.Constants.MAIN_PAGE_TEXT_BELOW_HEADER;
import static literals.Paths.CHROME_DRIVER_PATH;

@Ignore
public class RefactoredHomework1 {

    private WebDriver driver;
    private IndexPage indexPage;

    @BeforeMethod
    public void setUpPages() {
        setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        indexPage = PageFactory.initElements(driver, IndexPage.class);
        driver.manage().window().fullscreen();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    //1 Create a new test
    @Test
    public void userLoginAndContentChecks() {
        //2 Open test site
        indexPage.openPage();

        //3 Assert Browser title
        indexPage.checkPageTitle();

        //4 Perform login
        indexPage.login(LOGIN.text, PASSWORD.text);

        //5 Assert that user is logged in
        indexPage.checkIfUserLoggedIn(FULL_NAME.text);

        //6 Assert Browser title
        indexPage.checkPageTitle();

        //7 Assert that there are 4 images on the Home Page and they are displayed
        indexPage.checkAmountOfImagesOnPage();

        //8 Assert that there are 4 texts on the Home Page and check them by getting texts
        indexPage.checkTextsUnderImages(IndexPageTextsEnum.values());

        //9 Assert that there are the main header and the text below it on the Home Page
        indexPage.checkMainHeaderOnPage(MAIN_HEADER, MAIN_PAGE_TEXT_BELOW_HEADER);
    }
}
