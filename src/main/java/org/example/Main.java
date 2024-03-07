package org.example;
import clases.Action;
import clases.ConFF;
import clases.Cookies;
import clases.WaitF;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        WebDriver driver = ConFF.setupWebDriver();

        Cookies.acceptCookies(driver,"L2AGLb");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WaitF.waitForInvisibilityOfElement(driver, By.className("gowsYd"), Duration.ofSeconds(10));
        WebElement search = driver.findElement(By.name("q"));
        search.click();

        search.sendKeys("Vueling");
        WebElement searchButton= WaitF.waitElement(driver, By.name("btnK"), Duration.ofSeconds(5), "click");
        searchButton.click();

        Action.clickEnlacePorTexto(driver, "Vueling: vuelos baratos");

        WaitF.waitElement(driver, By.id("onetrust-accept-btn-handler"), Duration.ofSeconds(10), "vis");
        Cookies.acceptCookies(driver,"onetrust-accept-btn-handler");
        Action.wsText(driver, "Ciudad, país o aeropuerto", "Burdeos", "Destino");



    }
}