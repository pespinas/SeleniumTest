package clases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Action {
    public static void clickEnlacePorTexto(WebDriver driver, String tEnlace) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement enlace = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(), '" + tEnlace + "')]")));
        enlace.click();
    }

    public static void wsText(WebDriver driver, String textInput, String textSearch, String Ellugar){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement textArea = switch (Ellugar) {
            case "Destino" ->
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[contains(@placeholder, '" + textInput + "')])[2]")));
            case "Origen" ->
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[contains(@placeholder, '" + textInput + "')])[1]")));
            default -> throw new IllegalArgumentException("Valor inesperado para Ellugar: " + Ellugar);
        };
        textArea.click();

        WebElement menuDesplegable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='cities-sugestion-popup_list']")));

        WebElement optionToClick = menuDesplegable.findElement(By.xpath("//ul[contains(@class, 'cities-sugestion-popup_list')]//vy-airports-li/li[contains(text(), '" + textSearch + "')]"));

        optionToClick.click();
    }
}
