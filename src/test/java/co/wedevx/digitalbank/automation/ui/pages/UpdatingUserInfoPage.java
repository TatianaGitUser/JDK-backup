package co.wedevx.digitalbank.automation.ui.pages;

import co.wedevx.digitalbank.automation.ui.utilities.Driver;
import co.wedevx.digitalbank.automation.ui.utilities.MockData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

import static co.wedevx.digitalbank.automation.ui.utilities.Driver.getDriver;

public class UpdatingUserInfoPage extends BasePageClass{

    public UpdatingUserInfoPage(WebDriver driver){
     super(driver);
    }
    @FindBy(xpath = "//img[@class='user-avatar rounded-circle']")
    private WebElement profilePageBtn;
    @FindBy(xpath = "//a[@href='/bank/user/profile']")
    private WebElement myProfileBtn;
    public void updateProfile(){
        LoginPage loginPage = new LoginPage(getDriver());
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        MockData mockData = new MockData();
        Map<String, String> mockDataMap = mockData.generateRandomNameAndEmail();
        Map<String, String> mockPasswords = mockData.generateRandomPasswordAndConfirm();

        registrationPage.registerNewUser();
        //loginPage.login(mockDataMap.get("email"), mockPasswords.get("password"));
        profilePageBtn.click();
        myProfileBtn.click();
        registrationPage.UpdateUserInfo();
    }

}
