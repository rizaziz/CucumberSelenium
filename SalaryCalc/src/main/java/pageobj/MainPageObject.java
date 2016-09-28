package pageobj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class MainPageObject {

    private static final String commonPath=".//*[@id='headerContainer']/div/div[2]/div/";

    @FindBy(xpath=commonPath+"div[1]/div[2]")
    public WebElement btn_SalaryCalculator;

    @FindBy(xpath=commonPath+"div[2]/div[2]")
    public WebElement btn_HourlyCalculator;

    @FindBy(xpath=commonPath+"div[3]/div[2]")
    public WebElement btn_W4Assistant;

    @FindBy(xpath=commonPath+"div[4]/div[2]")
    public WebElement btn_GrossUpCalculator;

    @FindBy(xpath=commonPath+"div[5]/div[2]")
    public WebElement btn_BonusPayPersent;

    @FindBy(xpath=commonPath+"div[6]/div[2]")
    public WebElement btn_BonusPayAggregate;

    @FindBy(xpath=commonPath+"div[7]/div[2]")
    public WebElement btn_401KCalculator;

    @FindBy(xpath=commonPath+"div[8]/div[2]")
    public WebElement btn_DualScenarioSalary;

    @FindBy(xpath=commonPath+"div[9]/div[2]")
    public WebElement btn_DualScenarioHourly;

    public MainPageObject(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public static void main(String[] args) throws Exception {
        Map<String, String> env=System.getenv();

        for(Map.Entry<String, String> entry:env.entrySet()){
            System.out.println(entry);


        }


    }
}
