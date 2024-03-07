package clases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Cookies {
    public static void acceptCookies(WebDriver driver, String cook){
        WebElement acceptButton = driver.findElement(By.id(cook));
        acceptButton.click();
    }

}
