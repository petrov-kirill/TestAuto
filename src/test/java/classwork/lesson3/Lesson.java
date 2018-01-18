package classwork.lesson3;

import classwork.lesson3.pageobject.IndexPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static java.lang.System.setProperty;

public class Lesson {
    private WebDriver driver;
    private IndexPage indexPage;


    @BeforeClass
    public void setUpPages() {
        setProperty("webdriver.gecko.driver", "windows-drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        indexPage = PageFactory.initElements(driver, IndexPage.class);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test() {
        driver.navigate().to("http://jdi-framework.github.io/tests");
        indexPage.login("epam", "1234");
    }
}
