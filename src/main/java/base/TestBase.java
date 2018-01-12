package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Created by eprupetw6980 on 12/01/2018.
 */
public abstract class TestBase {

    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterSuite
    public void tearDown() {
        driver.close();
    }
}
