package homework.homework4;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static java.lang.System.setProperty;

/**
 * Work in progress
 */
public class Exercise {

//    todo ... Create dedicated class for shared constants!
    private static final String GECKO_DRIVER_PATH = "src\\test\\resources\\windows-drivers\\geckodriver.exe";
    private static final String SITE_UNDER_TEST = "https://jdi-framework.github.io/tests/index.htm";
    private static final String USER_LOGIN_NAME = "epam";
    private static final String PASSWORD = "1234";
    private static final String FULL_NAME = "PITER CHAILOVSKII";

    private WebDriver driver;
    private SelenidePageObjects homePage;

    @BeforeClass
    public void setUp() {
        setProperty("webdriver.gecko.driver", GECKO_DRIVER_PATH);
        driver = new FirefoxDriver();
        homePage = new SelenidePageObjects();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    //1 Create a new test in a new Java class, specify test name accordingly checking functionality
    @Test
    public void renameMeLater() {   // todo ...don't forget to come up with a proper name for test!!!
        //2 Open test site by URL
        Selenide.open(SITE_UNDER_TEST);
        //3 Perform login
        homePage.performLogin(USER_LOGIN_NAME, PASSWORD);

        //4 Assert User name in the left-top side of screen that user is logged in
        homePage.checkIfUserLoggedIn(FULL_NAME);

        //5 Check interface on Home page, it contains all needed elements.
        homePage.checkIfPageContainsAllNeededElements("EPAM FRAMEWORK WISHES…", "LOREM IPSUM");

        //6 Click on "Service" subcategory in the header and check that drop down contains options


        //7 Click on Service subcategory in the left section and check that drop down contains options
        //8 Open through the header menu Service -> Different Elements Page
        //9 Check interface on Service page, it contains all needed elements.
        //10 Select and assert checkboxes
        //11 Select radio
        //12 Select in dropdown
        //13 Check in logs section selected values and status (true|false)
        //14 Unselect and assert checkboxes
        //15 Check in logs section unselected values and status (true|false)
    }
}
