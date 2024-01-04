package co.wedevx.digitalbank.automation.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BaseMenuPage extends BasePageClass {
    public BaseMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "checking-menu")
    protected WebElement checkingMenuBtn;
    @FindBy(id = "new-checking-menu-item")
    protected WebElement newCheckingBtn;
    @FindBy(id = "view-checking-menu-item")
    protected WebElement viewCheckingBtn;
    @FindBy(id = "home-menu-item")
    protected WebElement homeBtn;
    @FindBy(id = "transfer-menu-item")
    private WebElement transferBtn;
    @FindBy(xpath = "//div/table")
    private WebElement transactionHistoryTable;

    public void goToHomePage() {
        homeBtn.click();
    }

    public void newChecking() {
        checkingMenuBtn.click();
        newCheckingBtn.click();
    }

    public void transfer() {
        transferBtn.click();
    }
    public String transactionHistory(){
        String transactionDescription = transactionHistoryTable.findElement(By.xpath("//tr[2]/td[3]")).getText();
        return transactionDescription;
    }
}
