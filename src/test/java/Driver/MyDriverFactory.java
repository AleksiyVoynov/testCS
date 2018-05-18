package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;


public class MyDriverFactory {

    static  WebDriver driver = null;

    public static WebDriver getDriver(){
        WebDriver driver;
        final String driverName = System.getProperty("driver");

        if("firefox".equals(driverName)) {
            System.setProperty("webdriver.gecko.driver", "lib//geckodriver.exe");
            driver = new FirefoxDriver();
        } else if ("chrome".equals(driverName)) {
            System.setProperty("webdriver.chrome.driver", "lib//chromedriver.exe");
            driver = new ChromeDriver();
        } else if ("iedriver".equals(driverName)) {
            System.setProperty("webdriver.ie.driver", "lib//IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        } else {
            System.setProperty("webdriver.gecko.driver", "lib//geckodriver.exe");
            driver = new FirefoxDriver();
        }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            return driver;
    }

}
