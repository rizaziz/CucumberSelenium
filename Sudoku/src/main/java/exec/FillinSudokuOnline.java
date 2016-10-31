package exec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import repository.SudokuPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by admin on 10/18/16.
 */
public class FillinSudokuOnline {

    static WebDriver driver=null;
    static SudokuPage page=null;

    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver", "/Programs/selenium/drivers/chromedriver");

        driver=new ChromeDriver();

        page=new SudokuPage(driver);
        PageFactory.initElements(driver,page);

        driver.get("http://websudoku.com");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.manage().window().maximize();


        //WebElement table=driver.findElement(By.id("puzzle_grid"));

        //String str=table.getAttribute("class");

        //System.out.println(str);

        List<WebElement> clearBtn=driver.findElements(By.tagName("input"));
        for(WebElement elem: clearBtn){
            System.out.println(elem);
        }

        //clearBtn.click();

        driver.quit();






    }
}
