package Utlis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CommonMethods {

    public static WebDriver driver;
    public static ChromeOptions options;

    public static void openBrowserGetURL(String url) {
        // set language
        options = new ChromeOptions();
        options.addArguments("--lang=en");
        //  create instance
        driver = new ChromeDriver(options);
        // navigate to url
        driver.get(url);
        // maximize the screen
        driver.manage().window().maximize();

    }

    public static void closeBrowser() {
        driver.quit();
    }
}