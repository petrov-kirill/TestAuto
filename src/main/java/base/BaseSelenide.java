package base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.setProperty;
import static literals.Paths.CHROME_DRIVER_PATH;
import static literals.Paths.GECKO_DRIVER_PATH;

public abstract class BaseSelenide {

    @BeforeSuite
    public void setUpSuite() {
        setProperty("webdriver.gecko.driver", GECKO_DRIVER_PATH);
        setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        Configuration.browser = "chrome";
        Configuration.startMaximized = false;
        Configuration.timeout = 6000;
        Configuration.pollingInterval = 200;
        Configuration.collectionsPollingInterval = 300;
    }
}
