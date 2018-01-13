package classwork.lesson2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.setProperty;

public abstract class TestBase {

    private static final String DRIVER_PATH = "linux-drivers/chromedriver";
    public static WebDriver driver;


//    инициализаци и присвоение конкретного драйвера перед выполнением тестов, выполнится один раз.
    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        setProperty("webdriver.chrome.driver", DRIVER_PATH);
        driver = new ChromeDriver();
    }

//    выполнится один раз, после выполнения тестов
    @AfterSuite
    public void tearDown() {
        driver.close();
    }
}
