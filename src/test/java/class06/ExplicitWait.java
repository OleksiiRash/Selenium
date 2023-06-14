package class06;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class ExplicitWait extends CommonMethods {
    public static void main(String[] args) throws InterruptedException {

        String url = "https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver";
        openBrowserGetURL(url, "chrome");

        /*
        click on enable button after 10 seconds
        and then click on the button
        assumption we don't know that what is the time for it to get enabled
        */

        // Task 1
        var enableBtn10Sec = driver.findElement(By.xpath("//button[@id='enable-button']"));
        enableBtn10Sec.click();

        var waitAlert = new WebDriverWait(driver, Duration.ofSeconds(30)); // we are declare the object of the WebDriverWait
        waitAlert.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Button']")));

        var enableBtn10SecVisible = driver.findElement(By.xpath("//button[text()='Button']"));

        if (enableBtn10SecVisible.isEnabled()) {
            enableBtn10SecVisible.click();
            System.out.println("button is enables and clickable");
        } else {
            System.out.println("not visible button");
        }

        // Task 2
        var openAlertBtn = driver.findElement(By.xpath("//button[@id='alert']"));
        openAlertBtn.click();

        waitAlert.until(ExpectedConditions.alertIsPresent()); // wait until - we use the predefined condition

        var confirmAlert = driver.switchTo().alert();

        if (confirmAlert.getText().equalsIgnoreCase("I got opened after 5 secods")) {
            System.out.println("alert appeared - all is good");
        } else {
            System.out.println("alert not appeared");
        }

        confirmAlert.accept();


    }
}
