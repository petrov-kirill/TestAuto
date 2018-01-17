package homework.homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertTrue;

public class Sandbox {

    private static final String LINUX_GECKO_DRIVER_PATH = "linux-drivers/geckodriver";
    private static final String WINDOWS_CHROME_DRIVER_PATH = "windows-drivers/chromedriver.exe";
    private static final String WINDOWS_GECKO_DRIVER_PATH = "windows-drivers/geckodriver.exe";
    private WebDriver gecko;
    private JavascriptExecutor js;
    private JavascriptExecutor js2;


    @BeforeSuite
    public void suiteSetUp() {
        System.out.println("Are you ready?!");
        setProperty("webdriver.gecko.driver", WINDOWS_GECKO_DRIVER_PATH);
        setProperty("webdriver.chrome.driver", WINDOWS_CHROME_DRIVER_PATH);
//        gecko = new FirefoxDriver();


    }

    @AfterSuite
    public void suiteTearDown() {
        System.out.println("That was fun!!!");
    }

    @BeforeMethod()
    public void setUp() {
        gecko = new FirefoxDriver();
        js = (JavascriptExecutor) gecko;
    }

    @AfterMethod()
    public void tearDown(ITestResult result) {
        System.out.println(result.getName());
        gecko.close();
    }


    @DataProvider(name = "TestData")
    public Object[][] getData() {
        return new Object[][]{{"user1", "pass1"}, {"user2", "pass2"}, {"user3", "pass3"}};
    }


    @Test
    public void testWithoutDP() throws InterruptedException {
        gecko.navigate().to("http://www.epam.com");
        gecko.navigate().to("http://www.google.com");
        gecko.navigate().to("http://www.yandex.com");
        gecko.navigate().to("http://www.vk.com");
        gecko.findElement(By.id("index_email")).sendKeys("oioioi@oioioi");
        gecko.findElement(By.id("index_pass")).sendKeys("oioioi");
        gecko.findElement(By.id("index_login_button")).click();
        Thread.sleep(2222);
        js.executeScript("alert('boooo, you suck')");
        Thread.sleep(2222);
        gecko.switchTo().alert().accept();
        Thread.sleep(1333);
    }

    @Ignore
    @Test(dataProvider = "TestData", groups = {"group1"})
    public void testWithDP(String username, String password) throws InterruptedException {
        gecko.navigate().to("http://www.vk.com");
        gecko.findElement(By.id("index_email")).sendKeys(username);
        gecko.findElement(By.id("index_pass")).sendKeys(password);
        gecko.findElement(By.id("index_login_button")).click();
        Thread.sleep(2222);
        js.executeScript("alert('boooo, you suck')");
        Thread.sleep(2222);
        gecko.switchTo().alert().accept();
        Thread.sleep(1333);
    }

    @Ignore
    @Test(dataProvider = "provide", dataProviderClass = DPClass.class, groups = {"group2"})
    public void testWithDPClass(String username, String password) throws InterruptedException {
        WebDriver gecko = new FirefoxDriver();
        js = (JavascriptExecutor) gecko;
        gecko.navigate().to("http://www.vk.com");
        gecko.findElement(By.id("index_email")).sendKeys(username);
        gecko.findElement(By.id("index_pass")).sendKeys(password);
        gecko.findElement(By.id("index_login_button")).click();
        Thread.sleep(2222);
        js.executeScript("alert('boooo, you suck')");
        Thread.sleep(2222);
        gecko.switchTo().alert().accept();
        Thread.sleep(1333);
        gecko.close();
    }


    @Test(dataProviderClass = DPClass2.class, dataProvider = "provide")
    public void testWithDPClass2(String username, String password) throws InterruptedException {
        WebDriver gecko = new FirefoxDriver();
        js2 = (JavascriptExecutor) gecko;
        gecko.navigate().to("http://www.vk.com");
        gecko.findElement(By.id("index_email")).sendKeys(username);
        gecko.findElement(By.id("index_pass")).sendKeys(password);
        gecko.findElement(By.id("index_login_button")).click();
        Thread.sleep(2222);
        js2.executeScript("alert('just kiddin you`re fine')");
        Thread.sleep(2222);
        gecko.switchTo().alert().accept();
        Thread.sleep(1333);
        gecko.close();
    }


    @Test(threadPoolSize = 1, dataProvider = "provide")
    public void test3(String text) {
        setProperty("webdriver.chrome.driver", WINDOWS_CHROME_DRIVER_PATH);
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
        WebElement element = chromeDriver.findElement(By.className("main-content"));

        assertTrue(element.isDisplayed());
        assertTrue(element.getText().contains(text));
//        chromeDriver.close();
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

//
//    @Test()
//    public void parallelTest1() throws InterruptedException {
//        for (int i = 0; i < 190; i++) {
//            System.out.println("first");
//            Thread.sleep(30);
//        }
//    }
//
//
//    @Test()
//    public void parallelTest2() throws InterruptedException {
//        for (int i = 0; i < 100; i++) {
//            System.out.println("second");
//            Thread.sleep(30);
//        }
//    }


    public static class DPClass {

        @DataProvider
        public Object[][] provide() {
            return new Object[][] {{"user4", "pass4"}, {"user5","pass5"}};
        }
    }

    public static class DPClass2 {

        @DataProvider
        public Object[][] provide() {
            return new Object[][] {{"user4", "pass4"}, {"user5","pass5"}};
        }
    }
}
