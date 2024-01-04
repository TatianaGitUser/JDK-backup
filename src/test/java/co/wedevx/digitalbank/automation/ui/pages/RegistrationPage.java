package co.wedevx.digitalbank.automation.ui.pages;

import co.wedevx.digitalbank.automation.ui.utilities.MockData;
import io.cucumber.java.it.Ma;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

import static co.wedevx.digitalbank.automation.ui.utilities.Driver.getDriver;

public class RegistrationPage extends BasePageClass{

public RegistrationPage (WebDriver driver){
    super(driver);
}
    @FindBy(xpath = "//a[@href='/bank/signup']")
    private WebElement signUpBtn;
    @FindBy(id = "title")
    private WebElement titleSelect;
    @FindBy(id = "firstName")
    private WebElement firstNameField;
    @FindBy(id = "lastName")
    private WebElement lastNameField;
    @FindBy(xpath = "//div[@class='form-check-inline form-check']")
    private WebElement genderRadioBtn;
    @FindBy(id = "dob")
    private WebElement dobField;
    @FindBy(id = "ssn")
    private WebElement ssnField;
    @FindBy(id = "emailAddress")
    private WebElement emailField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "confirmPassword")
    private WebElement confirmPasswordField;
    @FindBy(xpath = "//button[@class='btn btn-primary btn-flat m-b-30 m-t-30']")
    private WebElement nextBtn;
    @FindBy(id = "address")
    private WebElement addressField;
    @FindBy(id = "locality")
    private WebElement localityField;
    @FindBy(id = "region")
    private WebElement regionField;
    @FindBy(id = "postalCode")
    private WebElement postalCodeField;
    @FindBy(id = "country")
    private WebElement countryField;
    @FindBy(id = "homePhone")
    private WebElement homePhoneField;
    @FindBy(id = "agree-terms")
    private WebElement TAndCCheckBox;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement registerBtn;
    @FindBy(xpath = "//button[contains(text(),'Sign in')]")
    private WebElement signInBtn;
    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm']")
    private WebElement submitBtn;
    @FindBy(xpath = "//div[@class='sufee-alert alert with-close alert-success alert-dismissible fade show']")
    private WebElement successMessage;

    public void registerNewUser() {
        LoginPage loginPage = new LoginPage(getDriver());

        MockData mockData = new MockData();
        Map<String, String> mockDataMap = mockData.generateRandomNameAndEmail();
        Map<String, String> mockPasswords = mockData.generateRandomPasswordAndConfirm();
        signUpBtn.click();
        Select select = new Select(titleSelect);
        select.selectByValue(mockData.generateRandomTitle());

        firstNameField.sendKeys(mockDataMap.get("name"));
        lastNameField.sendKeys(mockData.generateRandomLastName());
        String  gender = mockData.generateRandomGender();
        if (gender.equalsIgnoreCase("F")) {
            genderRadioBtn.findElement(By.xpath("//input[@value='F']")).click();
        } else if (gender.equalsIgnoreCase("M")) {
            genderRadioBtn.findElement(By.xpath("//input[@value='M']")).click();
        }else{
            System.out.println(gender);
        }

        dobField.sendKeys(mockData.generateRandomDOB());
        ssnField.sendKeys(mockData.generateRandomSSN());
        emailField.sendKeys(mockDataMap.get("email"));

        passwordField.sendKeys(mockPasswords.get("password"));
        confirmPasswordField.sendKeys(mockPasswords.get("confirmation"));
        nextBtn.click();
        addressField.sendKeys(mockData.generateRandomStreetAddress());
        localityField.sendKeys(mockData.generateRandomCity());
        regionField.sendKeys(mockData.generateRandomState());
        postalCodeField.sendKeys(mockData.generateRandomZipCode());
        countryField.sendKeys(mockData.generateRandomCountryCode());
        homePhoneField.sendKeys(mockData.generateRandomCellPhone());
        TAndCCheckBox.click();
        registerBtn.click();

        String userName = mockDataMap.get("email");
        String password = mockPasswords.get("password");
        //loginPage.login(userName, password);

    }

    public void UpdateUserInfo() {
        MockData mockData = new MockData();
        Select select = new Select(titleSelect);
        select.selectByValue(mockData.generateRandomTitle());
        Map<String, String> mockDataMap = mockData.generateRandomNameAndEmail();
        Map<String, String> mockPasswords = mockData.generateRandomPasswordAndConfirm();
        firstNameField.sendKeys(mockDataMap.get("name"));
        lastNameField.sendKeys(mockData.generateRandomLastName());
        homePhoneField.sendKeys(mockData.generateRandomCellPhone());
        addressField.sendKeys(mockData.generateRandomStreetAddress());
        localityField.sendKeys(mockData.generateRandomState());
        regionField.sendKeys(mockData.generateRandomState());
        postalCodeField.sendKeys(mockData.generateRandomZipCode());
        countryField.sendKeys(mockData.generateRandomCountryCode());
        submitBtn.click();
    }
