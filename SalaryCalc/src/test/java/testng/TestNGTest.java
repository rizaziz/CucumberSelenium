package testng;

import listeners.SeleniumListeners;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobj.DataInputPage;
import pageobj.MainPageObject;
import pageobj.ResultPage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.concurrent.TimeUnit;

import static cucumber.stepdef.StepDefinitions.clearAndFill;


public class TestNGTest {

    static WebDriver driver=null;
    static EventFiringWebDriver eventDriver=null;
    static DesiredCapabilities cap=null;
    static String url=null;

    static MainPageObject main=null;
    static DataInputPage input=null;
    static ResultPage result=null;

    static NumberFormat nf=null;

    @BeforeClass
    public static void setUp(){

        /*cap=new DesiredCapabilities();
        cap.setPlatform(Platform.MAC);
        cap.setBrowserName("chrome");

        url="http://localhost:4444/wd/hub";

        try{
            driver=new RemoteWebDriver(new URL(url), cap);
        }catch(MalformedURLException e){ e.printStackTrace();}*/

        //System.setProperty("webdriver.gecko.driver", "/Programs/selenium/drivers/geckodriver");
        System.setProperty("webdriver.chrome.driver", "/Programs/selenium/drivers/chromedriver");
        //driver=new FirefoxDriver();
        driver=new ChromeDriver();

        //driver=getFirefoxDriver();



        eventDriver=new EventFiringWebDriver(driver);

        //eventDriver.register(new SeleniumListeners());

        main=new MainPageObject(eventDriver);
        input= new DataInputPage(eventDriver);
        result=new ResultPage(eventDriver);

        nf=NumberFormat.getCurrencyInstance();

        eventDriver.get("http://www.paycheckcity.com");

        WebDriverWait wait=new WebDriverWait(eventDriver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(main.btn_SalaryCalculator));

        eventDriver.manage().window().maximize();
        main.btn_SalaryCalculator.click();



    }

    @AfterClass(alwaysRun=true)
    public static void tearDown(){
        eventDriver.quit();
    }

    @BeforeMethod
    public void clickOnSalaryCalcButton(){

    }

    @Test(description = "clear and fill date field")
    public void fillDate() throws Throwable {
        clearAndFill(input.date, "10/01/2016");
    }

    @Test(description="clear and fill state field", dependsOnMethods = {"fillDate"})
    public void fillState() throws Throwable {
        clearAndFill(input.state, "Texas");
    }

    @Test(description="clear and fill gross field", dependsOnMethods = {"fillState"})
    public void fillGross() throws Throwable {
        clearAndFill(input.gross, "100000");
    }

    @Test(description = "clear and fill salary type", dependsOnMethods = {"fillGross"})
    public void fillType() throws Throwable {
        clearAndFill(input.type, "Annually");
    }

    @Test(description="clear and fill frequency type", dependsOnMethods = {"fillType"})
    public void fillFrequency() throws Throwable {
        clearAndFill(input.frequency, "Bi-weekly");
    }

    @Test(description = "clear and fill status field", dependsOnMethods = {"fillFrequency"})
    public void fillStatus() throws Throwable {
        clearAndFill(input.status, "Married");
    }

    @Test(description = "clearn and fill number of allowances", dependsOnMethods = {"fillStatus"})
    public void fillAllowances() throws Throwable {
        clearAndFill(input.allowances, "4");
    }

    @Test(dependsOnMethods = {"fillAllowances"})
    public void click_button_Calculate() throws Throwable {
        //File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //org.apache.commons.io.FileUtils.copyFile(file, new File("/Users/admin/Desktop/input.png"));
        input.btnCalc.click();
    }

    @Test(dependsOnMethods = {"click_button_Calculate"})
    public void wait_untill_the_result_page_loads() throws Throwable {
        WebDriverWait wait=new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(result.newCalc));
    }

    @Test(dependsOnMethods = {"wait_untill_the_result_page_loads"})
    public void gross_salary_should_be_as_follows() throws Throwable {
        Assert.assertEquals(nf.parse(result.gross.getText()).doubleValue(), 3846.15, 1);
    }

    @Test(dependsOnMethods = {"wait_untill_the_result_page_loads"})
    public void federal_tax_should_be_as_follows() throws Throwable {
        Assert.assertEquals(nf.parse(result.federal.getText()).doubleValue(), 398.46, 1);
    }

    @Test(dependsOnMethods = {"wait_untill_the_result_page_loads"})
    public void ssn_tax_should_be_as_follows() throws Throwable {
        Assert.assertEquals(nf.parse(result.ssn.getText()).doubleValue(), 238.46, 1);
    }

    @Test(dependsOnMethods = {"wait_untill_the_result_page_loads"})
    public void medicare_tax_should_be_as_follows() throws Throwable {
        Assert.assertEquals(nf.parse(result.medicare.getText()).doubleValue(), 55.76, 1);
    }

    @Test(dependsOnMethods = {"wait_untill_the_result_page_loads"})
    public void state_tax_should_be_as_follows() throws Throwable {
        Assert.assertEquals(nf.parse(result.state.getText()).doubleValue(), 0.0, 1);
    }

    public static WebDriver getFirefoxDriver(){

        FirefoxDriver driver=null;
        System.setProperty("webdriver.firefox.bin", "/Programs/firefox/Firefox-47.0.1.app/Contents/MacOS/firefox-bin");
        //System.setProperty("webdriver.firefox.useExisting", "true");
        //String path="/Programs/firefox/Firefox-47.0.1.app/Contents/MacOS/firefox-bin";

        FirefoxBinary binary=new FirefoxBinary();

        File firebug=new File("/Programs/firefox/firebug-2.0.18-fx.xpi");
        File videoDownloader=new File("/Programs/firefox/video_downloadhelper-6.1.1-fx.xpi");

        FirefoxProfile profile=new FirefoxProfile();




        try{
            profile.addExtension(firebug);
            profile.setPreference("extensions.firebug.currentVersion", "2.0.18");
            profile.addExtension(videoDownloader);

        }catch(IOException e){
            e.printStackTrace();
        }


        DesiredCapabilities desired=new DesiredCapabilities();
        desired.setBrowserName(BrowserType.FIREFOX);
        desired.setPlatform(Platform.EL_CAPITAN);
        desired.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);


        driver=new FirefoxDriver(binary, profile);


        return driver;
    }

    public static WebDriver getAndroidDriver() throws Exception{

        RemoteWebDriver driver=null;
        DesiredCapabilities cap=DesiredCapabilities.android();
        cap.setCapability("device", "android");
        cap.setCapability("version", "6.0");
        cap.setCapability("app", "/Users/admin/Desktop/MobileTestAutomation/Android/src/app/converter.apk");

        String url="http://localhost:4723/wd/hub";

        driver=new RemoteWebDriver(new URL(url), cap);
        return driver;


    }

    /*public static void main(String... args) throws Exception{

        WebDriver driver=getAndroidDriver();

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        //driver.quit();





    }*/

}
