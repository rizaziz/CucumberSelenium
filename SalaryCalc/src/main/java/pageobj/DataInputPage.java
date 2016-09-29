package pageobj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DataInputPage {

    @FindBy(id="calcDate")
    public WebElement date;

    @FindBy(id="state")
    public WebElement state;

    @FindBy(id="generalInformation.grossPayAmount")
    public WebElement gross;

    @FindBy(id="generalInformation.grossPayMethodType")
    public WebElement type;

    @FindBy(id="generalInformation.payFrequencyType")
    public WebElement frequency;

    @FindBy(id="generalInformation.federalFilingStatusType")
    public WebElement status;

    @FindBy(id="generalInformation.federalAllowances")
    public WebElement allowances;

    @FindBy(id="calculate")
    public WebElement btnCalc;

    @FindBy(id="clear")
    public WebElement btnClear;

    public DataInputPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
