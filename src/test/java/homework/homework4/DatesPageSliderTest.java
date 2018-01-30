package homework.homework4;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.page;
import static enums.UserCreds.*;
import static java.lang.System.setProperty;
import static literals.Paths.GECKO_DRIVER_PATH;

public class DatesPageSliderTest {

    private IndexPage indexPage;
    private DatesPage datesPage;

    @BeforeMethod
    public void setUp() {
        setProperty("webdriver.gecko.driver", GECKO_DRIVER_PATH);
        indexPage = page(IndexPage.class);
        datesPage = page(DatesPage.class);
    }

    @AfterMethod
    public void tearDown() {
        close();
    }

    //1 Create a new test in a new Java class, specify test name accordingly checking functionality
    @Test
    public void datesPageDragAndDropTest() {

        //2 Open test site by URL
        indexPage.openPage();

        //3 Perform login
        indexPage.performLogin(LOGIN.text, PASSWORD.text);

        //4 Assert User name in the left-top side of screen that user is loggined
        indexPage.checkIfUserLoggedIn(FULL_NAME.text);

        //5 Open Service -> Dates
        datesPage.openDatesPage();

        //6 Using drag-and-drop set Range sliders (left - 0, right - 100)
        datesPage.sliderDragAndDrop(0, 100);

        //7 Using drag-and-drop set Range sliders (left - 0, right - 0)
        datesPage.sliderDragAndDrop(0, 0);

        //8 Using drag-and-drop set Range sliders (left - 100, right - 100) p.s. this works very slow I don't know why!
        datesPage.sliderDragAndDrop(100, 100);

        //9 Using drag-and-drop set Range sliders (left - 30, right - 70)
        datesPage.sliderDragAndDrop(30, 70);
    }
}