public void registerNewUserWithDataTable(List<Map<String,String>> registrationPageTestDataListOfMaps) {
    Map<String, String> firstRow = registrationPageTestDataListOfMaps.get(0);
    MockData mockData = new MockData();
    Map<String, String> mockDataMap = mockData.generateRandomNameAndEmail();
    Select select = new Select(titleSelect);
    if (firstRow.get("title") != null) {
        select.selectByVisibleText(firstRow.get("title"));
    }
    if (firstRow.get("firstName") != null) {
        firstNameField.sendKeys(firstRow.get("firstName"));
    }
    if (firstRow.get("lastName") != null) {
        lastNameField.sendKeys(firstRow.get("lastName"));
    }
    if (firstRow.get("gender") != null) {
        if (firstRow.get("gender").equalsIgnoreCase("F")) {
            genderRadioBtn.findElement(By.xpath("//input[@value='F']")).click();
        } else if (firstRow.get("gender").equalsIgnoreCase("M")) {
            genderRadioBtn.findElement(By.xpath("//input[@value='M']")).click();
        }
    }
    if (firstRow.get("dob") != null) {
        dobField.sendKeys(firstRow.get("dob"));
    }
    if (firstRow.get("ssn") != null) {
        ssnField.sendKeys(firstRow.get("ssn"));
//        if (firstRow.get("ssn").equalsIgnoreCase("random")) {
//            ssnField.sendKeys(mockData.generateRandomSSN());
//        }
    }
    if (firstRow.get("email") != null) {
        emailField.sendKeys(firstRow.get("email"));
//        if (firstRow.get("email").equalsIgnoreCase("random")) {
//            emailField.sendKeys(mockDataMap.get("email"));

//    }
    }
    if (firstRow.get("password") != null) {
        passwordField.sendKeys(firstRow.get("password"));
        confirmPasswordField.sendKeys(firstRow.get("password"));
    }
    nextBtn.click();
    if (addressField.isDisplayed()) {
        if (firstRow.get("address") != null) {
            addressField.sendKeys(firstRow.get("address"));
        }
        if (firstRow.get("locality") != null) {
            localityField.sendKeys(firstRow.get("locality"));
        }
        if (firstRow.get("region") != null) {
            regionField.sendKeys(firstRow.get("region"));
        }
        if (firstRow.get("postalCode") != null) {
            postalCodeField.sendKeys(firstRow.get("postalCode"));
        }
        if (firstRow.get("country") != null) {
            countryField.sendKeys(firstRow.get("country"));
        }
        if (firstRow.get("homePhone") != null) {
            homePhoneField.sendKeys(firstRow.get("homePhone"));
        }
        if (firstRow.get("termsCheckMark") != null) {
            if (firstRow.get("termsCheckMark").equalsIgnoreCase("true")) {
                TAndCCheckBox.click();
            }
        }
        registerBtn.click();

        LoginPage loginPage = new LoginPage(getDriver());
        String userName = "";
        //loginPage.login(userName, firstRow.get("password"));
    }
}
public String getMessage(){
        return successMessage.getText().substring(0, successMessage.getText().lastIndexOf("."));
}
public String getRequiredFieldErrorMessage(String fieldName){
        switch (fieldName.toLowerCase()){
            case "title":
                return titleSelect.getAttribute("validationMessage");
            case "firstname":
                return firstNameField.getAttribute("validationMessage");
            case "lastname":
                return lastNameField.getAttribute("validationMessage");
            case "gender":
                return genderRadioBtn.findElement(By.xpath("//input[@value='F']")).getAttribute("validationMessage");
            case "dob":
                return dobField.getAttribute("validationMessage");
            case "ssn":
                return ssnField.getAttribute("validationMessage");
            case "email":
                return emailField.getAttribute("validationMessage");
            case "password":
                return passwordField.getAttribute("validationMessage");
            case "address":
                return addressField.getAttribute("validationMessage");
            case "locality":
                return localityField.getAttribute("validationMessage");
            case "region":
                return regionField.getAttribute("validationMessage");
            case "postalcode":
                return postalCodeField.getAttribute("validationMessage");
            case "country":
                return countryField.getAttribute("validationMessage");
            case "homephone":
                return homePhoneField.getAttribute("validationMessage");
            case "termscheckmark":
                return TAndCCheckBox.getAttribute("validationMessage");
            default:
                return null;
        }
}
}


