package exec;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * Created by admin on 10/19/16.
 */
public class SudokuOnlineExample {

    private static WebDriver driver=null;

    public static void main(String[] args){


        //System.setProperty("webdriver.chrome.driver", "/Programs/selenium/drivers/chromedriver");
        System.setProperty("webdriver.gecko.driver", "/Programs/selenium/drivers/geckodriver");
        //driver=new ChromeDriver();
        driver=new FirefoxDriver();


        driver.get("http://websudoku.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.switchTo().frame(0);

        WebElement element=driver.findElement(By.name("clear"));

        WebElement table=driver.findElement(By.id("puzzle_grid"));
        System.out.println(table.getAttribute("class"));

        System.out.println(table.findElement(By.id("f00")).getAttribute("class"));


        WebElement f00=table.findElement(By.id("f00"));
        System.out.println("first digit: "+f00.getAttribute("value")+" "+(f00.getAttribute("value")==null));

        WebElement f10=table.findElement(By.id("f10"));
        System.out.println("second digit: "+f10.getAttribute("value")+" "+(f10.getAttribute("value")==null));

        WebElement f20=table.findElement(By.id("f20"));
        System.out.println("third digit: "+f20.getAttribute("value")+" "+(f20.getAttribute("value")==null));

        //WebElement row=driver.findElement(By.cssSelector("#puzzle_grid:nth-child(2)"));
        //WebElement cell=row.findElement(By.cssSelector(":nth-child(2)"));

        WebElement cell21=driver.findElement(By.id("f01"));
        WebElement cell22=driver.findElement(By.id("f11"));
        WebElement cell23=driver.findElement(By.id("f21"));

        //WebElement cell31=driver.findElement(By.cssSelector("#puzzle_grid>tr:nth-child(3)>td:nth-child(1)"));
        //WebElement cell32=driver.findElement(By.cssSelector("#puzzle_grid>tr:nth-child(3)>td:nth-child(2)"));
        //WebElement cell33=driver.findElement(By.cssSelector("#puzzle_grid>tr:nth-child(3)>td:nth-child(3)"));


        Actions builder=new Actions(driver);




        //cell31.sendKeys("2");
        //cell32.sendKeys("2");
        //cell33.sendKeys("2");

        System.out.println("cel21: "+cell21.getAttribute("value")+" length: "+cell21.getAttribute("value").length()+" chars: "+ Arrays.toString(cell21.getAttribute("value").toCharArray()));
        System.out.println("cel22: "+cell22.getAttribute("value")+" length: "+cell22.getAttribute("value").length()+" chars: "+ Arrays.toString(cell22.getAttribute("value").toCharArray()));
        System.out.println("cel23: "+cell23.getAttribute("value")+" length: "+cell23.getAttribute("value").length()+" chars: "+ Arrays.toString(cell23.getAttribute("value").toCharArray()));



        cell21.sendKeys("1");
        cell22.sendKeys("1");
        cell23.sendKeys("1");


        if(true){
            f00.sendKeys("1");
            //builder.click(f00);
            //builder.keyDown(Keys.NUMPAD1);
            //builder.keyUp(Keys.NUMPAD1);
            //builder.build().perform();
        }

        if(true){
            f10.sendKeys("1");
            //builder.click(f10);
            //builder.keyDown(Keys.NUMPAD1);
            //builder.keyUp(Keys.NUMPAD1);
            //builder.build().perform();
        }

        if(true){
            f20.sendKeys("1");
            //builder.click(f20);
            //builder.keyDown(Keys.NUMPAD1);
            ///builder.keyUp(Keys.NUMPAD1);
           // builder.build().perform();
        }




    }

}
