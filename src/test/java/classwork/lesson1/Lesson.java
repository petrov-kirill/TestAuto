package classwork.lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;

public class Lesson {

    @Test
    public void test() {
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("http://www.epam.com");

        assertEquals(driver.getTitle(), "EPAM | Software Product Development Services");
        driver.close();
    }

    @Test
    public void test2() {
        setProperty("webdriver.chrome.driver", "C:/Users/Kirill_Petrov/Downloads/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://www.epam.com");
        driver.close();
    }

    @Test
    public void test3() {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://www.epam.com");

        assertEquals(driver.getTitle(), "EPAM | Software Product Development Services");
        driver.close();
    }

    @Test
    public void test4() {
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("http://www.epam.com");
        WebElement element = driver.findElement(By.id("submit-id"));
        List<WebElement> elements = driver.findElements(By.tagName("li"));
        driver.findElement(By.className("options-class"));
        driver.findElement(By.name("button-name"));
        driver.findElement(By.cssSelector(".options"));
        driver.findElement(By.xpath("li[@name='button-name']"));
        driver.findElement(By.linkText("Contact Us"));
        driver.findElement(By.partialLinkText("Contact"));
    }
}
