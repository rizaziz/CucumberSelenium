package cucumber.stepdef;


import cucumber.api.DataTable;
import cucumber.api.java.*;;
import cucumber.api.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import pageobj.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Map;

public class StepDefinitions {

    WebDriver driver=null;
    MainPageObject main=null;
    DataInputPage input=null;
    ResultPage result=null;
    NumberFormat nf= null;

    @Before
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "/Users/admin/Desktop/CucumberSelenium/Generic/src/main/resources/chromedriver");
        driver=new ChromeDriver();

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

    @Given("^Click the 'Salary Calculator' button$")
    public void click_the_Salary_Calculator_button() throws Throwable {
        main.btn_SalaryCalculator.click();
    }

    @When("^Clear and fill 'Check Date' field with \"([^\"]*)\"$")
    public void clear_and_fill_Check_Date_field_with(String checkDate) throws Throwable {
        clearAndFill(input.date, checkDate);
    }

    @When("^Clear and fill 'State for withholding' field with \"([^\"]*)\"$")
    public void clear_and_fill_State_for_withholding_field_with(String state) throws Throwable {
        clearAndFill(input.state, state);
    }

    @When("^Clear and fill 'Gross Pay' field with \"([^\"]*)\"$")
    public void clear_and_fill_Gross_Pay_field_with(String grossPay) throws Throwable {
        clearAndFill(input.gross, grossPay);
    }

    @When("^Clear and fill 'Gross Pay Type' field with \"([^\"]*)\"$")
    public void clear_and_fill_Gross_Pay_Type_field_with(String grossPayType) throws Throwable {
        clearAndFill(input.type, grossPayType);
    }

    @When("^Clear and fill 'Pay Frequency' field with \"([^\"]*)\"$")
    public void clear_and_fill_Pay_Frequency_field_with(String payFrequency) throws Throwable {
        clearAndFill(input.frequency, payFrequency);
    }

    @When("^Clear and fill 'Federal Filing Status' field with \"([^\"]*)\"$")
    public void clear_and_fill_Federal_Filing_Status_field_with(String filingStatus) throws Throwable {
        clearAndFill(input.status, filingStatus);
    }

    @When("^Clear and fill '# of Federal Allowances' field with \"([^\"]*)\"$")
    public void clear_and_fill_of_Federal_Allowances_field_with(String numberOfAllowances) throws Throwable {
        clearAndFill(input.allowances, numberOfAllowances);
    }

    @When("^Click on button 'Calculate'$")
    public void click_on_button_Calculate() throws Throwable {
        input.btnCalc.click();
    }

    @When("^Wait till the result page loads$")
    public void wait_till_the_result_page_loads() throws Throwable {
        WebDriverWait wait=new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(result.newCalc));
    }

    @Then("^'Weekly Gross Pay' is \"([^\"]*)\"$")
    public void weekly_Gross_Pay_is(String grossPay) throws Throwable {
        Double actual=nf.parse(result.gross.getText()).doubleValue();
        Double expected=Double.valueOf(grossPay);
        Assert.assertEquals(actual, expected, 1);
    }

    @Then("^'Federal Withholding' is \"([^\"]*)\"$")
    public void federal_Withholding_is(String fedTax) throws Throwable {
        Double actual=nf.parse(result.federal.getText()).doubleValue();
        Double expected=Double.valueOf(fedTax);
        Assert.assertEquals(actual, expected, 1);
    }

    @Then("^'Social Security' is \"([^\"]*)\"$")
    public void social_Security_is(String ssnTax) throws Throwable {
        Double actual=(Double)nf.parse(result.ssn.getText()).doubleValue();
        Double expected=Double.valueOf(ssnTax);
        Assert.assertEquals(actual, expected, 1);
    }

    @Then("^'Medicare' is \"([^\"]*)\"$")
    public void medicare_is(String medicareTax) throws Throwable {
        Double actual=(Double)nf.parse(result.medicare.getText()).doubleValue();
        Double expected=Double.valueOf(medicareTax);
        Assert.assertEquals(actual, expected, 1);
    }

    @Then("^'State' tax is \"([^\"]*)\"$")
    public void state_tax_is(String stateTax) throws Throwable {
        Double actual=(Double)nf.parse(result.state.getText()).doubleValue();
        Double expected=Double.valueOf(stateTax);
        Assert.assertEquals(actual, expected, 1);
    }

    @Given("^Click on the 'Salary Calculator' button$")
    public void click_on_the_Salary_Calculator_button() throws Throwable {
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

    }

}
