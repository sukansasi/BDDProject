package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public static WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "ico-login")
    private WebElement loginLink;
    @FindBy(id = "Email")
    private WebElement emailTextBox;
    @FindBy(id = "Password")
    private WebElement passwordTextBox;
    @FindBy(css = ".button-1.login-button")
    private WebElement loginButton;
    @FindBy(className = "message-error")
    private WebElement errorMessage;
@FindBy(className = "ico-logout")
private WebElement logoutLink;

    public void clickLoginLink() {
        loginLink.click();
    }
    public boolean verifyLoginpage() {
        return emailTextBox.isDisplayed();
    }
    public void enterEmail(String email) {
        emailTextBox.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordTextBox.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean verifyErrorMessage() {
        return loginButton.isDisplayed();
    }
    public boolean verifyLoginSuccess() {
        return logoutLink.isDisplayed();
    }
}

