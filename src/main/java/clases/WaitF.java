package clases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitF {
    public static WebElement waitElement(WebDriver driver, By locator, Duration timeoutInSeconds, String vision) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);

        return switch (vision) {
            case "click" -> wait.until(ExpectedConditions.elementToBeClickable(locator));
            case "vis" -> wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            default -> null;
        };
    }

    public static void waitForInvisibilityOfElement(WebDriver driver, By locator, Duration timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void waitForNothing(WebDriver driver, Duration time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until((WebDriver d) -> true);

    }
}


