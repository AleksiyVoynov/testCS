package Driver;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.util.*;


public class MyDriver implements WebDriver{

    private WebDriver driver;
    private static MyDriver myDriver = null;


    public MyDriver() {
        this.driver = MyDriverFactory.getDriver();
    }
    public static MyDriver getDriver(){
        if(myDriver==null){
            return new MyDriver();
        }
        return myDriver;
    }


    public void get(String url) {
        driver.get(url);
    }


    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }


    public String getTitle() {
        return getTitle();
    }


    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }


    public WebElement findElement(By by) {
        return driver.findElement(by);
    }


    public String getPageSource() {
        return driver.getPageSource();
    }

    public void close() {
        driver.close();
    }


    public void quit() {
        driver.quit();
    }


    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }


    public String getWindowHandle() {
        return driver.getWindowHandle();
    }


    public WebDriver.TargetLocator switchTo() {
        return driver.switchTo();
    }

    public WebDriver.Navigation navigate() {
        return driver.navigate();
    }

    public WebDriver.Options manage() {
        return driver.manage();
    }

    public WebElement WaitElementToBeClickable(By by, int timeout) {
        return new WebDriverWait(driver, timeout, 100)
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    public WebElement WaitElementToBeClickable(WebElement webelement, int timeout) {
        return new WebDriverWait(driver, timeout, 100)
                .until(ExpectedConditions.elementToBeClickable(webelement));
    }

    public WebElement WaitElementToBeVisibilityOf(WebElement webelement, int timeout) {
        return new WebDriverWait(driver, timeout, 100)
                .until(ExpectedConditions.visibilityOf(webelement));
    }

    public WebElement  WaitElementToBeVisibilityOf(By by, int timeout) {
        return new WebDriverWait(driver, timeout, 100)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

}
