package homework.homework3;

import enums.IndexPageTextsEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static java.lang.System.setProperty;

public class RefactoredHomework1 {

    private static final String CHROME_DRIVER_PATH =
            "C:\\Users\\Kirill_Petrov\\IdeaProjects\\TestAuto\\src\\test\\resources\\windows-drivers\\chromedriver.exe";
    private static final String USER_LOGIN_NAME = "epam";
    private static final String PASSWORD = "1234";
    private static final String SITE_UNDER_TEST_URL = "https://jdi-framework.github.io/tests";

    private WebDriver driver;
    private PageObjects pageObjects;

    @BeforeClass
    public void setUpPages() {
        setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        pageObjects = new PageObjects(driver);
        driver.manage().window().fullscreen();
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

    //1 Create a new test
    @Test
    public void userLoginAndContentChecks() {
        //2 Open test site by SITE_UNDER_TEST_URL
        driver.navigate().to(SITE_UNDER_TEST_URL);

        //3 Assert Browser title
        pageObjects.checkPageTitle(driver);

        //4 Perform login
        pageObjects.login(USER_LOGIN_NAME, PASSWORD);

        //5 Assert that user is logged in
        pageObjects.checkIfUserLoggedIn("PITER CHAILOVSKII");

        //6 Assert Browser title
        pageObjects.checkPageTitle(driver);

        //7 Assert that there are 4 images on the Home Page and they are displayed
        pageObjects.checkAmountOfImagesOnPage();

        //8 Assert that there are 4 texts on the Home Page and check them by getting texts
        pageObjects.checkTextsUnderImages(IndexPageTextsEnum.values());

        //9 Assert that there are the main header and the text below it on the Home Page
        pageObjects.checkMainHeaderOnPage("EPAM FRAMEWORK WISHES…", "LOREM IPSUM");
    }
}
