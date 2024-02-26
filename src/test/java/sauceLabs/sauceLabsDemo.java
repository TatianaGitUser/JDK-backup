package sauceLabs;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class sauceLabsDemo {
    public static void main(String[] args) throws MalformedURLException {
//        WebDriverManager.chromedriver().setup();
//        how to use sauce labs?:
//        first get username and password
        String USERNAME = "oauth-tatiana.ch35-3e59d";
        String ACCESS_KEY = "a87e285e-b119-4b53-82a9-572e10f629e5";
// setup URL to the hub which is running on sauce labs VMs.
        String url = "https://oauth-tatiana.ch35-3e59d:a87e285e-b119-4b53-82a9-572e10f629e5@ondemand.us-west-1.saucelabs.com:443/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", Platform.WIN10);  //uses Enum
        capabilities.setCapability("browserName", BrowserType.CHROME);
        capabilities.setCapability("browserVersion", "latest");

        WebDriver driver = new RemoteWebDriver(new URL(url), capabilities);

        driver.get("https://amazon.com/");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Iphone"+ Keys.ENTER);

        assertEquals("https://amazon.com/", driver.getCurrentUrl());
        driver.close();
    }
}
