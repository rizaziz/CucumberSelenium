package cucumber.stepdef;

import cucumber.api.PendingException;
import cucumber.api.java.*;
import cucumber.api.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageobj.*;

import java.util.concurrent.TimeUnit;


public class StepDefinitions {

    WebDriver driver=null;
    MainPageObject main=null;
    DataInputPage input=null;
    ResultPage result=null;

    @Before
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "/Users/admin/Desktop/CucumberSelenium/Generic/src/main/resources/chromedriver");
        driver=new ChromeDriver();

        driver.get("http://www.paycheckcity.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        main=new MainPageObject(driver);
        input=new DataInputPage(driver);
        result=new ResultPage(driver);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Given("^click the salary calculator button$")
    public void click_the_salary_calculator_button() throws Throwable {
        main.btn_SalaryCalculator.click();
    }

    @When("^put checkdate as (\\d+)\\.(\\d+)\\.(\\d+)$")
    public void put_checkdate_as(int arg1, int arg2, int arg3) throws Throwable {
        input.date.clear();
        input.date.sendKeys("10/01/2016");
    }

    @When("^put state as Pennsylvania$")
    public void put_state_as_Pennsylvania() throws Throwable {
        input.state.clear();
        input.state.sendKeys("Pennsylvania");
    }

    @When("^put grosspay as (\\d+)$")
    public void put_grosspay_as(int arg1) throws Throwable {
        input.gross.clear();
        input.gross.sendKeys("100000");
    }

    @When("^put grosspaytype as Annual$")
    public void put_grosspaytype_as_Annual() throws Throwable {
        input.type.clear();
        input.type.sendKeys("Annually");
    }

    @When("^put Pay frequency as Bi-weekly$")
    public void put_Pay_frequency_as_Bi_weekly() throws Throwable {
        input.frequency.clear();
        input.frequency.sendKeys("Bi-weekly");
    }

    @When("^put federal finling status as married$")
    public void put_federal_finling_status_as_married() throws Throwable {
        input.status.clear();
        input.status.sendKeys("Married");
    }

    @When("^put number of allowances as (\\d+)$")
    public void put_number_of_allowances_as(int arg1) throws Throwable {
        input.allowances.clear();
        input.allowances.sendKeys("4");
    }

    @When("^click on button calculate$")
    public void click_on_button_calculate() throws Throwable {
        input.btnCalc.click();
    }

    @When("^wait till the result page loads$")
    public void wait_till_the_result_page_loads() throws Throwable {
        try{
            Thread.sleep(10000);
        }catch(InterruptedException e){}
    }

    @Then("^Bi-weekly gross pay is (\\d+)\\.(\\d+)$")
    public void bi_weekly_gross_pay_is(int arg1, int arg2) throws Throwable {
        Assert.assertEquals(result.gross.getText(), "$3,846.15");
    }

    @Then("^Federal withholding is (\\d+)\\.(\\d+)$")
    public void federal_withholding_is(int arg1, int arg2) throws Throwable {
        Assert.assertEquals(result.federal.getText(), "$398.46");
    }
    @Then("^Social security is (\\d+)\\.(\\d+)$")
    public void social_security_is(int arg1, int arg2) throws Throwable {
        Assert.assertEquals(result.ssn.getText(), "$238.46");
    }

    @Then("^Medicare is (\\d+)\\.(\\d+)$")
    public void medicare_is(int arg1, int arg2) throws Throwable {
        Assert.assertEquals(result.medicare.getText(), "$55.77");
    }

    @Then("^Pennsylvania tax is (\\d+)\\.(\\d+)$")
    public void pennsylvania_tax_is(int arg1, int arg2) throws Throwable {
        Assert.assertEquals(result.state.getText(), "$118.08");
    }

    @Then("^SUI is (\\d+)\\.(\\d+)$")
    public void sui_is(int arg1, int arg2) throws Throwable {
        Assert.assertEquals(result.sui.getText(), "$2.69");
    }
}
