package homework.lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Exercise {

//    Create a new test

    @Test
    public void userLoginAndContentChecks() {

//        Create driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//        Open test site by URL
        driver.navigate().to("https://jdi-framework.github.io/tests");

//        Assert Browser title
        assertEquals(driver.getTitle(), "Index Page");

//        Perform login
        driver.findElement(By.cssSelector(".uui-profile-menu")).click();
        driver.findElement(By.id("Login")).sendKeys("epam");
        driver.findElement(By.id("Password")).sendKeys("1234");
        driver.findElement(By.cssSelector(".uui-button.dark-blue.btn-login")).click();

//        Assert that user is logged in
        WebElement piter_chailovskii = driver.findElement(By.className("profile-photo"));
        assertTrue(piter_chailovskii.isDisplayed());
        assertEquals(piter_chailovskii.getText(), "PITER CHAILOVSKII");

//        Assert Browser title
        assertEquals(driver.getTitle(), "Index Page");

//        Assert that there are 4 images on the Home Page and they are displayed
        List<WebElement> icons = driver.findElements(By.className("benefit-icon"));
        assertEquals(icons.size(), 4);
        for (WebElement element : icons) {
            assertTrue(element.isDisplayed());
        }

//        Assert that there are 4 texts on the Home Page and check them by getting texts
        List<WebElement> texts = driver.findElements(By.className("benefit-txt"));
        assertEquals(texts.size(), 4);
        for (WebElement element : texts) {
            assertTrue(element.isDisplayed());
        }
        assertEquals(texts.get(0).getText(), "To include good practices\n" + "and ideas from successful\n" + "EPAM projec");
        assertEquals(texts.get(1).getText(), "To be flexible and\n" + "customizable");
        assertEquals(texts.get(2).getText(), "To be multiplatform");
        assertEquals(texts.get(3).getText(), "Already have good base\n" + "(about 20 internal and\n" +
                "some external projects),\n" + "wish to get more…");

//        Assert that there are the main header and the text below it on the Home Page
        WebElement element = driver.findElement(By.className("main-content"));
        assertTrue(element.getText().contains("EPAM FRAMEWORK WISHES…"));
        assertTrue(element.getText().contains("LOREM IPSUM"));

        driver.close();
    }
}
