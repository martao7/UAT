package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class UserInfoPage {
    private static WebDriver driver;

    public UserInfoPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
/*
    @FindBy(id = "id_gender1")
    private WebElement titleCheck;

    @FindBy(id = "customer_firstname")
    private WebElement firstNameInput;

    @FindBy(id = "customer_lastname")
    private WebElement lastName;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "days")
    private WebElement dayOfBirth;

    @FindBy(id = "months")
    private WebElement monthOfBirth;

    @FindBy(id = "years")
    private WebElement yearOfBirth;

    @FindBy(id = "newsletter")
    private WebElement newsletterCheck;

    @FindBy(id = "submitAccount")
    private WebElement submitButton;
 */

    @FindBy(className = "alert alert-success")
    private WebElement myAccountIsAdded;


    public void addInfo(String firstname, String lastname, String password, String dayOfBirth, String monthOfBirth, String yearOfBirth){

        WebElement titleCheck = driver.findElement(By.id("id_gender1"));
        if (!titleCheck.isSelected())
            titleCheck.click();


        WebElement firstNameInput = driver.findElement(By.id("customer_firstname"));
        firstNameInput.click();
        firstNameInput.clear();
        firstNameInput.sendKeys(firstname);


        WebElement lastNameInput = driver.findElement(By.name("customer_lastname"));
        lastNameInput.click();
        lastNameInput.clear();
        lastNameInput.sendKeys(lastname);


        WebElement passwordInput = driver.findElement(By.id("passwd"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);


        WebElement dayOfBirthAdd = driver.findElement(By.id("days"));
        Select dayOfBirthAddSelect = new Select(dayOfBirthAdd);
        dayOfBirthAddSelect.selectByValue(dayOfBirth);
        dayOfBirthAdd.click();


        WebElement MonthOfBirthAdd = driver.findElement(By.id("months"));
        Select MonthOfBirthAddSelect = new Select(MonthOfBirthAdd);
        MonthOfBirthAddSelect.selectByValue(monthOfBirth);
        MonthOfBirthAdd.click();


        WebElement YearOfBirthAdd = driver.findElement(By.id("years"));
        Select YearOfBirthAddSelect = new Select(YearOfBirthAdd);
        YearOfBirthAddSelect.selectByValue(yearOfBirth);
        YearOfBirthAdd.click();


        WebElement newsletterCheck = driver.findElement(By.id("newsletter"));
        if (!newsletterCheck.isSelected())
            newsletterCheck.click();


        WebElement submitButton = driver.findElement(By.id("submitAccount"));
        submitButton.click();
    }

    public String getLoggedUsername() {
        return myAccountIsAdded.getText();
    }
}

