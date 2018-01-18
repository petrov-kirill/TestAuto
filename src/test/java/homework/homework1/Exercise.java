package homework.homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Exercise {

    private static final String CHROME_DRIVER_PATH =
            "C:\\Users\\Kirill_Petrov\\IdeaProjects\\TestAuto\\src\\test\\resources\\windows-drivers\\chromedriver.exe";

    private WebDriver driver;

    @BeforeClass
    public void setUpPages() {
        setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

    //1 Create a new test
    @Test
    public void userLoginAndContentChecks() {
        //2 Open test site by URL
        driver.navigate().to("https://jdi-framework.github.io/tests");

        //3 Assert Browser title
        assertEquals(driver.getTitle(), "Index Page");

        //4 Perform login
        driver.findElement(By.cssSelector(".uui-profile-menu")).click();
        driver.findElement(By.id("Login")).sendKeys("epam");
        driver.findElement(By.id("Password")).sendKeys("1234");
        driver.findElement(By.cssSelector(".uui-button.dark-blue.btn-login")).click(); //TODO think about it!

        //5 Assert that user is logged in
        WebElement profileName = driver.findElement(By.className("profile-photo"));
        assertTrue(profileName.isDisplayed());
        assertEquals(profileName.getText(), "PITER CHAILOVSKII");

        //6 Assert Browser title
        assertEquals(driver.getTitle(), "Index Page");

        //7 Assert that there are 4 images on the Home Page and they are displayed
        List<WebElement> icons = driver.findElements(By.className("benefit-icon"));
        assertEquals(icons.size(), 4);
        for (WebElement element : icons) {
            assertTrue(element.isDisplayed());
        }

        //8 Assert that there are 4 texts on the Home Page and check them by getting texts
        List<WebElement> texts = driver.findElements(By.className("benefit-txt"));
        assertEquals(texts.size(), 4);
        for (WebElement element : texts) {
            assertTrue(element.isDisplayed());
        }
        assertEquals(texts.get(0).getText(), "To include good practices\nand ideas from successful\nEPAM projec");
        assertEquals(texts.get(1).getText(), "To be flexible and\ncustomizable");
        assertEquals(texts.get(2).getText(), "To be multiplatform");
        assertEquals(texts.get(3).getText(), "Already have good base\n(about 20 internal and\n" +
                "some external projects),\nwish to get more…");

        //9 Assert that there are the main header and the text below it on the Home Page
        WebElement element = driver.findElement(By.className("main-content"));
        assertTrue(element.getText().contains("EPAM FRAMEWORK WISHES…"));
        assertTrue(element.getText().contains("LOREM IPSUM"));
    }
}
