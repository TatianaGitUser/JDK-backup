package co.wedevx.digitalbank.automation.ui.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

//WebDriver Helper Extensions is designed to simplify Java based Selenium/WebDriver tests.
//It's built on top of Selenium/WebDriver to make your tests more readable, reusable and
//maintainable by providing easy handling towards browser and advance identifiers.
public class BrowserHelper {

    public static WebElement waitForVisibilityOfElement(WebDriver driver, WebElement element, int timeToWaitInSec){
        WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitUntilTheElementIsClickableAndClick(WebDriver driver, WebElement element, int timeToWaitInSec){
        WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSec);
        WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        clickableElement.click();
        return clickableElement;
    }

    public static WebElement fluentWaitForElementPresence(WebDriver driver, WebElement element, int maxTimeWaitInSec) {
        try {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(maxTimeWaitInSec, TimeUnit.SECONDS)
                    .pollingEvery(500, TimeUnit.MILLISECONDS)
                    .ignoring(NoSuchElementException.class);

            return wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            e.printStackTrace();
            // You may want to handle the exception according to your requirements
            return null; // or throw an exception if you prefer
        }
    }

    public static void scrollIntoView(WebDriver driver, WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView()", element);
        } catch (Exception e) {
            e.printStackTrace();
            // You may want to handle the exception according to your requirements
        }
    }

    public static void clickElementWithText(WebDriver driver, String string){
        try{
            WebElement elementToBeClicked = driver.findElement(By.partialLinkText(string));
            if(elementToBeClicked != null){
                elementToBeClicked.click();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void fillTextInput (WebDriver driver, WebElement element, String string){
        scrollIntoView(driver, element);
        try{
            if(element.isDisplayed() || element.isEnabled()){
                Actions actions = new Actions(driver);
                actions.keyDown(element, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(string).perform();
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Element is not visible or is not interactable");
        }
    }
}
