package class05.homework;

import Utils.CommonMethods;
import org.openqa.selenium.By;

public class Task1 extends CommonMethods {
    public static void main(String[] args) {

        String url = "http://practice.syntaxtechs.net/javascript-alert-box-demo.php";
        openBrowserGetURL(url, "chrome");

        var jsAlertButton3 = driver.findElement(By.cssSelector("button[onclick='myPromptFunction()']"));
        jsAlertButton3.click();
        var confirmationAlert3 = driver.switchTo().alert();
        confirmationAlert3.sendKeys("Oleksii");
        confirmationAlert3.accept();

    }
}
