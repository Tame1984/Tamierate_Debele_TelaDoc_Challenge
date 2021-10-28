package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class DashboardUIPage {

    WebDriver driver;
    By ADDBUTTON = By.xpath("//button[text()=' Add User']");
    By FIRSTNAME = By.xpath("//input[@name='FirstName']");
    By LASTNAME = By.xpath("//input[@name='LastName']");
    By USERNAME = By.xpath("//input[@name='UserName']");
    By PASSWORD = By.xpath("//input[@name='Password']");
    By ROLEDROPDOWN = By.xpath("//select[@name='RoleId']");
    By EMAIL = By.xpath("//input[@name='Email']");
    By CELLPHONE = By.xpath("//input[@name='Mobilephone']");
    By SAVE_BUTTON = By.xpath("//button[text()='Save']");
    By TABLE_FIRST_ROW = By.xpath("//table[@config='globalConfig']/tbody/tr[1]");
    By SEARCHBAR = By.xpath("//input[@placeholder='Search']");
    By OK_BUTTON = By.xpath("//button[text()='OK']");
    By TABLE_CONTENT = By.xpath("//table[@config='globalConfig']/tbody");

    public void clearSearchBar() {
        driver.findElement(SEARCHBAR).clear();
    }
    public String getTableContent(){
        return driver.findElement(TABLE_CONTENT).getText();
    }

    public DashboardUIPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getFirstRow(){
        WebElement element = driver.findElement(TABLE_FIRST_ROW);
        return element;
    }

    public void clickSaveButton() {
        driver.findElement(SAVE_BUTTON).click();
    }

    public void clickAddButton() {
        driver.findElement(ADDBUTTON).click();
    }

    public void clickOkButton() {
        driver.findElement(OK_BUTTON).click();
    }

    public void setFirstName(String Text) {
        driver.findElement(FIRSTNAME).sendKeys(Text);
    }

    public void setLastName(String Text) {
        driver.findElement(LASTNAME).sendKeys(Text);
    }

    public void setUsername(String Text) {
        driver.findElement(USERNAME).sendKeys(Text);
    }

    public void setPassword(String Text) {
        driver.findElement(PASSWORD).sendKeys(Text);
    }

    public void selectRoleFromDropDown(String Text) {
        Select DROPDOWN = new Select(driver.findElement(ROLEDROPDOWN));
        DROPDOWN.selectByVisibleText(Text);
    }

    public void deleteUserFromTable(String username){
        WebElement Table = driver.findElement(TABLE_CONTENT);
        List<WebElement> Rows =  Table.findElements(By.tagName("tr"));
        for(WebElement row: Rows){
            List<WebElement> data = row.findElements(By.tagName("td"));
            if(data.get(2).getText().equalsIgnoreCase(username))
            {
                List<WebElement> buttons = row.findElements(By.tagName("button"));
                buttons.get(1).click();
            }
        }

    }

    public void setEmail(String Text) {
        driver.findElement(EMAIL).sendKeys(Text);
    }

    public void setCellphone(String Text) {
        driver.findElement(CELLPHONE).sendKeys(Text);
    }

    public void selectCompany(String Text) {
        driver.findElement(By.xpath(createCompanyElement(Text))).click();
    }

    public String createCompanyElement(String Text){
        String xpath = "//label[text()='"+ Text +"']/input";
        return xpath;
    }
}