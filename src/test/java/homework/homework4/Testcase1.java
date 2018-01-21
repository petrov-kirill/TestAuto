package homework.homework4;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static java.lang.System.setProperty;
import static utils.Constants.*;

public class Testcase1 {

    private static final String RADIO_BUTTON_NAME = "Selen";
    private static final String COLOR = "Yellow";

    private HomePage homePage;
    private DifferentElementsPage differentPage;
    private String[] serviceHeaderOptions = {"SUPPORT", "DATES", "COMPLEX TABLE", "SIMPLE TABLE", "TABLE WITH PAGES",
            "DIFFERENT ELEMENTS"};
    private String[] serviceLeftOptions = {"Support", "Dates", "Complex Table", "Simple Table", "Table with pages",
            "Different elements"};

    @BeforeClass
    public void setUp() {
        setProperty("webdriver.gecko.driver", GECKO_DRIVER_PATH);
        homePage = new HomePage();
        differentPage = new DifferentElementsPage();
    }

    //1 Create a new test in a new Java class, specify test name accordingly checking functionality
    @Test
    public void testCaseForLoginAndElementsAssertions() {

        //2 Open test site by URL
        open(MAIN_PAGE_URL);

        //3 Perform login
        homePage.performLogin(USER_LOGIN_NAME, PASSWORD);

        //4 Assert User name in the left-top side of screen that user is logged in
        homePage.checkIfUserLoggedIn(FULL_NAME);

        //5 Check interface on Home page, it contains all needed elements.
        homePage.checkIfPageContainsAllNeededElements("EPAM FRAMEWORK WISHES…", "LOREM IPSUM");

        //6 Click on "Service" subcategory in the header and check that drop down contains options
        homePage.checkHeaderServiceMenu(serviceHeaderOptions);

        //7 Click on Service subcategory in the left section and check that drop down contains options
        homePage.checkLeftServiceMenu(serviceLeftOptions);

        //8 Open through the header menu Service -> Different Elements Page
        homePage.openDifferentElementPage();

        //9 Check interface on Service page, it contains all needed elements.
        differentPage.checkIfInterfaceContainsAllNeededElements();

        //10 Select and assert checkboxes
        differentPage.selectAndAssertCheckboxes("Water", "Wind");

        //11 Select radio
        differentPage.selectRadioButton(RADIO_BUTTON_NAME);

        //12 Select in dropdown
        differentPage.selectInDropdown(COLOR);

        //13 Check in logs section selected values and status (true|false)
        differentPage.checkLogsForSelectedValues("Water", "Wind", RADIO_BUTTON_NAME, COLOR);

        //14 Unselect and assert checkboxes
        differentPage.checkUnselectedCheckboxes("Water", "Wind");

        //15 Check in logs section unselected values and status (true|false)
        differentPage.checkLogsForUnselectedValues("false", "Water", "Wind");
    }
}
