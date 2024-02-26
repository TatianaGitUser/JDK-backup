package sauceLabs;

import co.wedevx.digitalbank.automation.ui.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

public class demo {
    public static WebDriver driver = Driver.getDriver();
    public static void main(String[] args) {
        driver.get("https://www.youtube.com/");

//        WebElement searchBox = driver.findElement(By.cssSelector("div.sc-sgtodf-7"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input.ytd-searchbox")));

        searchBox = driver.findElement(By.cssSelector("input.ytd-searchbox"));
        searchBox.sendKeys("Kittens");
//       Actions actions = new Actions(driver);
//        searchBox.sendKeys("Lamp");
//        searchBox.click();
//        actions.sendKeys(Keys.ENTER).perform();
        //



    }
}
