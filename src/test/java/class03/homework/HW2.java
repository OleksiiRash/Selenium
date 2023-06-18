package class03.homework;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HW2 extends CommonMethods {

    public static void main(String[] args) {

        HW2.openBrowserGetURL("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login", "firefox");
        driver.findElement(By.cssSelector("input[name='txtUsername']")).sendKeys("AlexR");
        driver.findElement(By.cssSelector("input[value='LOGIN']")).click();
        // check the error and verifying it
        WebElement error = driver.findElement(By.cssSelector("span[id='spanMessage']"));
        var actualErrorMsg = error.getText();
        var expectedErrorMsg = "Password cannot be empty";
        System.out.println("Actual Error is " + actualErrorMsg);

        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "not correct error");
        System.out.println("correct error is displayed");

        HW2.closeBrowser();


    }
}
