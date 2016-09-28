package smoke;

import config.BaseConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobj.MainPageObject;

public class MainPageSmokeTest extends BaseConfiguration{

    private MainPageObject mpo=null;

    @BeforeClass(description = "Initialize page object")
    public void init(){
        mpo=new MainPageObject(driver);
    }

    @AfterMethod
    public void goToMainPage(){
        driver.navigate().back();
    }

    @Test(description = "Click on Salary Calculator Button")
    public void clickOnSalaryCalculator(){
        mpo.btn_SalaryCalculator.click();
        Assert.assertEquals(driver.getCurrentUrl(), "http://www.paycheckcity.com/calculator/salary/");
    }

    @Test(description = "Click on Hourly Calculator Button")
    public void clickOnHourlyCalculator(){
        mpo.btn_HourlyCalculator.click();
        Assert.assertEquals(driver.getCurrentUrl(), "http://www.paycheckcity.com/calculator/hourly/");
    }

}
