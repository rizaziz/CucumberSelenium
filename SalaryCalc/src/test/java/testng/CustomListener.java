package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

/**
 * Created by admin on 10/10/16.
 */
public class CustomListener extends AbstractWebDriverEventListener {

    @Override
    public void beforeNavigateTo(String url, WebDriver driver){

        System.out.println("navigating to "+url);

    }
}
