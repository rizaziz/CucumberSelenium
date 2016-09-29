package pageobj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultPage {

    @FindBy(xpath=".//*[@id='dijit_TitlePane_0_pane']/ul/li[1]/div/span[2]")
    public WebElement gross;

    @FindBy(xpath=".//*[@id='dijit_TitlePane_0_pane']/ul/li[2]/div/span[2]")
    public WebElement federal;

    @FindBy(xpath=".//*[@id='dijit_TitlePane_0_pane']/ul/li[3]/div/span[2]")
    public WebElement ssn;

    @FindBy(xpath=".//*[@id='dijit_TitlePane_0_pane']/ul/li[4]/div/span[2]")
    public WebElement medicare;

    @FindBy(xpath=".//*[@id='dijit_TitlePane_0_pane']/ul/li[5]/div/span[2]")
    public WebElement state;

    @FindBy(xpath=".//*[@id='dijit_TitlePane_0_pane']/ul/li[6]/div/span[2]")
    public WebElement sui;

    @FindBy(xpath=".//*[@id='dijit_TitlePane_1_pane']/ul/li/div/span[2]")
    public WebElement net;

    public ResultPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
