package Step_Definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjectModel.CartPage;
import pageObjectModel.LoginPage;

public class AddToCart {

    public WebDriver Driver = Hooks.Driver;
    CartPage obj1 = new CartPage(Driver);
    LoginPage obj = new LoginPage(Driver);

    @Given("Navigates to login page")
    public void navigatesToLoginPage() {
        obj.clickLoginLink();
    }

    @When("enter the login details {string} , {string}")
    public void enterTheLoginDetails(String arg0, String arg1) {

        obj.enterEmail(arg0);
        obj.enterPassword(arg1);
    }

    @Then("User on the Logged Homepage")
    public void userOnTheLoggedHomepage() throws InterruptedException {
        obj.clickLoginButton();

        Assert.assertTrue(obj.verifyLoginSuccess());
    }

    @Given("Select the Menu from {string} and submenu {string}")
    public void selectTheMenuFromAndSubmenu(String arg0, String arg1) throws InterruptedException {
        Thread.sleep(5000);
obj1.selectMenu(arg0);
Thread.sleep(5000);
obj1.selectSubMenu(arg1);
    }
    @When("Select the item as {string}")
    public void selectTheItemAs(String arg0) throws InterruptedException {
        Thread.sleep(5000);
        obj1.selectItem(arg0);
        Thread.sleep(3000);
    }




    @Then("Add all the items {string} to the cart")
    public void addAllTheItemsToTheCart(String arg0) throws InterruptedException {
        Assert.assertTrue(obj1.verifycartQuantity(arg0));

    }

    @And("Remove all the items")
    public void removeAllTheItems() throws InterruptedException {
        obj1.clickCartLink();
        Thread.sleep(5000);
        obj1.removeAllItems();
    }
}
