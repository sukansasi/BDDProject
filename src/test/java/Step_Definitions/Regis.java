package Step_Definitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjectModel.RegisPage;

import java.util.concurrent.TimeUnit;

public class Regis {

    private final WebDriver driver = Hooks.Driver;
    RegisPage obj = new RegisPage(driver);


    @Given("navigates to Registration page")
    public void navigatesToRegistrationPage() throws InterruptedException {

        obj.ClickRegLink();
        Thread.sleep(3000);
        Assert.assertTrue(obj.verifyRegPage());

    }

    @When("Fill the Registration form with details {string},{string},{string},{string} ,{string},{string},{string},{string} ,{string}")
    public void RegistrationFormDetails(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8) throws InterruptedException {
        obj.setGender(arg0);
        Thread.sleep(5000);
        obj.setFirstName(arg1);
        obj.setLastName(arg2);
        obj.setDate(arg3);
        obj.setMonth(arg4);
        obj.setYear(arg5);
        Thread.sleep(5000);
        obj.setEmail(arg6);
        obj.setPassword(arg7);
        obj.setConfirmPassword(arg8);
    }

    @And("click Register button")
    public void clickRegisterButton() throws InterruptedException {
        Thread.sleep(5000);

        obj.ClickRegButton();
    }
    @Then("Display success message")
    public void displaySuccessMessage() {
        System.out.println("Success message is: "+obj.getSuccessMsg());
        Assert.assertTrue(obj.verifySuccessReg());

    }
    @Then("Display error message")
    public void displayErrorMessage() throws InterruptedException {

        Thread.sleep(5000);
//        obj.getErrors();
        System.out.println("******Error message is: "+obj.getErrors()+"********");

        Assert.assertTrue(obj.verifyErrorReg());
    }
}
