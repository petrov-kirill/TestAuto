package classwork.lesson2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;

/**
 * Created by eprupetw6980 on 12/01/2018.
 */
public class Lesson {

    private static final String DRIVER_PATH = "linux-drivers/chromedriver";

    private WebDriver driver;

    @BeforeMethod
    public void before(Method method) {
        System.out.println(method.getName());
        setProperty("webdriver.chrome.driver", DRIVER_PATH);
        driver = new ChromeDriver();
    }

    @Ignore
    @Test
    public void simpleTest() {
        driver.navigate().to("https://www.epam.com");
        assertEquals(driver.getTitle(),  "EPAM | Software Product Development Services");
    }

    @AfterMethod
    public void after(ITestResult result) {
        System.out.println("start millis: " + result.getStartMillis());
        System.out.println("end millis: " + result.getEndMillis());
        System.out.println("result status: " + result.getStatus());
        System.out.println("class name is: " + result.getTestClass());
        driver.close();
    }

}
