package junit;


import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageobj.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.NumberFormat;

import static cucumber.stepdef.StepDefinitions.clearAndFill;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestingWithJUnit {

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

        cap=new DesiredCapabilities();
        cap.setPlatform(Platform.MAC);
        cap.setBrowserName("firefox");

        url="http://localhost:7777/wd/hub";

        try{
            driver=new RemoteWebDriver(new URL(url), cap);
        }catch(MalformedURLException e){ e.printStackTrace();}

        //eventDriver=new EventFiringWebDriver(driver);

        main=new MainPageObject(driver);
        input= new DataInputPage(driver);
        result=new ResultPage(driver);

        nf=NumberFormat.getCurrencyInstance();

        driver.get("http://www.paycheckcity.com");

        WebDriverWait wait=new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(main.btn_SalaryCalculator));

        driver.manage().window().maximize();

    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    @Before
    public void clickOnSalaryCalcButton(){
        main.btn_SalaryCalculator.click();
    }

    @After
    public void clickOnNewCalculationButton(){
        result.newCalc.click();

    }

    @Test
    public void date_are_filled_with_following_table() throws Throwable {
        clearAndFill(input.date, "10/01/2016");
    }

    @Test
    public void state_are_filled_with_following_table() throws Throwable {
        clearAndFill(input.state, "Texas");
    }

    @Test
    public void gross_are_filled_with_following_table() throws Throwable {
        clearAndFill(input.gross, "100000");
    }

    @Test
    public void type_are_filled_with_following_table() throws Throwable {
        clearAndFill(input.type, "Annually");
    }

    @Test
    public void frequency_are_filled_with_following_table() throws Throwable {
        clearAndFill(input.frequency, "Bi-weekly");
    }

    @Test
    public void status_are_filled_with_following_table() throws Throwable {
        clearAndFill(input.status, "Married");
    }

    @Test
    public void allowances_are_filled_with_following_table() throws Throwable {
        clearAndFill(input.allowances, "4");
    }

    @Test
    public void click_button_Calculate() throws Throwable {
        File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //org.apache.commons.io.FileUtils.copyFile(file, new File("/Users/admin/Desktop/input.png"));
        input.btnCalc.click();
    }

    @Test
    public void wait_untill_the_result_page_loads() throws Throwable {
        WebDriverWait wait=new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(result.newCalc));
    }

    @Test
    public void gross_salary_should_be_as_follows() throws Throwable {
        Assert.assertEquals(nf.parse(result.gross.getText()).doubleValue(), 3846.15, 1);
    }

    @Test
    public void federal_tax_should_be_as_follows() throws Throwable {
        Assert.assertEquals(nf.parse(result.federal.getText()).doubleValue(), 398.46, 1);
    }

    @Test
    public void ssn_tax_should_be_as_follows() throws Throwable {
        Assert.assertEquals(nf.parse(result.ssn.getText()).doubleValue(), 238.46, 1);
    }

    @Test
    public void medicare_tax_should_be_as_follows() throws Throwable {
        Assert.assertEquals(nf.parse(result.medicare.getText()).doubleValue(), 55.76, 1);
    }

    @Test
    public void state_tax_should_be_as_follows() throws Throwable {
        Assert.assertEquals(nf.parse(result.state.getText()).doubleValue(), 118.08, 1);
    }


}
