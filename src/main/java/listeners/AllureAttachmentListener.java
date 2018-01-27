package listeners;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.sql.SQLException;

import static java.sql.DriverManager.getDriver;

public class AllureAttachmentListener extends TestListenerAdapter {

    @Attachment(value = "Attachment: {0}", type = "image/png")
    public byte[] makeScreenshot() throws SQLException {
        byte[] array = {1};
        try {
            return ((TakesScreenshot) getDriver("https://www.google.com")).getScreenshotAs(OutputType.BYTES);
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
        return array;
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        try {
            makeScreenshot();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        try {
            makeScreenshot();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
