package Utlis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class CommonMethods {

    public static WebDriver driver;
    public static ChromeOptions optionsChrome;
    public static FirefoxOptions optionsFireFox;

    public static void openBrowserGetURL(String url, String browser) {

        switch (browser) {
            case "chrome":
                optionsChrome = new ChromeOptions();
                // set language
                optionsChrome.addArguments("--lang=en");
                //  create instance
                driver = new ChromeDriver(optionsChrome);
                break;

            case "firefox":
                optionsFireFox = new FirefoxOptions();
                // set language
                optionsFireFox.addArguments("--lang=en");
                //  create instance
                driver = new FirefoxDriver(optionsFireFox);
                break;
        }

        // maximize the screen
        driver.manage().window().maximize();
        // navigate to url
        driver.get(url);

    }

    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

}