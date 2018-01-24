package homework.homework4;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static java.lang.System.setProperty;
import static literals.Paths.GECKO_DRIVER_PATH;
import static literals.Urls.DATES_PAGE_URL;
import static literals.Urls.MAIN_PAGE_URL;

public class DatesPageSliderTest {

    private HomePage homePage;
    private DatesPage datesPage;

    @BeforeClass
    public void setUp() {
        setProperty("webdriver.gecko.driver", GECKO_DRIVER_PATH);
        homePage = new HomePage();
        datesPage = new DatesPage();
    }

    //1 Create a new test in a new Java class, specify test name accordingly checking functionality
    @Test
    public void test() {

        //2 Open test site by URL
        open(MAIN_PAGE_URL);

        //3 Perform login
        homePage.performLogin();

        //4 Assert User name in the left-top side of screen that user is loggined
        homePage.checkIfUserLoggedIn();

        //5 Open Service -> Dates
        //TODO ...WRONG!!!
        open(DATES_PAGE_URL);

        //6 Using drag-and-drop set Range sliders
        datesPage.sliderManipulations();
    }
}
