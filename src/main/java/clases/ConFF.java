package clases;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;

public class ConFF {
    public static WebDriver setupWebDriver() {
        Properties properties = new Properties();
        try {
            properties.load(ConFF.class.getResourceAsStream("/automation.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String serverPath = properties.getProperty("ServerPath");
        String browser = properties.getProperty("Browser");

//        String driverPath = "src/main/resources/chromedriver_win32/chromedriver.exe";
//        System.setProperty("webdriver.chrome.driver", driverPath);

        WebDriver driver = null;
        if ("chrome".equalsIgnoreCase(browser)) {
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
        } else {
            System.out.println("Browser not supported");
            System.exit(1);
        }
        driver.get(serverPath);
        return driver;
    }
}
