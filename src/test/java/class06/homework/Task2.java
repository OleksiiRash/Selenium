package class06.homework;

import Utlis.CommonMethods;
import org.openqa.selenium.By;

public class Task2 extends CommonMethods {
    public static void main(String[] args) {

/*
goto http://practice.syntaxtechs.net/dynamic-data-loading-demo.php
click on get new user
print the firstname of user
*/

        String url = "http://practice.syntaxtechs.net/dynamic-data-loading-demo.php";
        openBrowserGetURL(url, "chrome");

        // implemented the implicit wait inside the CommonMethods
        driver.findElement(By.xpath("//button[text()='Get New User']")).click();
        var granName = driver.findElement(By.xpath("//*[contains(text(), 'First Name')]"));
        System.out.println(granName.getText());



    }
}
