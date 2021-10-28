package stepsDefinition;

import Commons.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DashboardUIPage;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class usersteps extends TestBase {

    public static WebDriver driver;

    @Before
    public void beforeScenario(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Given("^I opened the url$")
    public void user_is_on_homepage() throws Throwable {
        driver.get(getUrl());
    }

    @When("^I clicked on Add User Button$")
    public void iClickedOnAddButton() throws Throwable {
        DashboardUIPage dashboard = new DashboardUIPage(driver);
        dashboard.clickAddButton();
    }

    @When("^I click on save button$")
    public void iClickOnSaveButton() throws Throwable {
        DashboardUIPage dashboard = new DashboardUIPage(driver);
        dashboard.clickSaveButton();
    }

    @After
    public void afterScenario()
    {
        driver.close();
    }

    @Then("Verify new user is added with username {string}")
    public void verifyNewUserIsAddedWithUsername(String arg0) {
        DashboardUIPage dashboard = new DashboardUIPage(driver);
        assertTrue(dashboard.getFirstRow().getText().contains(arg0),"User is not added on First Row");
    }

    @And("I filled {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} values in form")
    public void iFilledValuesInForm(String FirstName, String LastName, String username, String password, String customer, String Role, String Email, String CellPhone) {
        DashboardUIPage AddUser = new DashboardUIPage(driver);
        AddUser.setFirstName(FirstName);
        AddUser.setLastName(LastName);
        AddUser.setUsername(username);
        AddUser.setPassword(password);
        AddUser.selectCompany(customer);
        AddUser.selectRoleFromDropDown(Role);
        AddUser.setEmail(Email);
        AddUser.setCellphone(CellPhone);
    }

    @When("I clicked delete button for user with username as {string}")
    public void iClickedDeleteButtonForUserWithUsernameAsUsername(String username) {
        DashboardUIPage dashboard = new DashboardUIPage(driver);
        dashboard.deleteUserFromTable(username);
    }

    @And("I clicked on Ok button")
    public void iClickedOnOkButton() {
        DashboardUIPage dashboard = new DashboardUIPage(driver);
        dashboard.clickOkButton();
        dashboard.clearSearchBar();
    }

    @Then("Verify that user {string} is not available in table")
    public void verifyThatUserIsNotAvailableInTable(String username) {
        DashboardUIPage dashboard = new DashboardUIPage(driver);
        assertFalse(dashboard.getTableContent().contains(username), "Data is available in Table");
    }
}