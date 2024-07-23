package Step_Definitions;
import io.cucumber.java.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjectModel.LoginPage;

public class Login {

    public static WebDriver Driver = Hooks.Driver;

    LoginPage login = new LoginPage(Driver);
    @Given("navigates to Login page")
    public void navigatesToLoginPage() {
        login.clickLoginLink();
        Assert.assertTrue(login.verifyLoginpage());

    }

    @When("I enter {string} as username and  {string} as password")
    public void iEnterAsUsernameAndAsPassword(String arg0, String arg1) {
        login.enterEmail(arg0);
        login.enterPassword(arg1);
    }

    @And("click Login button")
    public void clickLoginButton() {
        login.clickLoginButton();
    }

    @Then("navigates to Logged page")
    public void navigatesToLoggedPage() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue(login.verifyLoginSuccess());
    }

    @Then("display error message")
    public void displayErrorMessage() throws InterruptedException {

Assert.assertTrue(login.verifyErrorMessage());
Thread.sleep(5000);
    }
}
