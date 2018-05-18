package Pages;

import Driver.MyDriver;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePage {
    static protected String BaseURL = "https://csltd.com.ua/";
    static protected MyDriver driver = MyDriver.getDriver();

    public BasePage() {
        PageFactory.initElements(driver,this);
    }
}
