package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    public static WebDriver homePageDriver;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        homePageDriver = driver;
    }

    @FindBy(className = "ico-logout")
    private WebElement logoutLink;
    @FindBy(linkText = "Computers")
    private WebElement computerLink;
    @FindBy(linkText = "Electronics")
    private WebElement electronicsLink;
    @FindBy(linkText = "Apparel")
    private WebElement apparelLink;

    @FindBy(linkText = "Digital downloads")
    private WebElement digitalDownloadsLink;

    @FindBy(linkText = "Books")
    private WebElement booksLink;

    @FindBy(linkText = "Jewelry")
    private WebElement jewelleryLink;
    @FindBy(linkText = "Gift Cards")
    private WebElement giftCardsLink;
    @FindBy(linkText = "Desktops")
    private WebElement desktopLink;
    @FindBy(linkText = "Notebooks")
    private WebElement notebookLink;
    @FindBy(linkText = "Software")
    private WebElement softwareLink;
    @FindBy(xpath = "//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//button[1]")
    private WebElement addToCartButtonAppleMacbook;
    @FindBy(xpath = "//div[@class='master-wrapper-page']//div[6]//div[1]//div[2]//div[3]//div[2]//button[1]")
    private WebElement addToCartSamsungSeries9;
    @FindBy(xpath = "//div[@class='center-2']//div[3]//div[1]//div[2]//div[3]//div[2]//button[1]")
    private WebElement addToCartHPEnvy;
    @FindBy(xpath = "//div[5]//div[1]//div[2]//div[3]//div[2]//button[1]")
    private WebElement addToCartLenovoThinkpad;

    @FindBy(xpath = "//div[4]//div[1]//div[2]//div[3]//div[2]//button[1]")
    private WebElement addToCartHpSpecture;

    @FindBy(xpath = "//div[@class='products-wrapper']//div[2]//div[1]//div[2]//div[3]//div[2]//button[1]")
    private WebElement addToCartAsus;
    @FindBy(className = "cart-qty")
    private WebElement cartQuantity;

    @FindBy(xpath = "//span[@class='cart-label']")
    private WebElement cartLink;

    @FindBy(xpath = "//tbody/tr[1]/td[7]/button[1]")
    private WebElement removeButton;

    public void clickLogoutLink() {
        logoutLink.click();
    }

    public void selectMenu(String Menu) {
        if (Menu.equalsIgnoreCase("Computers")) {
            computerLink.click();
        } else if (Menu.equalsIgnoreCase("Electronics")) {
            electronicsLink.click();
        } else if (Menu.equalsIgnoreCase("Apparel")) {
            apparelLink.click();
        } else if (Menu.equalsIgnoreCase("Digital downloads")) {
            digitalDownloadsLink.click();
        } else if (Menu.equalsIgnoreCase("Books")) {
            booksLink.click();
        } else if (Menu.equalsIgnoreCase("Jewelry")) {
            jewelleryLink.click();
        } else if (Menu.equalsIgnoreCase("Gift Cards")) {
            giftCardsLink.click();
        }
    }

    public void selectSubMenu(String SubMenu) {
        if (SubMenu.equalsIgnoreCase("Desktops")) {
            desktopLink.click();
        } else if (SubMenu.equalsIgnoreCase("Notebooks")) {
            notebookLink.click();
        } else if (SubMenu.equalsIgnoreCase("Software")) {
            softwareLink.click();
        }
    }

    public void selectItem(String items) throws InterruptedException {
        String[] itemsList = items.split(",");
        System.out.println(itemsList.length);
        for(String item : itemsList){
            System.out.println(item);
        }
        for (String item : itemsList) {
            switch (item.trim()){
                case "Apple Macbook":
                    addToCartButtonAppleMacbook.click();
                    break;
                case "Samsung Series 9":
                    addToCartSamsungSeries9.click();
                    break;
                case "HP Envy":
                    addToCartHPEnvy.click();
                    break;
                case "Lenovo Thinkpad":
                    addToCartLenovoThinkpad.click();
                    break;
                case "HP Specture":
                    addToCartHpSpecture.click();
                    break;
                case "Asus":
                    addToCartAsus.click();
                    break;
                default:
                    System.out.println("Item not found");
                    break;
            }
Thread.sleep(5000);
        }
    }

    public boolean verifycartQuantity(String items) {
            String[] itemsList = items.split(",");

            int actualQuantity = Integer.parseInt(cartQuantity.getText().replaceAll("[^0-9]", ""));
        System.out.println("actualQuantity = " + actualQuantity);
            int expectedQuantity = itemsList.length;
        System.out.println("expectedQuantity = " + expectedQuantity);
            if (actualQuantity == expectedQuantity) {
                return true;
            } else {
                return false;
            }

    }

    public void clickCartLink(){
        cartLink.click();
    }

    public void removeAllItems() throws InterruptedException {
        int ActualQuantity = Integer.parseInt(cartQuantity.getText().replaceAll("[^0-9]", ""));
        for(int i=ActualQuantity;i>=1;i--){
            removeButton.click();
            Thread.sleep(3000);
        }

    }
}