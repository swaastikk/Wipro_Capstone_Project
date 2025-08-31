package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.FrameworkConstants;

public class WaitUtils {

    
    // user Wait until the element is visible code here
    public static WebElement waitForVisibility(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    // user Wait until the element located by a locator is visible code here
    public static WebElement waitForVisibility(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    // user Wait until the element is clickable code here
    public static WebElement waitForClickability(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
     // user Wait until the element is present in DOM code here
    public static WebElement waitForPresence(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
     // user Wait until the element disappears code here
    public static boolean waitForInvisibility(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
 	//Custom wait with timeout code here
    public static WebElement waitForVisibility(WebDriver driver, WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}
