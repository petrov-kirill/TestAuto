package homework.homework4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static java.lang.System.setProperty;

/**
 * Work in progress
 */
public class Exercise {

    private static final String CHROME_DRIVER_PATH ="src\\test\\resources\\windows-drivers\\chromedriver.exe";

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

    @Test
    public void renameMeLater() {

    }
}
