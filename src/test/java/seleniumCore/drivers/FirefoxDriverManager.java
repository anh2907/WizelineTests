package seleniumCore.drivers;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager extends DriverManager{
    @Override
    public void createWebDriver() {
        //System.setProperty("webdriver.gecko.driver","Path_of_Firefox_Driver");
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);

    }
}
