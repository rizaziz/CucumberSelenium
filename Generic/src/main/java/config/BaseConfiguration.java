package config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class BaseConfiguration {

    public WebDriver driver=null;

    @BeforeSuite
    public void setUp(){

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

}
