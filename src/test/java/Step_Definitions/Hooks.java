package Step_Definitions;



import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    public static WebDriver Driver;

    @Before
    public void openBrowser(){
        Driver = new ChromeDriver();
        Driver.get("https://demo.nopcommerce.com");
        Driver.manage().window().maximize();
        System.out.println("--------------------Start-----------------");
    }
    @After
    public void closeBrowser(){
        Driver.quit();
        System.out.println("--------------------End-------------");
    }
}
