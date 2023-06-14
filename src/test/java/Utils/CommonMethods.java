package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void sendText(String text, WebElement element) {
        element.clear();
        element.sendKeys(text);
    }

    //method to select from dropdown(single select)
    public static void dropDownSelect(WebElement element, String byVisibleText) {
        var object = new Select(element);
        object.selectByVisibleText(byVisibleText);
        //System.out.println("DropDown selected Element is: " + byVisibleText);
    }

    // method for taking the screenshots
    public static void takeScreenshot(String name) {
        var ts = (TakesScreenshot) driver;
        var file = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(file, new File(Constants.SCREENSHOT_FOLDER_PATH + name));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}