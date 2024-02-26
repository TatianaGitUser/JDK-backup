package co.wedevx.digitalbank.automation.ui.utilities;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;


import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class Driver {
    private static WebDriver driver;

    private Driver() {

    }

    public static WebDriver getDriver() {


        if (driver == null) {
            String browser = ConfigReader.getPropertiesValeu("digitalbank.browser");
            String jenkinsHome = System.getenv("JENKINS_HOME");

            if (jenkinsHome != null && !jenkinsHome.isEmpty()) {

                WebDriverManager.chromedriver().version("117.0.5938.149").setup();
                ChromeOptions options1 = new ChromeOptions();
                options1.addArguments("--window-size=1920,1080");
                options1.addArguments("--disable-extensions");
                options1.setExperimentalOption("useAutomationExtension", false);
                options1.addArguments("--proxy-sever='direct://'");
                options1.addArguments("--proxy-bypass-list=*");
                options1.addArguments("--start-maximized");
                options1.addArguments("--headless");
                driver = new ChromeDriver(options1);


            } else {
                switch (browser.toLowerCase()) {
                    case "chrome":
                        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\NewDriver\\chromedriver-win64\\chromedriver.exe");
                        ChromeOptions options1 = new ChromeOptions();
                        driver = new ChromeDriver(options1);
                        break;
                    case "safari":
                        driver = new SafariDriver();
                        break;
                    case "ie":
                        WebDriverManager.iedriver().setup();
                        driver = new InternetExplorerDriver();
                        break;
                    case "headless":
                        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\NewDriver\\chromedriver-win64\\chromedriver.exe");
                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("--window-size=1920,1080");
                        options.addArguments("disable-extensions");
                        options.setExperimentalOption("useAutomationExtension", false);
                        options.addArguments("--proxy-server='direct://'");
                        options.addArguments("--proxy-bypass-list=*");
                        options.addArguments("--start-maximized");
                        options.addArguments("--headless");
                        driver = new ChromeDriver(options);
                        break;
                    case "saucelabs":
                        String platform = ConfigReader.getPropertiesValeu("dbank.saucelabs.platform");
                        browser = ConfigReader.getPropertiesValeu("dbank.saucelabs.browser");
                        String browserVersion = ConfigReader.getPropertiesValeu("dbank.saucelabs.browser.version");
                        driver = loadSauceLabs(platform, browser, browserVersion);
                        break;
                    case "firefox":
                    default:
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                        break;
                }
            }
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public static void takeScreenShot(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//            adding the screenShot to report
            scenario.attach(screenshot, "image/png", "screenshot");
        }
    }

    public static void takeScreenShotToFolder(Scenario scenario) {
        if (scenario.isFailed()) {
            //taking a screenshot
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            // Specify the folder where you want to save the screenshots
            String screenshotFolderPath = "C:\\Users\\tatia\\OneDrive\\Рабочий стол\\CucumberScreenshots";

            // Generate a unique filename for the screenshot (e.g., using timestamp)
            String timestamp = Long.toString(System.currentTimeMillis());


            String screenshotFileName = "screenshot_" + timestamp + ".png";

            try {
                // Save the screenshot to the designated folder
                Path screenshotPath = Paths.get(screenshotFolderPath, screenshotFileName);
                Files.write(screenshotPath, screenshot);

                // Adding the screenshot to the report
                scenario.attach(screenshot, "image/png", "screenshot");

                // Print a message to the console
                System.out.println("Screenshot saved at: " + screenshotPath.toString());
            } catch (Exception e) {
                e.printStackTrace(); // Handle the exception according to your needs
            }
        }
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    private static WebDriver loadSauceLabs(String platform, String browserType, String browserVersion) {
//        WebDriverManager.chromedriver().setup();
//        how to use sauce labs?:
//        first get username and password
        String USERNAME = ConfigReader.getPropertiesValeu("dbank.saucelabs.username");
        String ACCESS_KEY = "a87e285e-b119-4b53-82a9-572e10f629e5";
        String HOST = ConfigReader.getPropertiesValeu("dbank.saucelabs.host");
// setup URL to the hub which is running on sauce labs VMs.
        String url = "https://" + USERNAME + ":" + ACCESS_KEY + "@" + HOST;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", platform);  //uses Enum
        capabilities.setCapability("browserName", browserType);
        capabilities.setCapability("browserVersion", browserVersion);

        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(url), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return driver;
    }
}
