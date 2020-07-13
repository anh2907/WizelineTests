package seleniumTest.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import seleniumCore.drivers.DriverManager;
import seleniumCore.drivers.DriverManagerFactory;
import seleniumCore.drivers.DriverType;
import seleniumTest.dataDriven.LoginDataProvider;
import seleniumTest.dataDriven.ReadExcelFile;
import seleniumTest.pageObjectModel.LoginPage;

public class LoginValidationTests {
    DriverManager driverManager;
    public WebDriver driver;
    LoginPage loginPage;
    LoginLibrary loginLibrary;
    ReadExcelFile readExcelFile;
    @BeforeMethod
    public void setUp(){
        driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
        driver = driverManager.getWebDriver();
        loginPage = new LoginPage(driver);
        loginLibrary = new LoginLibrary(driver);
        readExcelFile = new ReadExcelFile("C:\\Users\\anhntnguyen\\IdeaProjects\\SeleniumFramework\\src\\test\\TestDatata\\AmazonTestData.xlsx");
        driver.get("https://www.utest.com/signup/personal");
        driver.manage().window().maximize();
        Assert.assertEquals("Amazon.com: ",driver.getTitle());
    }
    @Test(dataProvider = "Step1", dataProviderClass = LoginDataProvider.class)
    public void loginStep1(String firstName, String lastName, String email) {
        //loginLibrary.login();
        loginPage.SignInStep1(firstName, lastName, email);

    }

    @AfterMethod
    public void tearDown(){
        driverManager.quitWebDriver();
    }
}
