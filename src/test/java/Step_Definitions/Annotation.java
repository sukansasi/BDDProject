package Step_Definitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Annotation {
    WebDriver driver = new ChromeDriver();
//WebDriver  driver = new ChromeDriver();
    @Given("^I am on Facebook login page$")

    public void goToFacebook() throws InterruptedException {
//      WebDriver  driver = new ChromeDriver();
        driver.navigate().to("https://www.facebook.com/");
        Thread.sleep(5000);
    }

    @When("^I enter username as \"(.*)\"$")
    public void enterUsername(String arg1) {
        driver.findElement(By.id("email")).sendKeys(arg1);
    }

    @When ("^I enter password as \"(.*)\"$")
    public void enterPassword(String arg1) throws InterruptedException {
        driver.findElement(By.id("pass")).sendKeys(arg1);
        driver.findElement(By.name("login")).click();
        Thread.sleep(20000);
    }
//._8esj._95k9._8esf._8opv._8f3m._8ilg._8icx._8op_._95ka
    @Then("^Login should fail$")
    public void checkFail() {
        System.out.println(driver.getCurrentUrl());
        if(driver.getCurrentUrl().equalsIgnoreCase(
                "https://www.facebook.com/login/?privacy_mutation_token=eyJ0eXBlIjowLCJjcmVhdGlvbl90aW1lIjoxNzE3NDk3NTQzLCJjYWxsc2l0ZV9pZCI6MzgxMjI5MDc5NTc1OTQ2fQ%3D%3D")){
            System.out.println("Test1 Pass");
        } else {
            System.out.println("Test1 Failed");
        }

    }

    @Then("^Relogin option should be available$")
    public void checkRelogin() {
        System.out.println(driver.getCurrentUrl());

        if(driver.getCurrentUrl().equalsIgnoreCase("https://www.facebook.com/")){
            System.out.println("Test2 Pass");
        } else {
            System.out.println("Test2 Failed");
        }
        driver.quit();
    }
}

