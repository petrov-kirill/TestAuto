package homework.lesson2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;

public class Exercise3 {

    /*  1. Use your first ‘SeleniumTest’ and refactor it in a such way,
        that the test uses all annotations and instructions listed below.
        Each annotation can contain the only 1 instruction.
        2. Create a dedicated TestNG config for particular test.*/

    private static final String LINUX_CHROME_DRIVER_PATH = "linux-drivers/chromedriver";
    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        setProperty("webdriver.chrome.driver", LINUX_CHROME_DRIVER_PATH);
    }

    @BeforeTest
    public void beforeTest() {
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println(currentTimeMillis());
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println(driver.getTitle());
    }

    @AfterTest
    public void afterTest() {
        driver.close();
    }

    @AfterSuite
    public void afterSuite() {
        if (driver.toString().contains("null")) {
            driver.quit();
        }
    }

    @Test
    public void testTitle() {
        driver.manage().window().maximize();
        driver.navigate().to("http://www.epam.com");
        assertEquals(driver.getTitle(), "EPAM | Software Product Development Services");
    }
}
