package homework.homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertTrue;

public class Exercise1 {

    /*Develop a dedicated test for asserting 4 texts below 4 pictures on the Index Page -
    https://jdi-framework.github.io/tests/index.htm.
    The test must be developed with help of the DataProvider.
    Run it in the parallel by methods through the configuring parameters in a @DataProvider annotation.*/

    private static final String WINDOWS_GECKO_DRIVER_PATH = "windows-drivers/geckodriver.exe";
    private static final String WINDOWS_CHROME_DRIVER_PATH = "windows-drivers/chromedriver.exe";

    private WebDriver chromeDriver;

    @BeforeClass
    public void setUp() {
        setProperty("webdriver.chrome.driver", WINDOWS_CHROME_DRIVER_PATH);
        chromeDriver = new ChromeDriver();
    }

    @AfterClass
    public void tearDown() {
        chromeDriver.close();
    }

    @Test(threadPoolSize = 2, dataProvider = "provide")
    public void test(String text) {
        setProperty("webdriver.chrome.driver", WINDOWS_CHROME_DRIVER_PATH);
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
        WebElement element = chromeDriver.findElement(By.className("main-content"));

        assertTrue(element.isDisplayed());
        assertTrue(element.getText().contains(text));
        chromeDriver.close();
    }

    @DataProvider(parallel = true)
    public Object[][] provide() {
        return new Object[][]{
                {"To include good practices\n" + "and ideas from successful\n" + "EPAM projec"},
                {"To be flexible and\n" + "customizable"},
                {"To be multiplatform"},
                {"Already have good base\n" + "(about 20 internal and\n" +
                        "some external projects),\n" + "wish to get more…"}
        };
    }
}