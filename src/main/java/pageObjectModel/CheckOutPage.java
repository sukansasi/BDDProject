package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage {
    public static WebDriver CheckOutdriver;

    public CheckOutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        CheckOutdriver = driver;
    }

    @FindBy(id = "termsofservice")
    private WebElement termsOfService;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(id = "ShipToSameAddress")
    private WebElement shipToSameAddress;
    @FindBy(id = "BillingNewAddress_FirstName")
    private WebElement firstName;

    @FindBy(id = "BillingNewAddress_LastName")
    private WebElement lastName;

    @FindBy(id = "BillingNewAddress_Email")
    private WebElement email;

    @FindBy(id = "BillingNewAddress_CountryId")
    private WebElement country;

    @FindBy(id = "BillingNewAddress_City")
    private WebElement city;

    @FindBy(id = "BillingNewAddress_Address1")
    private WebElement address;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    private WebElement zipCode;
    @FindBy(id = "BillingNewAddress_PhoneNumber")
    private WebElement phoneNumber;
    @FindBy(xpath = "//button[@onclick='if (!window.__cfRLUnblockHandlers) return false; Billing.save()']")
    private WebElement continueButton1;
    @FindBy(id = "shippingoption_0")
    private WebElement shippingOption1;
    @FindBy(id = "shippingoption_1")
    private WebElement shippingOption2;
    @FindBy(id = "shippingoption_2")
    private WebElement shippingOption3;

    @FindBy(xpath = "//button[@onclick='if (!window.__cfRLUnblockHandlers) return false; ShippingMethod.save()']")
    private WebElement continueButton2;
    @FindBy(id = "paymentmethod_0")
    private WebElement paymentMethod1;
    @FindBy(id = "paymentmethod_2")
    private WebElement paymentMethod2;

    @FindBy(xpath = "//button[@onclick='if (!window.__cfRLUnblockHandlers) return false; PaymentMethod.save()']")
    private WebElement continueButton3;

    @FindBy(xpath = "//button[@class='button-1 payment-info-next-step-button']")
    private WebElement continueButton4;
    @FindBy(xpath = "//button[normalize-space()='Confirm']")
    private WebElement confirmButton;
@FindBy(xpath = "//button[@id='delete-billing-address-button']")
private WebElement deleteButton;
    @FindBy(className = "title")
    private WebElement successMessage;
    @FindBy(xpath ="//label[@for='BillingNewAddress_FirstName']")
    private WebElement firstnameLabel;


    public void checkOut() {
        termsOfService.click();
        checkoutButton.click();

    }
    public void enterdetails(String firstName, String lastName, String email, String country, String city, String address, String zipCode, String phoneNumber) throws InterruptedException {
        this.firstName.clear();
        this.firstName.sendKeys(firstName);
        Thread.sleep(2000);
        this.lastName.clear();
        this.lastName.sendKeys(lastName);
        Thread.sleep(2000);
        this.email.clear();
        this.email.sendKeys(email);
        Thread.sleep(2000);
        new Select(this.country).selectByVisibleText(country);
        this.city.clear();
        this.city.sendKeys(city);
        this.address.clear();
        this.address.sendKeys(address);
        this.zipCode.clear();
        this.zipCode.sendKeys(zipCode);
        this.phoneNumber.clear();
        this.phoneNumber.sendKeys(phoneNumber);
    }

    public void billingDetails(String firstName, String lastName, String email, String country, String city, String address, String zipCode, String phoneNumber) throws InterruptedException {
        Thread.sleep(5000);
        if(firstnameLabel.isDisplayed()){
            if(!(shipToSameAddress.isSelected()) && (shipToSameAddress.isDisplayed())){
                shipToSameAddress.click();
                Thread.sleep(5000);
            }
        enterdetails(firstName, lastName, email, country, city, address, zipCode, phoneNumber);

            continueButton1.click();
            Thread.sleep(5000);

        }else{
            this.deleteButton.click();
            Thread.sleep(5000);

            enterdetails(firstName, lastName, email, country, city, address, zipCode, phoneNumber);
            continueButton1.click();
            Thread.sleep(5000);
        }
        //
//        Thread.sleep(5000);
        //shipToSameAddress.click();

    }

    public void shippingDetails(String shippingMethod) throws InterruptedException {
        if (shippingMethod.equals("Ground Shipping")) {
            shippingOption1.click();
        } else if (shippingMethod.equals("Next Day Air")) {
            shippingOption2.click();
        } else if (shippingMethod.equals("Overnight")) {
            shippingOption3.click();
        }
        continueButton2.click();
        Thread.sleep(3000);

    }

    public void paymentDetails(String paymentMethod) throws InterruptedException {
        if (paymentMethod.equals("Check")) {
            paymentMethod1.click();
        } else if (paymentMethod.equals("Credit Card")) {
            paymentMethod2.click();
        }
        continueButton3.click();
        Thread.sleep(3000);
    }

    public void confirmOrder() throws InterruptedException {
        continueButton4.click();
        Thread.sleep(3000);
        confirmButton.click();
        Thread.sleep(3000);
    }
    public boolean verifyOrderPlaced() {
        return successMessage.isDisplayed();
    }
}
