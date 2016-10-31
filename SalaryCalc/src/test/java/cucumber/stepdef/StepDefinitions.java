package cucumber.stepdef;


import com.sun.jna.platform.FileUtils;
import cucumber.api.DataTable;
import cucumber.api.java.*;;
import cucumber.api.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import pageobj.*;

import java.io.File;
import java.net.URL;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Map;
import java.util.Properties;

public class StepDefinitions {

    WebDriver driver=null;
    MainPageObject main=null;
    DataInputPage input=null;
    ResultPage result=null;
    NumberFormat nf= null;

    @Before
    public void setUp() throws Exception {

        System.setProperty("webdriver.chrome.driver", "/Users/admin/Desktop/CucumberSelenium/Generic/src/main/resources/chromedriver");
        //driver=new ChromeDriver();

        //final String USERNAME="riz_mamura";
        //final String ACCESS_KEY="cfbe4bb9-aae8-45b9-9924-ea0992586dd9";
        //final String url="http://"+USERNAME+":"+ACCESS_KEY+"@ondemand.saucelabs.com:80/wd/hub";

        //final String USERNAME="azizjonrizayev1";
        //final String ACCESS_KEY="nGLbBRYipRxRZumrHk7w";
        //final String url="http://"+USERNAME+":"+ACCESS_KEY+"@hub.browserstack.com/wd/hub";


        /*final String KEY="836547c630ee883ab3e0994c4315957e";
        final String SECRET="2362691a51bd1364d44a738330f7f499";
        final String url="http://"+KEY+":"+SECRET+"@hub.testingbot.com/wd/hub";*/


        //Properties prop=System.getProperties ();
        //prop.list(System.out);


        final String url="http://localhost:4444/wd/hub";


        DesiredCapabilities cap= new DesiredCapabilities();
        cap.setBrowserName("chrome");
        cap.setPlatform(Platform.MAC);


        driver=new RemoteWebDriver(new URL(url), cap);

        main=new MainPageObject(driver);
        input=new DataInputPage(driver);
        result=new ResultPage(driver);
        nf=NumberFormat.getCurrencyInstance();

        driver.get("http://www.paycheckcity.com/");
        WebDriverWait wait=new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(main.btn_SalaryCalculator));

        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    public static void clearAndFill(WebElement element, CharSequence value){
        element.clear();
        element.sendKeys(value);
    }

    public static double convertToDouble(WebElement element) throws ParseException{

        double result=0;

        NumberFormat nf=NumberFormat.getCurrencyInstance();
        Number raw=nf.parse(element.getText());

        if(!(raw instanceof Double)){
            result=raw.doubleValue();
        }

        result=(double)raw;

        return result;
    }

    @Given("^Click on the 'Salary Calculator' button$")
    public void click_on_the_Salary_Calculator_button() throws Throwable {
        //File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //org.apache.commons.io.FileUtils.copyFile(file, new File("/Users/admin/Desktop/scsh.png"));
        main.btn_SalaryCalculator.click();
    }

    @When("^Fields are filled with following table:$")
    public void fields_are_filled_with_following_table(DataTable arg1) throws Throwable {

        Map<String,String> map=arg1.asMap(String.class, String.class);

        clearAndFill(input.date, map.get("Date"));
        clearAndFill(input.state, map.get("State"));
        clearAndFill(input.gross, map.get("Gross"));
        clearAndFill(input.type, map.get("PayType"));
        clearAndFill(input.frequency, map.get("PayFrequency"));
        clearAndFill(input.status, map.get("FilingStatus"));
        clearAndFill(input.allowances, map.get("Allowances"));

    }

    @When("^Click button 'Calculate'$")
    public void click_button_Calculate() throws Throwable {
        //File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //org.apache.commons.io.FileUtils.copyFile(file, new File("/Users/admin/Desktop/input.png"));
        input.btnCalc.click();
    }

    @When("^Wait untill the result page loads$")
    public void wait_untill_the_result_page_loads() throws Throwable {
        WebDriverWait wait=new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(result.newCalc));
    }

    @Then("^Result should be as follows:$")
    public void result_should_be_as_follows(DataTable arg1) throws Throwable {

        Map<String, Double> res=arg1.asMap(String.class, Double.class);
        NumberFormat nf=NumberFormat.getCurrencyInstance();

        Assert.assertEquals(nf.parse(result.gross.getText()).doubleValue(), res.get("GrossPay"), 1);
        Assert.assertEquals(nf.parse(result.federal.getText()).doubleValue(), res.get("FedTax"), 1);
        Assert.assertEquals(nf.parse(result.ssn.getText()).doubleValue(), res.get("SSN"), 1);
        Assert.assertEquals(nf.parse(result.medicare.getText()).doubleValue(), res.get("Medicare"), 1);
        Assert.assertEquals(nf.parse(result.state.getText()).doubleValue(), res.get("StateTax"), 1);

        //File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //org.apache.commons.io.FileUtils.copyFile(file, new File("/Users/admin/Desktop/result.png"));

    }

}
