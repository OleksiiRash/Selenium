package class06.homework;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Task1 extends CommonMethods {
    public static void main(String[] args) {

/*
goto: http://practice.syntaxtechs.net/dynamic-elements-loading.php
click on start
print the text "welcome syntax technologies "on console
*/

        String url = "http://practice.syntaxtechs.net/dynamic-elements-loading.php";
        openBrowserGetURL(url, "chrome");

        driver.findElement(By.xpath("//button[text()='Start']")).click();
        var wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h4[text()='Welcome Syntax Technologies']")));
        var text = driver.findElement(By.xpath("//h4[text()='Welcome Syntax Technologies']"));

        if (text.isDisplayed()) {
            System.out.println("element presented");
        } else {
            System.out.println("element not found");
        }

        System.out.println(text.getText());


    }
}
