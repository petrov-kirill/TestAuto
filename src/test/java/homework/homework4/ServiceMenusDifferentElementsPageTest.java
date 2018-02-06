package homework.homework4;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.page;
import static enums.CheckBoxes.WATER;
import static enums.CheckBoxes.WIND;
import static enums.Colors.YELLOW;
import static enums.RadioButtons.SELEN;
import static enums.UserCreds.*;
import static java.lang.System.setProperty;
import static literals.Paths.GECKO_DRIVER_PATH;

public class ServiceMenusDifferentElementsPageTest {

    private IndexPage indexPage;
    private DifferentElementsPage differentPage;

    @BeforeMethod
    public void setUp() {
        setProperty("webdriver.gecko.driver", GECKO_DRIVER_PATH);
        indexPage = page(IndexPage.class);
        differentPage = page(DifferentElementsPage.class);
    }

    @AfterMethod
    public void tearDown() {
        close();
    }

    //1 Create a new test in a new Java class, specify test name accordingly checking functionality
    @Test
    public void loginAndCheckingElementsTestcase() {

        //2 Open test site by URL
        indexPage.openPage();

        //3 Perform login
        indexPage.performLogin(LOGIN.text, PASSWORD.text);

        //4 Assert User name in the left-top side of screen that user is logged in
        indexPage.checkIfUserLoggedIn(FULL_NAME.text);

        //5 Check interface on Home page, it contains all needed elements.
        indexPage.checkIfPageContainsAllNeededElements();

        //6 Click on "Service" subcategory in the header and check that drop down contains options
        indexPage.checkHeaderServiceMenu();

        //7 Click on Service subcategory in the left section and check that drop down contains options
        indexPage.checkLeftServiceMenu();

        //8 Open through the header menu Service -> Different Elements Page
        indexPage.openDifferentElementPage();

        //9 Check interface on Service page, it contains all needed elements.
        differentPage.checkIfInterfaceContainsAllNeededElements();

        //10 Select and assert checkboxes
        differentPage.selectAndAssertCheckboxes(WATER.label, WIND.label);

        //11 Select radio
        differentPage.selectRadioButton();

        //12 Select in dropdown
        differentPage.selectInDropdown();

        //13 Check in logs section selected values and status (true|false)
        differentPage.checkLogsForSelectedValues("false", WATER.label, WIND.label, SELEN.label, YELLOW.color);

        //14 Unselect and assert checkboxes
        differentPage.checkUnselectedCheckboxes(WATER.label, WIND.label);

        //15 Check in logs section unselected values and status (true|false)
        differentPage.checkLogsForUnselectedValues("false", WATER.label, WIND.label);
    }
}
