package seleniumTest.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;
    //Constructor of this Page Object
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    //Element locators of the web elements on this page
    private By firstNameInput = By.xpath(".//input[@id='firstName']");
    private By lastNameInput = By.xpath(".//input[@id='lastName']");
    private By emailInput = By.xpath(".//input[@id='email']");
    private By monthList = By.xpath(".//div[@class='col-xs-5 col-md-5 col-lg-5 months']");
    private By dayList = By.xpath(".//div[@class='col-xs-3 col-md-3 col-lg-3 days']");
    private By yearList = By.xpath(".//div[@class='col-xs-4 col-md-4 col-lg-4 years']");
    private By selectedMonth = By.xpath(".//span[contains(text(),'June')]");
    private By selectedDay = By.xpath(".//span[contains(text(),'18')]");
    private By selectedYear = By.xpath(".//span[contains(text(),'2000')]");
    public By nextButton = By.xpath(".//a[@aria-label='Next step - define your location']");

    //Signin Step1 method with valid information
    public void SignInStep1(String firstName, String lastName, String email){
        this.setFirstNameInput(firstName);
        this.setLastNameInput(lastName);
        this.setEmailInput(email);
        this.selectMonthValue();
        this.selectDayValue();
        this.selectYearValue();
        this.clickNextButton();
    }
    public void setFirstNameInput (String firstName){
        this.driver.findElement(firstNameInput).sendKeys(firstName);
    }
    public void setLastNameInput(String lastName){
        this.driver.findElement(lastNameInput).sendKeys(lastName);
    }
    public void setEmailInput(String email){
        this.driver.findElement(emailInput).sendKeys(email);
    }
    public void clickNextButton(){
        this.driver.findElement(nextButton).click();
    }
    public void selectMonthValue(){
        this.driver.findElement(monthList).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectedMonth));
        this.driver.findElement(selectedMonth).click();

    }
    public void selectDayValue(){
        this.driver.findElement(dayList).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectedDay));
        this.driver.findElement(selectedDay).click();

    }
    public void selectYearValue(){
        this.driver.findElement(yearList).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectedYear));
        this.driver.findElement(selectedYear).click();

    }

}
