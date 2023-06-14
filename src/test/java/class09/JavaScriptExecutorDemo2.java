package class09;

import Utlis.CommonMethods;
import Utlis.ConfigReader;
import Utlis.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openxmlformats.schemas.drawingml.x2006.main.ThemeDocument;

public class JavaScriptExecutorDemo2 extends CommonMethods {
    public static void main(String[] args) throws InterruptedException {

        String url = "https://www.amazon.com/";
        openBrowserGetURL(url, "chrome");

        // perform the scroll using the jsExecutor

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //scroll down
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0, 500)"); // we scroll down using the JS
        //scroll up
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0, -500)"); // we scroll down using the JS

        var action = new Actions(driver);
        var dropDownBoxSearch = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        action.click(dropDownBoxSearch).perform();


    }
}
