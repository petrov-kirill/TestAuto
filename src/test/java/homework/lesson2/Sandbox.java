package homework.lesson2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import static java.lang.System.setProperty;

public class Sandbox {

    private static final String GECKO_PATH = "linux-drivers/geckodriver";
    private WebDriver gecko;
    private JavascriptExecutor js;
    private JavascriptExecutor js2;


    @BeforeSuite
    public void suiteSetUp() {
        System.out.println("Are you ready?!");
        setProperty("webdriver.gecko.driver", GECKO_PATH);
//        gecko = new FirefoxDriver();


    }

    @AfterSuite
    public void suiteTearDown() {
        System.out.println("That was fun!!!");
    }

    @BeforeMethod()
    public void setUp() {
//        setProperty("webdriver.gecko.driver", GECKO_PATH);
//        gecko.manage().window().maximize();
    }

    @AfterMethod()
    public void tearDown(ITestResult result) {
        System.out.println(result.getName());
//        gecko.close();
    }


    @DataProvider(name = "TestData")
    public Object[][] getData() {
        return new Object[][]{{"user1", "pass1"}, {"user2", "pass2"}, {"user3", "pass3"}};
    }

    @Ignore
    @Test()
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
