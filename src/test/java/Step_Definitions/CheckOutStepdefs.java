package Step_Definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjectModel.CartPage;
import pageObjectModel.CheckOutPage;
import pageObjectModel.LoginPage;

public class CheckOutStepdefs {

    public final WebDriver Driver = Hooks.Driver;

    LoginPage loginPage = new LoginPage(Driver);
    CartPage cartPage = new CartPage(Driver);
    CheckOutPage checkOutPage = new CheckOutPage(Driver);
    @Given("Login using {string}, {string} and Add the items to the cart using {string}, {string},{string}")
    public void loginUsingAndAddTheItemsToTheCartUsing(String arg0, String arg1, String arg2, String arg3, String arg4) throws InterruptedException {
loginPage.clickLoginLink();
loginPage.enterEmail(arg0);
loginPage.enterPassword(arg1);
loginPage.clickLoginButton();
cartPage.selectMenu(arg2);
cartPage.selectSubMenu(arg3);
cartPage.selectItem(arg4);
    }

    @When("Select Checkout and Enter the Billing details {string},{string},{string},{string},{string},{string},{string},{string}")
    public void selectCheckoutAndEnterTheBillingDetails(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) throws InterruptedException {
        cartPage.clickCartLink();
        checkOutPage.checkOut();
        Thread.sleep(5000);
        checkOutPage.billingDetails(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
        Thread.sleep(5000);
    }



    @Then("Order placed Successfully")
    public void orderPlacedSuccessfully() {
        Assert.assertTrue(checkOutPage.verifyOrderPlaced());
    }


    @And("Select shipping method {string}, payment method {string} and confirm order")
    public void selectShippingMethodPaymentMethodAndConfirmOrder(String arg0, String arg1) throws InterruptedException {
    checkOutPage.shippingDetails(arg0);
    checkOutPage.paymentDetails(arg1);
    checkOutPage.confirmOrder();
    Thread.sleep(5000);
    }
}
