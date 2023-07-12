package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

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


    public static void implicitWait(int sec) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
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
            FileUtils.copyFile(file, new File(Constants.SCREENSHOT_FOLDER_PATH + name + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void singleCheckBox(WebElement name) {
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
        if (!name.isSelected()) {
            name.click();
        }
    }

    //single checkbox selection and implicit wait in one method
    public static void singleCheckBoxWait(WebElement name, int sec) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
        if (!name.isSelected()) {
            name.click();
        }
    }

    //multiply checkbox selection
    public static void checkBoxMultiple(List<WebElement> variable, List<String> valuesToSelect, boolean selectAllOrNot) {
        for (var select : variable) {
            var codeValue = select.getAttribute("value");
            if (select.isSelected()) {
                select.clear();
            } else if (selectAllOrNot || valuesToSelect.contains(codeValue)) {
                select.click();
                //break;
            }
        }
    }


}