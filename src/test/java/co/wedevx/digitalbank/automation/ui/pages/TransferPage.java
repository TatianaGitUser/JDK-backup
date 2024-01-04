package co.wedevx.digitalbank.automation.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TransferPage {
    private WebDriver driver;
    public TransferPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "fromAccount")
    private WebElement transferFromDropDown;
    @FindBy(id = "toAccount")
    private WebElement toAccountDropDown;
    @FindBy (id = "amount")
    private WebElement amountField;
    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm']")
    private WebElement submitBtn;
    @FindBy(xpath = "(//div[@class='h4 m-0'])[4]")
    private WebElement secondCardBalance;

    public void transfer (){
        Select select = new Select(transferFromDropDown);
        select.selectByIndex(1);
        Select select1 = new Select(toAccountDropDown);
        select1.selectByIndex(2);
        amountField.sendKeys("10.00");
        submitBtn.click();
    }
    public String getSecondBalance (){
        String secondBalance = secondCardBalance.getText();
        return secondBalance;
    }
    public void transferWithParams(String amountFieldString){
        Select select = new Select(transferFromDropDown);
        select.selectByIndex(1);
        Select select1 = new Select(toAccountDropDown);
        select1.selectByIndex(2);
        amountField.sendKeys(amountFieldString);
        submitBtn.click();
    }
    public String getAmountFieldErrorMessage(){
        String amountFieldErrorMessage = amountField.getAttribute("validationMessage");
        return amountFieldErrorMessage;
    }
    public void transferNegative(String amount){
        Select select = new Select(transferFromDropDown);
        select.selectByIndex(1);
        amountField.sendKeys(amount);
        submitBtn.click();
    }
    public String getToAccountErrorMessage(){
        String toAccountErrorMessage = toAccountDropDown.getAttribute("validationMessage");
        return toAccountErrorMessage;
        }
    }

