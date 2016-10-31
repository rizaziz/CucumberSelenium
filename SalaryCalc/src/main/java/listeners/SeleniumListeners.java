package listeners;


import loggin.LoggingExample;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class SeleniumListeners implements WebDriverEventListener {

    Logger logger= LoggingExample.log;

    @Override
    public void beforeNavigateTo(String s, WebDriver webDriver) {
        logger.fatal(s);
    }

    @Override
    public void afterNavigateTo(String s, WebDriver webDriver) {
        logger.fatal(s);
    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {
        logger.fatal("Navigatig Back");
    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {
        logger.fatal("After navigating back");
    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {
        logger.fatal("befor navigating forward");
    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {
        logger.fatal("after navigating forward");
    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {
        logger.fatal("befor Navigating refresh");
    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {
        logger.fatal("after navigate refresh");
    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        logger.fatal(webElement);
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        logger.fatal(webDriver);
    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        logger.fatal(webDriver);
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        logger.fatal(webDriver);
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver) {
        logger.fatal(webDriver);
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver) {
        logger.fatal(webDriver);
    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) {
        logger.fatal(webDriver);
    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {
        logger.fatal(webDriver);
    }

    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {
        logger.fatal(webDriver);
    }
}
