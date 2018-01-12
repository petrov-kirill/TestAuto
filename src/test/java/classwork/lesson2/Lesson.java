package classwork.lesson2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by eprupetw6980 on 12/01/2018.
 */
public class Lesson {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
     }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

     @Test
    public void test1() {
        driver.manage().window().maximize();
        driver.navigate().to("http://www.epam.com");
     }
}
