package smoke;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pageobj.DataInputPage;
import pageobj.MainPageObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;



/**
 * Created by admin on 10/4/16.
 */
public class SimpleTest {

    WebDriver driver=null;
    MainPageObject mpo=null;
    DataInputPage dip=null;
    DesiredCapabilities cap=null;
    String url=null;
    SimpleEventListener eventListener=null;
    EventFiringWebDriver eventFiringDriver;


    @BeforeClass
    public void setUp(){



        /*url="http://localhost:4444/wd/hub";
        cap=new DesiredCapabilities();
        cap.setBrowserName("chrome");
        cap.setPlatform(Platform.MAC);

        try{
            driver=new RemoteWebDriver(new URL(url), cap);
        }catch(MalformedURLException e){}*/

        System.setProperty("webdriver.chrome.driver", "/Programs/selenium/drivers/chromedriver");
        driver=new ChromeDriver();

        mpo=new MainPageObject(driver);
        dip=new DataInputPage(driver);

        eventFiringDriver=new EventFiringWebDriver(driver);
        eventListener=new SimpleEventListener();

        eventFiringDriver.register(eventListener);

        System.out.println("before navigating to url");

        eventFiringDriver.get("http://paycheckcity.com");

        WebDriverWait wait=new WebDriverWait(eventFiringDriver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(mpo.btn_SalaryCalculator));

        mpo.btn_SalaryCalculator.click();

        WebDriverWait wait1=new WebDriverWait(eventFiringDriver, 20);
        wait1.until(ExpectedConditions.elementToBeClickable(dip.btnCalc));


    }

    @AfterClass
    public void tearDown(){
       eventFiringDriver.quit();
    }

    @Test
    public void test(){

        dip.state.clear();
        dip.state.sendKeys("Texas");

        JavascriptExecutor exec=(JavascriptExecutor)eventFiringDriver;
        exec.executeScript("alert('SW Test Academy')");
        eventFiringDriver.switchTo().alert().accept();

        String currentWindowID=eventFiringDriver.getWindowHandle();



        WebElement elem=eventFiringDriver.findElement(By.xpath(".//*[@id='widget_state']/div[1]/input"));
        elem.click();

        eventFiringDriver.switchTo().window(currentWindowID);
    }
}
