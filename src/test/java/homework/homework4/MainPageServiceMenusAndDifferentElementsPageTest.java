package homework.homework4;

import enums.ServiceOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static enums.CheckBoxes.WATER;
import static enums.CheckBoxes.WIND;
import static enums.Colors.YELLOW;
import static enums.RadioButtons.SELEN;
import static java.lang.System.setProperty;
import static literals.Constants.*;
import static literals.Paths.GECKO_DRIVER_PATH;

public class MainPageServiceMenusAndDifferentElementsPageTest {

    private static final String RADIO_BUTTON_NAME = "Selen";
    private static final String COLOR = "Yellow";

    private HomePage homePage;
    private DifferentElementsPage differentPage;

//    private String[] serviceHeaderOptions = {"SUPPORT", "DATES", "COMPLEX TABLE", "SIMPLE TABLE", "TABLE WITH PAGES",
//            "DIFFERENT ELEMENTS"};
//    private String[] serviceLeftOptions = {"Support", "Dates", "Complex Table", "Simple Table", "Table with pages",
//            "Different elements"};

    private ServiceOptions[] serviceOptions = ServiceOptions.values();

    @BeforeClass
    public void setUp() {
        setProperty("webdriver.gecko.driver", GECKO_DRIVER_PATH);
        homePage = page(HomePage.class);
        differentPage = page(DifferentElementsPage.class);
    }

    //1 Create a new test in a new Java class, specify test name accordingly checking functionality
    @Test
    public void loginAndCheckingElementsTestcase() {

        //2 Open test site by URL
        homePage.openPage();

        //3 Perform login
        homePage.performLogin(USER_LOGIN_NAME, PASSWORD);

        //4 Assert User name in the left-top side of screen that user is logged in
        homePage.checkIfUserLoggedIn(FULL_NAME);

        //5 Check interface on Home page, it contains all needed elements.
        homePage.checkIfPageContainsAllNeededElements(MAIN_HEADER, MAIN_PAGE_TEXT_BELOW_HEADER);

        //6 Click on "Service" subcategory in the header and check that drop down contains options
        homePage.checkHeaderServiceMenu(ServiceOptions.values());

        //7 Click on Service subcategory in the left section and check that drop down contains options
        homePage.checkLeftServiceMenu(ServiceOptions.values());

        //8 Open through the header menu Service -> Different Elements Page
        homePage.openDifferentElementPage();

        //9 Check interface on Service page, it contains all needed elements.
        differentPage.checkIfInterfaceContainsAllNeededElements();

        //10 Select and assert checkboxes
        differentPage.selectAndAssertCheckboxes(WATER.label, WIND.label);

        //11 Select radio
        differentPage.selectRadioButton(SELEN.label);

        //12 Select in dropdown
        differentPage.selectInDropdown(YELLOW.color);

        //13 Check in logs section selected values and status (true|false)
        differentPage.checkLogsForSelectedValues(WATER.label, WIND.label, SELEN.label, YELLOW.color);

        //14 Unselect and assert checkboxes
        differentPage.checkUnselectedCheckboxes(WATER.label, WIND.label);

        //15 Check in logs section unselected values and status (true|false)
        differentPage.checkLogsForUnselectedValues(WATER.label, WIND.label);
    }
}
