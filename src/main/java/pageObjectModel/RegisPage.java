package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;

import static org.openqa.selenium.By.id;

public class RegisPage {
    public static WebDriver webDriver;

    public RegisPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        webDriver = driver;

    }

    @FindBy(className = ("ico-register"))
    public WebElement regLink;


    @FindBy(id = ("gender-female"))
    private WebElement genderFemale;
    @FindBy(id = ("gender-male"))
    private WebElement genderMale;

    @FindBy(id = ("FirstName"))
    private WebElement firstName;

    @FindBy(id = ("LastName"))
    private WebElement lastName;

    @FindBy(name = ("DateOfBirthDay"))
    private WebElement date;

    @FindBy(name = ("DateOfBirthMonth"))
    private WebElement month;

    @FindBy(name = ("DateOfBirthYear"))
    private WebElement year;

    @FindBy(id = ("Email"))
    private WebElement email;

    @FindBy(id = ("Password"))
    private WebElement password;
    @FindBy(id = ("ConfirmPassword"))
    private WebElement confirmPassword;

    @FindBy(id = ("register-button"))
    private WebElement registerButton;
    @FindBy(className = "result")
    private WebElement successMsg;

    @FindBy(xpath = "//span[@id='FirstName-error']")
    public WebElement firstNameError;
    @FindBy(xpath = "//span[@id='LastName-error']")
    public WebElement lastNameError;
    @FindBy(xpath = "//span[@id='Email-error']")
    public WebElement emailError;

    @FindBy(xpath = "//span[@id='ConfirmPassword-error']")
    public WebElement confirmPasswordError;
    @FindBy(xpath = "//li[normalize-space()='The specified email already exists']")
    public WebElement existEmailError;


    @FindBy(id = "company")
    private WebElement company;
    @FindBy(id = "Newsletter")
    private WebElement newsletter;

    public void ClickRegLink() {
        regLink.click();
    }

    public boolean verifyRegPage() {
        return firstName.isDisplayed();
    }

    public void setGender(String gender) {
        if (gender.equalsIgnoreCase("Female")) {
            genderFemale.click();
        } else {
            genderMale.click();
        }
    }

    public void setFirstName(String fname) {
        firstName.sendKeys(fname);

    }

    public void setLastName(String lname) {
        lastName.sendKeys(lname);
    }

    public void setDate(String Date) {
        new Select(date).selectByValue(Date);
    }

    public void setMonth(String Month) {
        new Select(month).selectByValue(Month);

    }

    public void setYear(String Year) {
        new Select(year).selectByValue(Year);
    }

    public void setEmail(String Email) {
        email.sendKeys(Email);
    }

    public void setPassword(String Password) {
        password.sendKeys(Password);
    }

    public void setConfirmPassword(String ConfirmPassword) {
        confirmPassword.sendKeys(ConfirmPassword);
    }

    public boolean verifySuccessReg() {
        return successMsg.isDisplayed();
    }

    public String getSuccessMsg() {
        return successMsg.getText();
    }

    public boolean verifyErrorReg() {
        return firstName.isDisplayed();
    }


    public void ClickRegButton() {
        registerButton.click();
    }

//public void setErrors(WebElement firstNameError, WebElement lastNameError, WebElement emailError, WebElement confirmPasswordError) {
//        this.firstNameError = firstNameError;
//        this.lastNameError = lastNameError;
//        this.emailError = emailError;
//        this.confirmPasswordError = confirmPasswordError;
//    }


    public String getErrors() {
        try {
            if (firstNameError.isDisplayed() || lastNameError.isDisplayed() || emailError.isDisplayed() || confirmPasswordError.isDisplayed()) {
                return "Error";
            } else {
                return "No Error";
            }
        } catch (Exception e) {
            return null;
        }
    }
}





