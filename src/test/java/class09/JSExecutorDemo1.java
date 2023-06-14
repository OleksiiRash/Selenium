package class09;

import Utlis.CommonMethods;
import Utlis.ConfigReader;
import Utlis.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JSExecutorDemo1 extends CommonMethods {
    public static void main(String[] args) {

        ConfigReader.getProperties(Constants.CONFIG_READER_PATH);
        var url = ConfigReader.getProperty("URL2");
        openBrowserGetURL(url, "chrome");

        var userNameTxtBox = driver.findElement(By.xpath("//input[@id='txtUsername']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid blue'", userNameTxtBox);


    }
}
