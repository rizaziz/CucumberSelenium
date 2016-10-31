package config;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseConfiguration {

    public WebDriver driver=null;

    @BeforeSuite
    @Parameters({"driverType", "user", "key"})
    public void setUp(@Optional("local") String driverType, String user, String key) throws Exception {

        if(driverType.equals("remote")){
            driver=getRemoteDriver(user, key);
            return;
        }

        System.setProperty("webdriver.chrome.driver", "/Users/admin/Desktop/CucumberSelenium/Generic/src/main/resources/chromedriver");
        driver=new ChromeDriver();

        driver.get("http://www.paycheckcity.com/");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }


    public WebDriver getRemoteDriver(String user, String key) throws Exception{

        final String USERNAME=user;
        final String ACCESS_KEY=key;
        final String url="http://"+USERNAME+":"+ACCESS_KEY+"@ondemand.saucelabs.com:80/wd/hub";

        DesiredCapabilities cap=DesiredCapabilities.chrome();
        cap.setCapability("platform", "Windows XP");
        cap.setCapability("version", "43.0");
        //cap.setCapability();




        driver=new RemoteWebDriver(new URL(url), cap);

        return driver;
    }


    public WebDriver getFirefoxDriver(){

        FirefoxProfile profile=null;
        FirefoxBinary binary=null;
        Capabilities cap=null;


        driver=new FirefoxDriver();
        return driver;

    }

}
