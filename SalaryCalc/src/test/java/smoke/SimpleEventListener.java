package smoke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

/**
 * Created by admin on 10/6/16.
 */
public class SimpleEventListener extends AbstractWebDriverEventListener {

    @Override
    public void beforeNavigateTo(String url, WebDriver driver){
        System.out.println("Before navigate to some url jlkdjflkdsjaflkjadlkfjalkdsjf dkfjalkdfjalkdjfasd " +
                "lkadfakjdhfjkadhfjkasd jhfakjhdfkjahdfjkad jadjfhakjdhfkjadfkadhfjahdkjfad");
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver){
        System.out.println("Before navigate to some url jlkdjflkdsjaflkjadlkfjalkdsjf dkfjalkdfjalkdjfasd " +
                "lkadfakjdhfjkadhfjkasd jhfakjhdfkjahdfjkad jadjfhakjdhfkjadfkadhfjahdkjfad");
    }

}