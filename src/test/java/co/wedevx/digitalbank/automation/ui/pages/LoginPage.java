package co.wedevx.digitalbank.automation.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BasePageClass{

    public LoginPage(WebDriver driver){
        super(driver);
    }
    @FindBy(id = "username")
    private WebElement usernameTxtBox;

    @FindBy(id = "password")
    private WebElement passwordTxtBox;

    @FindBy(id = "remember-me")
    private WebElement remember_meCheckBox;

    @FindBy(xpath = "//button[contains(text(),'Sign in')]")
    private WebElement submitButton;

    @FindBy(xpath = "//a[contains(text(), 'Sign Up')]")
    private WebElement signUpLink;

    //create action methods
    public void login(String userName, String password){
       // usernameTxtBox.sendKeys(userName);
        passwordTxtBox.sendKeys(password);
        remember_meCheckBox.click();

        submitButton.click();
    }

}
