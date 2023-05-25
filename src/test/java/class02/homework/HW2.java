package class02.homework;

import Utlis.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HW2 extends CommonMethods {

    public static void main(String[] args) {

        HW2.openBrowserGetURL("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.findElement(By.cssSelector("input[name='txtUsername']")).sendKeys("AlexR");
        driver.findElement(By.cssSelector("input[value='LOGIN']")).click();
        // check the error and verifying it
        WebElement error = driver.findElement(By.cssSelector("span[id='spanMessage']"));
        System.out.println(error.getText());
        if (error.getText().contains("Password cannot be empty")) {
            System.out.println("correct error is displayed");
        } else {
            System.out.println("not correct error");
        }

        HW2.closeBrowser();


    }
}
