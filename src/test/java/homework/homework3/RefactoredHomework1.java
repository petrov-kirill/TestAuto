package homework.homework3;

import enums.IndexPageTextsEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static enums.IndexPageTextsEnum.TEXT_1;
import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RefactoredHomework1 {

    private static final String CHROME_DRIVER_PATH = "windows-drivers/chromedriver.exe";

    private WebDriver driver;
    private PageObjects pageObjects;

    @BeforeClass
    public void setUpPages() {
        setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        PageFactory.initElements(driver, PageObjects.class);
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
        pageObjects.checkPageTitle(driver);


        pageObjects.checkTextsUnderImages(TEXT_1);

        pageObjects.checkTextsUnderImages(IndexPageTextsEnum.values());


        //4 Perform login
        pageObjects.login("epam", "1234");

        //5 Assert that user is logged in
        assertTrue(pageObjects.profileName.isDisplayed());
        assertEquals(pageObjects.profileName.getText(), "PITER CHAILOVSKII");

        //6 Assert that there are 4 images on the Home Page and they are displayed
        List<WebElement> images = pageObjects.imagesOnHomePage;
        assertEquals(images.size(), 4);
        for (WebElement element : images) {
            assertTrue(element.isDisplayed());
        }

        //7 Assert that there are 4 texts on the Home Page and check them by getting texts
        List<WebElement> texts = pageObjects.textOnHomePage;
        assertEquals(texts.size(), 4);
        for (WebElement element : texts) {
            assertTrue(element.isDisplayed());
        }
        assertEquals(texts.get(0).getText(), "To include good practices\n" + "and ideas from successful\n" + "EPAM projec");
        assertEquals(texts.get(1).getText(), "To be flexible and\n" + "customizable");
        assertEquals(texts.get(2).getText(), "To be multiplatform");
        assertEquals(texts.get(3).getText(), "Already have good base\n" + "(about 20 internal and\n" +
                "some external projects),\n" + "wish to get more…");

        //8 Assert that there are the main header and the text below it on the Home Page

    }
}
