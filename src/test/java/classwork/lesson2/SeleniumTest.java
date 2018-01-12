package classwork.lesson2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by eprupetw6980 on 12/01/2018.
 */
public class SeleniumTest {

    @Test(groups = {"smoke"})
    public void test1() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("http://www.epam.com");
        assertEquals(driver.getTitle(), "EPAM | Software Product Development Services");

    }
}
