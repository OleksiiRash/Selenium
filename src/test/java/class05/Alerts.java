package class05;

import Utlis.CommonMethods;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Alerts extends CommonMethods {

    public static void main(String[] args) throws InterruptedException {

        String url = "http://practice.syntaxtechs.net/javascript-alert-box-demo.php";
        openBrowserGetURL(url, "chrome");


        var jsAlertButton1 = driver.findElement(By.cssSelector("button[onclick='myAlertFunction()']"));
        jsAlertButton1.click();
        var confirmationAlert1 = driver.switchTo().alert(); // switch the focus of the driver to the alert pop-up element
        confirmationAlert1.accept(); // we can accept, dismiss, send keys... etc.

        var jsAlertButton2 = driver.findElement(By.cssSelector("button[onclick='myConfirmFunction()']"));
        jsAlertButton2.click();
        var confirmationAlert2 = driver.switchTo().alert();
        confirmationAlert2.accept();

        // homework class 05
        var jsAlertButton3 = driver.findElement(By.cssSelector("button[onclick='myPromptFunction()']"));
        jsAlertButton3.click();
        var confirmationAlert3 = driver.switchTo().alert();
        confirmationAlert3.sendKeys("Oleksii");
        confirmationAlert3.accept();


    }
}
