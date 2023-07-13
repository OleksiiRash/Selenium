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


    //method for the implicitWait set-up
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


    //single checkbox method and boolean implicitWait
    //Example: WebElement variable = driver.findElement...
    public static void singleCheckBox(WebElement variable, boolean enableImplicitWait) {
        if (enableImplicitWait) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

        if (!variable.isSelected()) {
            variable.click();
        }
    }

    //multiply checkbox selection and option to select all checkboxes
    //Example: List<WebElement> variable = driver.findElements...
    //Example: List<String> attributeValuesToSelect = Arrays.asList("Option-2", "Option-4");
    public static void checkBoxMultiple(List<WebElement> variable, List<String> attributeValuesToSelect, boolean selectAllOrNot) {
        for (var select : variable) {
            var codeValue = select.getAttribute("value");
            if (select.isSelected()) {
                select.clear();
            } else if (selectAllOrNot || attributeValuesToSelect.contains(codeValue)) {
                select.click();
                //break;
            }
        }
    }


    //method to select from dropdown(single select)
    public static void dropDownSelect(WebElement element, String byVisibleText) {
        var object = new Select(element);
        object.selectByVisibleText(byVisibleText);
    }

    //method for multiply drop-down selection and select all options at once
    public static void multiplyDropDown(WebElement variable, List<String> attributeValuesToSelect, boolean selectAll) {
        var obj = new Select(variable);
        var options = obj.getOptions();
        for (var option : options) {
            var optionText = option.getText();
            if (attributeValuesToSelect.contains(optionText) || selectAll) {
                option.click();
                //break;
            }
        }
    }



}