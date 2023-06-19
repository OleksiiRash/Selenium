package class09;

import Utils.CommonMethods;
import org.openqa.selenium.*;

import java.io.IOException;

public class ScreenShot extends CommonMethods {
    public static void main(String[] args) throws IOException {

        var url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";
        openBrowserGetURL(url, "chrome");

        var loginBtn = driver.findElement(By.xpath("//input[@id='btnLogin']"));

        var js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", loginBtn);

        takeScreenshot("testSyntax");
        closeBrowser();


    }
}
