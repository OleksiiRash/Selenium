package class09;

import Utlis.CommonMethods;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class ScreenShot extends CommonMethods {
    public static void main(String[] args) throws IOException {

        String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";
        openBrowserGetURL(url, "chrome");

        WebElement loginBtn = driver.findElement(By.xpath("//input[@id='btnLogin']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", loginBtn);

        takeScreenshot("testSyntax.png");



    }
}
